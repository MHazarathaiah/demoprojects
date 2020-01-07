package com.sample.sampleSpringBoot.service;

import com.sample.sampleSpringBoot.models.Employee;
import com.sample.sampleSpringBoot.repository.HospitalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * h.hazarathaiah
 * 2020-01-07
 */
@Service
public class HospitalDataServiceImpl implements HospitalDataService {

    @Autowired
    HospitalDataRepository hospitalDataRepository;

    @Override
    public boolean addEmployeeDetails(Employee employee) {

        try {
            hospitalDataRepository.save(new Employee(employee.getEmployeeId(), employee.getEmployeeName(), employee.getDesignation(), employee.getSalary()));
            return true;
        }
        catch (Exception ex) {

            return false;
        }

    }

    @Override
    public boolean deleteEmployeeDetails(Employee employee) {
        return true;
    }

    @Override
    public boolean updateEmployeeDetails(Employee employee) {
        return true;
    }

    @Override
    public List<Employee> fetchEmployeeDetails() {
        Iterable<Employee> employees = hospitalDataRepository.findAll();
        List<Employee> employeeList = new ArrayList<Employee>();
        employees.forEach(employeeList:: add);
        return employeeList;
    }

    @Override
    public Employee fetchEmployeeDetailsByEmpId(long empId) {
            Employee employee = hospitalDataRepository.findByEmployeeId(empId);
            return employee;
    }
}
