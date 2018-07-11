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
public class VehiclesApiController implements VehiclesApi {
                  
        public ResponseEntity<List<Vehicle>> getVehicle() {
    	List<Vehicle> vehicleList = new ArrayList<Vehicle>();
            	ObjectMapper mapper = new ObjectMapper();
      	try {
          InputStream inputStream = this.getClass().getResourceAsStream("/sampleData/Vehicle.json");
          vehicleList = mapper.readValue(inputStream, TypeFactory.defaultInstance().constructCollectionType(List.class, Vehicle.class));
          return new ResponseEntity<List<Vehicle>>(vehicleList, HttpStatus.OK);

  		} catch (JsonParseException e) {
  			e.printStackTrace();
            return new ResponseEntity<List<Vehicle>>(HttpStatus.INTERNAL_SERVER_ERROR);
  		} catch (JsonMappingException e) {
  			e.printStackTrace();
              return new ResponseEntity<List<Vehicle>>(HttpStatus.INTERNAL_SERVER_ERROR);
  		} catch (IOException e) {
  			e.printStackTrace();
              return new ResponseEntity<List<Vehicle>>(HttpStatus.INTERNAL_SERVER_ERROR);
  		}
          }

        public ResponseEntity<Vehicle> getVehicleById(@ApiParam(value = "Path Parameter",required=true) @PathVariable("vin") String vin) {
    	List<Vehicle> vehicleList = new ArrayList<Vehicle>();
            	ObjectMapper mapper = new ObjectMapper();
      	try {
          InputStream inputStream = this.getClass().getResourceAsStream("/sampleData/Vehicle.json");
          vehicleList = mapper.readValue(inputStream, TypeFactory.defaultInstance().constructCollectionType(List.class, Vehicle.class));
          Vehicle neededRecord = new Vehicle();
          Boolean found = false;
          for (Vehicle temp : vehicleList) {
            if(vin.equals(String.valueOf(temp.getVin()))) {
              neededRecord = temp;
              found = true;
              break;
            }
          }
          if(found==true) {
            return new ResponseEntity<Vehicle>(neededRecord,HttpStatus.OK);
          }
          else {
            return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
          }

  		} catch (JsonParseException e) {
  			e.printStackTrace();
            return new ResponseEntity<Vehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
  		} catch (JsonMappingException e) {
  			e.printStackTrace();
              return new ResponseEntity<Vehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
  		} catch (IOException e) {
  			e.printStackTrace();
              return new ResponseEntity<Vehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
  		}
        }
                              public ResponseEntity<Vehicle> putVehicle(@ApiParam(value = "Path Parameter",required=true) @PathVariable("vin") String vin, @ApiParam(value = ""  ) @RequestBody Vehicle vehicle) {
    	List<Vehicle> vehicleList = new ArrayList<Vehicle>();
            	ObjectMapper mapper = new ObjectMapper();
      	try {
          InputStream inputStream = this.getClass().getResourceAsStream("/sampleData/Vehicle.json");
          vehicleList = mapper.readValue(inputStream, TypeFactory.defaultInstance().constructCollectionType(List.class, Vehicle.class));
          Boolean found = false;
          for (int j = vehicleList.size()-1; j >= 0; j--) {
            if(vin.equals(String.valueOf(vehicleList.get(j).getVin()))) {
                vehicleList.remove(j);
              found = true;
              break;
            }
          }
          if(found==true) {
            vehicleList.add(vehicle);
            String jsonString =  mapper.writeValueAsString(vehicleList);
            URL resourceUrl = getClass().getResource("/sampleData/Vehicle.json");
            File file = new File(resourceUrl.toURI());
            OutputStream output = new FileOutputStream(file);
            PrintStream printStream = new PrintStream(output);
            printStream.print(jsonString);
            printStream.close();
            return new ResponseEntity<Vehicle>(vehicle,HttpStatus.OK);
          }
          else {
            return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
          }

  		} catch (JsonParseException e) {
  			e.printStackTrace();
            return new ResponseEntity<Vehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
  		} catch (JsonMappingException e) {
  			e.printStackTrace();
              return new ResponseEntity<Vehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
  		} catch (IOException e) {
  			e.printStackTrace();
              return new ResponseEntity<Vehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
  		}
          catch (URISyntaxException e) {
            e.printStackTrace();
            return new ResponseEntity<Vehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
          }

        }
    
