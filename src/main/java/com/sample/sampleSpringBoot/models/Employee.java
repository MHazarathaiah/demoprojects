package com.sample.sampleSpringBoot.models;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * h.hazarathaiah
 * 2020-01-09
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

        public Employee() {

        }

        public Employee (long employeeId,String employeeName) {
                this.employeeId = employeeId;
                this.employeeName = employeeName;
        }

        public String getEmployeeName() {
                return employeeName;
        }

        public void setEmployeeName(String employeeName) {
                this.employeeName = employeeName;
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
                        '}';
        }
}
