package com.sample.sampleSpringBoot.repository;

import com.sample.sampleSpringBoot.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * h.hazarathaiah
 * 2020-01-09
 */

@CrossOrigin(origins = "http://localhost:4200")
public interface EmployeeDataRepository extends CrudRepository <Employee, Long> {

    Employee findByEmployeeId(long employeeId);
    List<Employee> findAll();
}
