package com.sample.sampleSpringBoot.service;

import com.sample.sampleSpringBoot.models.Employee;
import com.sample.sampleSpringBoot.repository.HospitalDataRepository;
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
    public boolean deleteEmployeeDetails(long empId) {

        Employee employee = hospitalDataRepository.findByEmployeeId(empId);
        hospitalDataRepository.delete(employee);
        return true;
    }

    @Override
    public boolean updateEmployeeDetails(Employee employee) {

        Employee existEmployeeData = hospitalDataRepository.findByEmployeeId(employee.getEmployeeId());

        if(!StringUtils.isEmpty(existEmployeeData)) {

            hospitalDataRepository.save(new Employee(employee.getEmployeeId(),
                                        employee.getEmployeeName()!=null ? employee.getEmployeeName() : existEmployeeData.getEmployeeName()
                                        , employee.getDesignation()!=null ? employee.getDesignation() : existEmployeeData.getDesignation()
                                        , employee.getSalary() != null ? employee.getSalary() : existEmployeeData.getSalary()));

            return true;
        } else {
            return false;
        }

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
