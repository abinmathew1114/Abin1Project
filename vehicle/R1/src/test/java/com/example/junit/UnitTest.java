package com.example.junit;

import com.example.*;
import com.example.api.*;
import com.example.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@EnableWebMvc
@ContextConfiguration(classes={VehiclesApiController.class})
public class UnitTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

                
        @Test
        public void getAllRecords() throws Exception {
          ObjectMapper mapper = new ObjectMapper();
          List<Vehicle> vehicleList = new ArrayList<Vehicle>();
          try {
              InputStream inputStream = this.getClass().getResourceAsStream("/sampleData/Vehicle.json");
              vehicleList = mapper.readValue(inputStream, TypeFactory.defaultInstance().constructCollectionType(List.class, Vehicle.class));
              String vehicleListString =  mapper.writeValueAsString(vehicleList);
    
                mockMvc.perform(get("/vehicles").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string(vehicleListString));
      
            } catch (JsonParseException e) {
              e.printStackTrace();
            } catch (JsonMappingException e) {
              e.printStackTrace();
            } catch (IOException e) {
              e.printStackTrace();
            }
        }

              @Test
        public void getExistingRecord() throws Exception {
    
          ObjectMapper mapper = new ObjectMapper();
          List<Vehicle> vehicleList = new ArrayList<Vehicle>();
          try {
              InputStream inputStream = this.getClass().getResourceAsStream("/sampleData/Vehicle.json");
              vehicleList = mapper.readValue(inputStream, TypeFactory.defaultInstance().constructCollectionType(List.class, Vehicle.class));
              Vehicle firstRecord = vehicleList.get(0);
              String vehicleString =  mapper.writeValueAsString(firstRecord);
    
              mockMvc.perform(get("/vehicles/"+firstRecord.getVin()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string(vehicleString));
    
          } catch (JsonParseException e) {
            e.printStackTrace();
          } catch (JsonMappingException e) {
            e.printStackTrace();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        @Test
        public void getNonExsitingRecord() throws Exception {
            mockMvc.perform(get("/vehicles/NON_EXISTING").accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound());
        }
                                                            @Test
        public void updateExistingRecord() throws Exception {
    
            ObjectMapper mapper = new ObjectMapper();
            List<Vehicle> vehicleList = new ArrayList<Vehicle>();
            try {
                InputStream inputStream = this.getClass().getResourceAsStream("/sampleData/Vehicle.json");
                vehicleList = mapper.readValue(inputStream, TypeFactory.defaultInstance().constructCollectionType(List.class, Vehicle.class));
                Vehicle firstRecord = vehicleList.get(0);
                String vehicleString =  mapper.writeValueAsString(firstRecord);
    
                mockMvc.perform(put("/vehicles/"+firstRecord.getVin())
                  .content(vehicleString).contentType(MediaType.APPLICATION_JSON)
                  .accept(MediaType.APPLICATION_JSON))
                  .andExpect(status().isOk())
                  .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                  .andExpect(content().string(vehicleString));
    
            } catch (JsonParseException e) {
              e.printStackTrace();
            } catch (JsonMappingException e) {
              e.printStackTrace();
            } catch (IOException e) {
              e.printStackTrace();
            }
        }

        @Test
        public void updateNONExistingRecord() throws Exception {
            mockMvc.perform(put("/vehicles/NON_EXISTING")
            .content("{\"dummy\":1}").contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound());
        }
                                                      @Test
        public void addRecord() throws Exception {
    
            ObjectMapper mapper = new ObjectMapper();
            List<Vehicle> vehicleList = new ArrayList<Vehicle>();
            try {
                InputStream inputStream = this.getClass().getResourceAsStream("/sampleData/Vehicle.json");
                vehicleList = mapper.readValue(inputStream, TypeFactory.defaultInstance().constructCollectionType(List.class, Vehicle.class));
                Vehicle firstRecord = vehicleList.get(0);
                String vehicleString =  mapper.writeValueAsString(firstRecord);
    
                mockMvc.perform(post("/vehicles")
                .content(vehicleString).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string(vehicleString));
    
            } catch (JsonParseException e) {
              e.printStackTrace();
            } catch (JsonMappingException e) {
              e.printStackTrace();
            } catch (IOException e) {
              e.printStackTrace();
            }
        }
                                                                      @Test
        public void deleteNonExsitingRecord() throws Exception {
            mockMvc.perform(delete("/vehicles/NON_EXISTING").accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound());
        }
                                  }