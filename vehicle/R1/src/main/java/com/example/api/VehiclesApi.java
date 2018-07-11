package com.example.api;

import com.example.model.*;

import io.swagger.annotations.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import java.util.List;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "com.example.languages.SpringCodegen", date = "2017-01-25T13:29:39.620Z")

@Api(value = "Vehicles", description = "the Vehicles API")
public interface VehiclesApi {
      @ApiOperation(value = "", notes = "Gets all vehicles from the system that the user has access to", response = Vehicle.class, responseContainer = "List", tags={ "Vehicle", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "vehicle response", response = Vehicle.class),
        @ApiResponse(code = 404, message = "vehicle response", response = Vehicle.class),
        @ApiResponse(code = 500, message = "vehicle response", response = Vehicle.class) })
    @RequestMapping(value = "/vehicles",
        produces = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<Vehicle>> getVehicle();
    
  @ApiOperation(value = "", notes = "Gets all vehicles from the system that the user has access to", response = Vehicle.class, tags={ "Vehicle", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "vehicle response", response = Vehicle.class),
        @ApiResponse(code = 404, message = "vehicle response", response = Object.class),
        @ApiResponse(code = 500, message = "vehicle response", response = Object.class) })
    @RequestMapping(value = "/vehicles/{vin}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Vehicle> getVehicleById(@ApiParam(value = "Path Parameter",required=true) @PathVariable("vin") String vin);

                        @ApiOperation(value = "", notes = "Puts all vehicles from the system that the user has access to", response = Vehicle.class, responseContainer = "List", tags={ "Vehicle", })
  @ApiResponses(value = {
      @ApiResponse(code = 204, message = "vehicle response", response = Vehicle.class),
      @ApiResponse(code = 404, message = "vehicle response", response = Vehicle.class),
      @ApiResponse(code = 500, message = "vehicle response", response = Vehicle.class) })
  @RequestMapping(value = "/vehicles/{vin}",
      produces = { "application/json" },
      consumes = { "application/json" },
      method = RequestMethod.PUT)
  ResponseEntity<Vehicle> putVehicle(@ApiParam(value = "Path Parameter",required=true) @PathVariable("vin") String vin, @ApiParam(value = ""  )  @Valid @RequestBody Vehicle vehicles);
            @ApiOperation(value = "", notes = "Posts all vehicles from the system that the user has access to", response = Vehicle.class, responseContainer = "List", tags={ "Vehicle", })
  @ApiResponses(value = {
      @ApiResponse(code = 204, message = "vehicle response", response = Vehicle.class),
      @ApiResponse(code = 404, message = "vehicle response", response = Vehicle.class),
      @ApiResponse(code = 500, message = "vehicle response", response = Vehicle.class) })
  @RequestMapping(value = "/vehicles",
      produces = { "application/json" },
      consumes = { "application/json" },
      method = RequestMethod.POST)
  ResponseEntity<Vehicle> postVehicle(@ApiParam(value = ""  ) @RequestBody Vehicle vehicle);
            @ApiOperation(value = "", notes = "Patchs all vehicles from the system that the user has access to", response = Vehicle.class, responseContainer = "List", tags={ "Vehicle", })
  @ApiResponses(value = {
      @ApiResponse(code = 204, message = "vehicle response", response = Vehicle.class),
      @ApiResponse(code = 404, message = "vehicle response", response = Vehicle.class),
      @ApiResponse(code = 500, message = "vehicle response", response = Vehicle.class) })
  @RequestMapping(value = "/vehicles/{vin}",
      produces = { "application/json" },
      consumes = { "application/json" },
      method = RequestMethod.PATCH)
  ResponseEntity<Vehicle> patchVehicle(@ApiParam(value = "Path Parameter",required=true) @PathVariable("vin") String vin, @ApiParam(value = ""  )  @Valid @RequestBody Patchvehicle vehicles);
          @ApiOperation(value = "", notes = "Deletes all vehicles from the system that the user has access to", response = Vehicle.class, responseContainer = "List", tags={ "Vehicle", })
  @ApiResponses(value = {
      @ApiResponse(code = 204, message = "vehicle response", response = Vehicle.class),
      @ApiResponse(code = 404, message = "vehicle response", response = Vehicle.class),
      @ApiResponse(code = 500, message = "vehicle response", response = Vehicle.class) })
  @RequestMapping(value = "/vehicles/{vin}",
      produces = { "application/json" },
      method = RequestMethod.DELETE)
  ResponseEntity<Vehicle> deleteVehicle(@ApiParam(value = "Path Parameter",required=true) @PathVariable("vin") String vin);
          }
