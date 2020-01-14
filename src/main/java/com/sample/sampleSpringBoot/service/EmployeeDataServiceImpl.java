package com.sample.sampleSpringBoot.service;

import com.sample.sampleSpringBoot.models.Employee;
import com.sample.sampleSpringBoot.repository.EmployeeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * h.hazarathaiah
 * 2020-01-07
 */
@Service
public class EmployeeDataServiceImpl implements EmployeeDataService {

    @Autowired
    EmployeeDataRepository employeeDataRepository;

    @Override
    public boolean addEmployeeDetails(Employee employee) {

        try {
            employeeDataRepository.save(new Employee(employee.getEmployeeId(), employee.getEmployeeName()));
            return true;
        }
        catch (Exception ex) {

            return false;
        }

    }

    @Override
    public boolean deleteEmployeeDetails(long empId) {
        Employee employee = employeeDataRepository.findByEmployeeId(empId);
        employeeDataRepository.delete(employee);
        return true;
    }

    @Override
    public boolean updateEmployeeDetails(Employee employee) {

        Employee existEmployeeData = employeeDataRepository.findByEmployeeId(employee.getEmployeeId());

        if(!StringUtils.isEmpty(existEmployeeData)) {

            employeeDataRepository.save(new Employee(employee.getEmployeeId(),
                                        employee.getEmployeeName()!=null ? employee.getEmployeeName() : existEmployeeData.getEmployeeName()
                                        ));

            return true;
        } else {
            return false;
        }

    }

    @Override
    public List<Employee> fetchEmployeeDetails() {
        Iterable<Employee> employees = employeeDataRepository.findAll();
        List<Employee> employeeList = new ArrayList<Employee>();
        employees.forEach(employeeList:: add);
        return employeeList;
    }

    @Override
    public Employee fetchEmployeeDetailsByEmpId(long empId) {
            Employee employee = employeeDataRepository.findByEmployeeId(empId);
            return employee;
    }
}
