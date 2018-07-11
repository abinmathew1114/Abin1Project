package com.example.api;

import com.example.model.*;
import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.net.URL;

@javax.annotation.Generated(value = "com.example.languages.SpringCodegen", date = "2017-01-25T13:29:39.620Z")

@Controller
public class EmployeesApiController implements EmployeesApi {
                  
        public ResponseEntity<List<Employee>> getEmployee() {
    	List<Employee> EmployeeList = new ArrayList<Employee>();
            	ObjectMapper mapper = new ObjectMapper();
      	try {
          InputStream inputStream = this.getClass().getResourceAsStream("/sampleData/Employee.json");
          EmployeeList = mapper.readValue(inputStream, TypeFactory.defaultInstance().constructCollectionType(List.class, Employee.class));
          return new ResponseEntity<List<Employee>>(EmployeeList, HttpStatus.OK);

  		} catch (JsonParseException e) {
  			e.printStackTrace();
            return new ResponseEntity<List<Employee>>(HttpStatus.INTERNAL_SERVER_ERROR);
  		} catch (JsonMappingException e) {
  			e.printStackTrace();
              return new ResponseEntity<List<Employee>>(HttpStatus.INTERNAL_SERVER_ERROR);
  		} catch (IOException e) {
  			e.printStackTrace();
              return new ResponseEntity<List<Employee>>(HttpStatus.INTERNAL_SERVER_ERROR);
  		}
          }

        public ResponseEntity<Employee> getEmployeeById(@ApiParam(value = "Path Parameter",required=true) @PathVariable("empid") String empid) {
    	List<Employee> EmployeeList = new ArrayList<Employee>();
            	ObjectMapper mapper = new ObjectMapper();
      	try {
          InputStream inputStream = this.getClass().getResourceAsStream("/sampleData/Employee.json");
          EmployeeList = mapper.readValue(inputStream, TypeFactory.defaultInstance().constructCollectionType(List.class, Employee.class));
          Employee neededRecord = new Employee();
          Boolean found = false;
          for (Employee temp : EmployeeList) {
            if(empid.equals(String.valueOf(temp.getEmpid()))) {
              neededRecord = temp;
              found = true;
              break;
            }
          }
          if(found==true) {
            return new ResponseEntity<Employee>(neededRecord,HttpStatus.OK);
          }
          else {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
          }

  		} catch (JsonParseException e) {
  			e.printStackTrace();
            return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
  		} catch (JsonMappingException e) {
  			e.printStackTrace();
              return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
  		} catch (IOException e) {
  			e.printStackTrace();
              return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
  		}
        }
                              public ResponseEntity<Employee> putEmployee(@ApiParam(value = "Path Parameter",required=true) @PathVariable("empid") String empid, @ApiParam(value = ""  ) @RequestBody Employee Employee) {
    	List<Employee> EmployeeList = new ArrayList<Employee>();
            	ObjectMapper mapper = new ObjectMapper();
      	try {
          InputStream inputStream = this.getClass().getResourceAsStream("/sampleData/Employee.json");
          EmployeeList = mapper.readValue(inputStream, TypeFactory.defaultInstance().constructCollectionType(List.class, Employee.class));
          Boolean found = false;
          for (int j = EmployeeList.size()-1; j >= 0; j--) {
            if(empid.equals(String.valueOf(EmployeeList.get(j).getEmpid()))) {
                EmployeeList.remove(j);
              found = true;
              break;
            }
          }
          if(found==true) {
            EmployeeList.add(Employee);
            String jsonString =  mapper.writeValueAsString(EmployeeList);
            URL resourceUrl = getClass().getResource("/sampleData/Employee.json");
            File file = new File(resourceUrl.toURI());
            OutputStream output = new FileOutputStream(file);
            PrintStream printStream = new PrintStream(output);
            printStream.print(jsonString);
            printStream.close();
            return new ResponseEntity<Employee>(Employee,HttpStatus.OK);
          }
          else {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
          }

  		} catch (JsonParseException e) {
  			e.printStackTrace();
            return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
  		} catch (JsonMappingException e) {
  			e.printStackTrace();
              return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
  		} catch (IOException e) {
  			e.printStackTrace();
              return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
  		}
          catch (URISyntaxException e) {
            e.printStackTrace();
            return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
          }

        }
    
                      public ResponseEntity<Employee> postEmployee(@ApiParam(value = ""  ) @RequestBody Employee Employee) {
    	List<Employee> EmployeeList = new ArrayList<Employee>();
            	ObjectMapper mapper = new ObjectMapper();
      	try {
          InputStream inputStream = this.getClass().getResourceAsStream("/sampleData/Employee.json");
          EmployeeList = mapper.readValue(inputStream, TypeFactory.defaultInstance().constructCollectionType(List.class, Employee.class));
          EmployeeList.add(Employee);
        String jsonString =  mapper.writeValueAsString(EmployeeList);
        URL resourceUrl = getClass().getResource("/sampleData/Employee.json");
        File file = new File(resourceUrl.toURI());
        OutputStream output = new FileOutputStream(file);
        PrintStream printStream = new PrintStream(output);
        printStream.print(jsonString);
        printStream.close();
        return new ResponseEntity<Employee>(Employee,HttpStatus.OK);

  		} catch (JsonParseException e) {
  			e.printStackTrace();
            return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
  		} catch (JsonMappingException e) {
  			e.printStackTrace();
              return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
  		} catch (IOException e) {
  			e.printStackTrace();
              return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
  		}
          catch (URISyntaxException e) {
            e.printStackTrace();
            return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
          }

        }
        
              public ResponseEntity<Employee> deleteEmployee(@ApiParam(value = "Path Parameter",required=true) @PathVariable("empid") String empid) {
    	List<Employee> EmployeeList = new ArrayList<Employee>();
            	ObjectMapper mapper = new ObjectMapper();
      	try {
          InputStream inputStream = this.getClass().getResourceAsStream("/sampleData/Employee.json");
          EmployeeList = mapper.readValue(inputStream, TypeFactory.defaultInstance().constructCollectionType(List.class, Employee.class));
          Boolean found = false;
          for (int j = EmployeeList.size()-1; j >= 0; j--) {
            if(empid.equals(String.valueOf(EmployeeList.get(j).getEmpid()))) {
                EmployeeList.remove(j);
              found = true;
              break;
            }
          }
          if(found==true) {
            String jsonString =  mapper.writeValueAsString(EmployeeList);
            URL resourceUrl = getClass().getResource("/sampleData/Employee.json");
            File file = new File(resourceUrl.toURI());
            OutputStream output = new FileOutputStream(file);
            PrintStream printStream = new PrintStream(output);
            printStream.print(jsonString);
            printStream.close();
            return new ResponseEntity<Employee>(HttpStatus.OK);
          }
          else {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
          }

  		} catch (JsonParseException e) {
  			e.printStackTrace();
            return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
  		} catch (JsonMappingException e) {
  			e.printStackTrace();
              return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
  		} catch (IOException e) {
  			e.printStackTrace();
              return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
  		}
          catch (URISyntaxException e) {
            e.printStackTrace();
            return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
          }

            
    }
                
        

}
