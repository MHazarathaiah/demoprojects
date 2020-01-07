package com.sample.sampleSpringBoot.models;


import javax.persistence.*;
import java.io.Serializable;

/**
 * h.hazarathaiah
 * 2020-01-05
 */
@Entity
@Table(name ="employee")
public class Employee implements Serializable {

        private static final long serialVersionUID = -2343243243242432341L;

        @Id
        @Column(name = "employeeId")
        private long employeeId;
        @Column(name = "employeeName")
        private String employeeName;
        @Column(name = "designation")
        private String designation;
        @Column(name = "salary")
        private String salary;

        public Employee() {

        }

        public Employee (long employeeId,String employeeName, String designation, String salary) {
                this.employeeId = employeeId;
                this.employeeName = employeeName;
                this.designation = designation;
                this.salary = salary;
        }

        public String getEmployeeName() {
                return employeeName;
        }

        public void setEmployeeName(String employeeName) {
                this.employeeName = employeeName;
        }

        public String getDesignation() {
                return designation;
        }

        public void setDesignation(String designation) {
                this.designation = designation;
        }

        public String getSalary() {
                return salary;
        }

        public void setSalary(String salary) {
                this.salary = salary;
        }

        public long getEmployeeId() {
                return employeeId;
        }

        public void setEmployeeId(long employeeId) {
                this.employeeId = employeeId;
        }

        @Override
        public String toString() {
                return "Employee{" +
                        "employeeId=" + employeeId +
                        ", employeeName='" + employeeName + '\'' +
                        ", designation='" + designation + '\'' +
                        ", salary='" + salary + '\'' +
                        '}';
        }
}
