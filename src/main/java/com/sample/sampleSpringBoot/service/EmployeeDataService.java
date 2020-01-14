package com.sample.sampleSpringBoot.service;

import com.sample.sampleSpringBoot.models.Employee;

import java.util.List;

public interface EmployeeDataService {

    public boolean addEmployeeDetails(Employee employee);
    public boolean deleteEmployeeDetails(long empId);
    public boolean updateEmployeeDetails(Employee employee);
    public List<Employee> fetchEmployeeDetails();
    public Employee fetchEmployeeDetailsByEmpId(long empId);
}
