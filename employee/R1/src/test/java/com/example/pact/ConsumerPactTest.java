package com.example.pact;

import com.example.model.*;

import static junit.framework.TestCase.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;
import au.com.dius.pact.model.PactSpecVersion;

public class ConsumerPactTest {

  @Rule
  public PactProviderRule mockProvider = new PactProviderRule("Pact_Provider", "localhost", 8899, PactSpecVersion.V3, this);

  @Pact(provider = "Pact_Provider", consumer = "Pact_Consumer")
  public PactFragment createFragment(PactDslWithProvider builder) {

    ObjectMapper mapper = new ObjectMapper();
    List<Employee> EmployeeList = new ArrayList<Employee>();
    try {
        InputStream inputStream = this.getClass().getResourceAsStream("/sampleData/Employee.json");
        EmployeeList = mapper.readValue(inputStream, TypeFactory.defaultInstance().constructCollectionType(List.class, Employee.class));
        String EmployeeListString =  mapper.writeValueAsString(EmployeeList);
        Employee firstEmployee = EmployeeList.get(0);
        String firstEmployeeString = mapper.writeValueAsString(firstEmployee);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("content-type", "application/json");
        return builder
                                  .uponReceiving("Get All records")
                    .path("/Employees")
                    .method("GET")
                    .body("")
                .willRespondWith()
                    .status(200)
                    .headers(headers)
                    //.body(EmployeeListString)
                              .uponReceiving("Get an existing record")
                    .method("GET")
                    .path("/Employees/"+firstEmployee.getEmpid())
                    .body("")
                .willRespondWith()
                    .status(200)
                    .headers(headers)
                    //.body(firstEmployeeString)
                .uponReceiving("Get Non-existing record")
                    .method("GET")
                    .path("/Employees/NON_EXISTING")
                    .body("")
                .willRespondWith()
                    .status(404)
                    .body("")
                                                                                                            .uponReceiving("Update an existing record")
                    .method("PUT")
                    .path("/Employees/"+firstEmployee.getEmpid())
                    .headers(headers)
                    .body(firstEmployeeString)
                .willRespondWith()
                    .status(200)
                    .headers(headers)
                    //.body(firstEmployeeString)
                .uponReceiving("Update an Non-existing record")
                    .method("PUT")
                    .path("/Employees/NON_EXISTING")
                    .headers(headers)
                    .body(firstEmployeeString)
                .willRespondWith()
                    .status(404)
                    .body("")
                                                                .uponReceiving("Add a new record")
                    .method("POST")
                    .path("/Employees")
                    .headers(headers)
                    .body(firstEmployeeString)
                .willRespondWith()
                    .status(200)
                    .headers(headers)
                    //.body(firstEmployeeString)
                                                                                              .uponReceiving("Delete Non-existing record")
                    .method("DELETE")
                    .path("/Employees/NON_EXISTING")
                .willRespondWith()
                    .status(404)
                                  .toFragment();
            
            } catch (JsonParseException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
  }

  @Test
  @PactVerification("Pact_Provider")
  public void runTest() {

    ObjectMapper mapper = new ObjectMapper();
    List<Employee> EmployeeList = new ArrayList<Employee>();
    try {
        ConsumerAdapter consumer = new ConsumerAdapter("http://localhost:8899");
        InputStream inputStream = this.getClass().getResourceAsStream("/sampleData/Employee.json");
        EmployeeList = mapper.readValue(inputStream, TypeFactory.defaultInstance().constructCollectionType(List.class, Employee.class));
        String EmployeeListString =  mapper.writeValueAsString(EmployeeList);
        Employee firstEmployee = EmployeeList.get(0);
        String firstEmployeeString = mapper.writeValueAsString(firstEmployee);

        ConsumerResponse response = new ConsumerResponse();

                  response = consumer.getEmployees();
        assertEquals(200, response.getStatusCode());
                response = consumer.getEmployeeById(String.valueOf(firstEmployee.getEmpid()).replaceAll(" ", "%20"));
        assertEquals(200, response.getStatusCode());
        
        response = consumer.getEmployeeById("NON_EXISTING");
        assertEquals(404, response.getStatusCode());
                                                              response = consumer.updateEmployee(String.valueOf(firstEmployee.getEmpid()).replaceAll(" ", "%20"), firstEmployeeString);
        assertEquals(200, response.getStatusCode());
        //assertEquals(firstEmployeeString, response.getResponse());

        response = consumer.updateEmployee("NON_EXISTING", firstEmployeeString);
        assertEquals(404, response.getStatusCode());
        assertEquals("", response.getResponse());
                                    response = consumer.addEmployee(firstEmployeeString);
        assertEquals(200, response.getStatusCode());
        //assertEquals(firstEmployeeString, response.getResponse());
                                                      response = consumer.deleteEmployee("NON_EXISTING");
        assertEquals(404, response.getStatusCode());
          
    } catch (JsonParseException e) {
        e.printStackTrace();
    } catch (JsonMappingException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}