                      public ResponseEntity<Vehicle> postVehicle(@ApiParam(value = ""  ) @RequestBody Vehicle vehicle) {
    	List<Vehicle> vehicleList = new ArrayList<Vehicle>();
            	ObjectMapper mapper = new ObjectMapper();
      	try {
          InputStream inputStream = this.getClass().getResourceAsStream("/sampleData/Vehicle.json");
          vehicleList = mapper.readValue(inputStream, TypeFactory.defaultInstance().constructCollectionType(List.class, Vehicle.class));
          vehicleList.add(vehicle);
        String jsonString =  mapper.writeValueAsString(vehicleList);
        URL resourceUrl = getClass().getResource("/sampleData/Vehicle.json");
        File file = new File(resourceUrl.toURI());
        OutputStream output = new FileOutputStream(file);
        PrintStream printStream = new PrintStream(output);
        printStream.print(jsonString);
        printStream.close();
        return new ResponseEntity<Vehicle>(vehicle,HttpStatus.OK);

  		} catch (JsonParseException e) {
  			e.printStackTrace();
            return new ResponseEntity<Vehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
  		} catch (JsonMappingException e) {
  			e.printStackTrace();
              return new ResponseEntity<Vehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
  		} catch (IOException e) {
  			e.printStackTrace();
              return new ResponseEntity<Vehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
  		}
          catch (URISyntaxException e) {
            e.printStackTrace();
            return new ResponseEntity<Vehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
          }

        }
        
                  public ResponseEntity<Vehicle> patchVehicle(@ApiParam(value = "Path Parameter",required=true) @PathVariable("vin") String vin, @ApiParam(value = ""  ) @RequestBody Patchvehicle vehicle) {
    	List<Vehicle> vehicleList = new ArrayList<Vehicle>();
            	ObjectMapper mapper = new ObjectMapper();
      	try {
          InputStream inputStream = this.getClass().getResourceAsStream("/sampleData/Vehicle.json");
          vehicleList = mapper.readValue(inputStream, TypeFactory.defaultInstance().constructCollectionType(List.class, Vehicle.class));
          Vehicle neededRecord = new Vehicle();
          Boolean found = false;
          for (Vehicle temp : vehicleList) {
            if(vin.equals(String.valueOf(temp.getVin()))) {
              neededRecord = temp;
              found = true;
              break;
            }
          }
          if(found==true) {
            String jsonString =  mapper.writeValueAsString(vehicleList);
            URL resourceUrl = getClass().getResource("/sampleData/Vehicle.json");
            File file = new File(resourceUrl.toURI());
            OutputStream output = new FileOutputStream(file);
            PrintStream printStream = new PrintStream(output);
            printStream.print(jsonString);
            printStream.close();
            return new ResponseEntity<Vehicle>(neededRecord,HttpStatus.OK);
          }
          else {
            return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
          }

  		} catch (JsonParseException e) {
  			e.printStackTrace();
            return new ResponseEntity<Vehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
  		} catch (JsonMappingException e) {
  			e.printStackTrace();
              return new ResponseEntity<Vehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
  		} catch (IOException e) {
  			e.printStackTrace();
              return new ResponseEntity<Vehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
  		}
          catch (URISyntaxException e) {
            e.printStackTrace();
            return new ResponseEntity<Vehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
          }

        }
            
              public ResponseEntity<Vehicle> deleteVehicle(@ApiParam(value = "Path Parameter",required=true) @PathVariable("vin") String vin) {
    	List<Vehicle> vehicleList = new ArrayList<Vehicle>();
            	ObjectMapper mapper = new ObjectMapper();
      	try {
          InputStream inputStream = this.getClass().getResourceAsStream("/sampleData/Vehicle.json");
          vehicleList = mapper.readValue(inputStream, TypeFactory.defaultInstance().constructCollectionType(List.class, Vehicle.class));
          Boolean found = false;
          for (int j = vehicleList.size()-1; j >= 0; j--) {
            if(vin.equals(String.valueOf(vehicleList.get(j).getVin()))) {
                vehicleList.remove(j);
              found = true;
              break;
            }
          }
          if(found==true) {
            String jsonString =  mapper.writeValueAsString(vehicleList);
            URL resourceUrl = getClass().getResource("/sampleData/Vehicle.json");
            File file = new File(resourceUrl.toURI());
            OutputStream output = new FileOutputStream(file);
            PrintStream printStream = new PrintStream(output);
            printStream.print(jsonString);
            printStream.close();
            return new ResponseEntity<Vehicle>(HttpStatus.OK);
          }
          else {
            return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
          }

  		} catch (JsonParseException e) {
  			e.printStackTrace();
            return new ResponseEntity<Vehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
  		} catch (JsonMappingException e) {
  			e.printStackTrace();
              return new ResponseEntity<Vehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
  		} catch (IOException e) {
  			e.printStackTrace();
              return new ResponseEntity<Vehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
  		}
          catch (URISyntaxException e) {
            e.printStackTrace();
            return new ResponseEntity<Vehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
          }

            
    }
                
        

}
