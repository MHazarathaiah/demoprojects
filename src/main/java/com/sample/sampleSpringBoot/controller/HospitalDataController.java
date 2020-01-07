package com.sample.sampleSpringBoot.controller;

import com.sample.sampleSpringBoot.models.Employee;
import com.sample.sampleSpringBoot.repository.HospitalDataRepository;
import com.sample.sampleSpringBoot.service.HospitalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * h.hazarathaiah
 * 2020-01-05
 */

@RestController
public class HospitalDataController {

    @Autowired
    HospitalDataRepository hospitalDataRepository;

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

}
