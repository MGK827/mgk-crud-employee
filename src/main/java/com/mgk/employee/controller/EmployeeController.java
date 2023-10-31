package com.mgk.employee.controller;

import com.mgk.employee.domain.request.EmployeeRequest;
import com.mgk.employee.domain.response.EmployeeResponse;
import com.mgk.employee.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.mgk.employee.constant.ResourceApiPaths.V1_API;

@RestController
@RequestMapping(V1_API)
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;


    @Operation(
            summary = "Create Employee",
            tags = {"Employee"},
            responses = {
                    @ApiResponse(responseCode = "201", description = "Employee successfully created!")
            }
    )
    @PostMapping(value = "/employees")
    public ResponseEntity<Void> createEmployee(@Valid @RequestBody EmployeeRequest employeeRequest){

        employeeService.createEmployee(employeeRequest);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable int id){
        return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
    }
}
