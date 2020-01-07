package com.sample.sampleSpringBoot.service;

import com.sample.sampleSpringBoot.models.Employee;

import java.util.List;
import java.util.concurrent.CompletionStage;

public interface HospitalDataService {

    public boolean addEmployeeDetails(Employee employee);
    public boolean deleteEmployeeDetails(Employee employee);
    public boolean updateEmployeeDetails(Employee employee);
    public List<Employee> fetchEmployeeDetails();
    public Employee fetchEmployeeDetailsByEmpId(long empId);
}
