package com.sample.sampleSpringBoot.repository;

import com.sample.sampleSpringBoot.models.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HospitalDataRepository extends CrudRepository <Employee, Long> {

    Employee findByEmployeeId(long employeeId);
    List<Employee> findAll();
}
