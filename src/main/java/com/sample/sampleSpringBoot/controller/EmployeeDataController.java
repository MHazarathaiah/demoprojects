package com.sample.sampleSpringBoot.controller;

import com.sample.sampleSpringBoot.models.Employee;
import com.sample.sampleSpringBoot.repository.EmployeeDataRepository;
import com.sample.sampleSpringBoot.service.HospitalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * h.hazarathaiah
 * 2020-01-09
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeDataController {

    @Autowired
    EmployeeDataRepository employeeDataRepository;

    @Autowired
    HospitalDataService hospitalDataService;

    @GetMapping (value="/v1/healthCheck")
    public String getHealthCheck(){
        return " { \"is Working \" : true ";
    }

    @GetMapping ("/v1/employees")
    public List<Employee> getEmployees() {
        return hospitalDataService.fetchEmployeeDetails();
    }

    @GetMapping ("/v1/employee/{empId}")
    public Employee getEmployeeById(@PathVariable long empId) {
        return hospitalDataService.fetchEmployeeDetailsByEmpId(empId);
    }

    @PostMapping ("/v1/employee")
    public boolean createEmployee(@RequestBody Employee employee) {

       return hospitalDataService.addEmployeeDetails(employee);
    }

    @DeleteMapping ("/v1/employee/{empId}")
    public boolean deleteEmployee(@PathVariable long empId) {
        return hospitalDataService.deleteEmployeeDetails(empId);
    }

    @PatchMapping ("/v1/employee")
    public boolean updateEmployee(@RequestBody Employee employee) {
        return hospitalDataService.updateEmployeeDetails(employee);
    }

}
