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

@Api(value = "Employees", description = "the Employees API")
public interface EmployeesApi {
      @ApiOperation(value = "", notes = "Gets all Employees from the system that the user has access to", response = Employee.class, responseContainer = "List", tags={ "Employee", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Employee response", response = Employee.class),
        @ApiResponse(code = 404, message = "Employee response", response = Employee.class),
        @ApiResponse(code = 500, message = "Employee response", response = Employee.class) })
    @RequestMapping(value = "/Employees",
        produces = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<Employee>> getEmployee();
    
  @ApiOperation(value = "", notes = "Gets all Employees from the system that the user has access to", response = Employee.class, tags={ "Employee", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Employee response", response = Employee.class),
        @ApiResponse(code = 404, message = "Employee response", response = Object.class),
        @ApiResponse(code = 500, message = "Employee response", response = Object.class) })
    @RequestMapping(value = "/Employees/{empid}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Employee> getEmployeeById(@ApiParam(value = "Path Parameter",required=true) @PathVariable("empid") String empid);

                        @ApiOperation(value = "", notes = "Puts all Employees from the system that the user has access to", response = Employee.class, responseContainer = "List", tags={ "Employee", })
  @ApiResponses(value = {
      @ApiResponse(code = 204, message = "Employee response", response = Employee.class),
      @ApiResponse(code = 404, message = "Employee response", response = Employee.class),
      @ApiResponse(code = 500, message = "Employee response", response = Employee.class) })
  @RequestMapping(value = "/Employees/{empid}",
      produces = { "application/json" },
      consumes = { "application/json" },
      method = RequestMethod.PUT)
  ResponseEntity<Employee> putEmployee(@ApiParam(value = "Path Parameter",required=true) @PathVariable("empid") String empid, @ApiParam(value = ""  )  @Valid @RequestBody Employee Employees);
            @ApiOperation(value = "", notes = "Posts all Employees from the system that the user has access to", response = Employee.class, responseContainer = "List", tags={ "Employee", })
  @ApiResponses(value = {
      @ApiResponse(code = 204, message = "Employee response", response = Employee.class),
      @ApiResponse(code = 404, message = "Employee response", response = Employee.class),
      @ApiResponse(code = 500, message = "Employee response", response = Employee.class) })
  @RequestMapping(value = "/Employees",
      produces = { "application/json" },
      consumes = { "application/json" },
      method = RequestMethod.POST)
  ResponseEntity<Employee> postEmployee(@ApiParam(value = ""  ) @RequestBody Employee Employee);
        @ApiOperation(value = "", notes = "Deletes all Employees from the system that the user has access to", response = Employee.class, responseContainer = "List", tags={ "Employee", })
  @ApiResponses(value = {
      @ApiResponse(code = 204, message = "Employee response", response = Employee.class),
      @ApiResponse(code = 404, message = "Employee response", response = Employee.class),
      @ApiResponse(code = 500, message = "Employee response", response = Employee.class) })
  @RequestMapping(value = "/Employees/{empid}",
      produces = { "application/json" },
      method = RequestMethod.DELETE)
  ResponseEntity<Employee> deleteEmployee(@ApiParam(value = "Path Parameter",required=true) @PathVariable("empid") String empid);
          }
