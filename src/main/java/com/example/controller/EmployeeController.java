package com.example.controller;

import com.example.entity.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value="/save-employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping(value="/update-employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee ,@PathVariable long id) {
        Employee emp = employeeService.updateEmployee(employee, id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @DeleteMapping(value="/delete-employee/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value="/getone-employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable long id) {
        Employee emp = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @GetMapping(value="/getall-employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}

/*
        ####   POST   ####
    {
    "name": "John Doe",
    "location": "New York",
    "email": "john.doe@example.com",
    "attributes": "{\"department\": \"IT\", \"position\": \"Developer\"}"
    }

 */

/*
    SELECT
    attributes->>'position' AS position,
    attributes->>'department' AS department
FROM
    employees;

 */