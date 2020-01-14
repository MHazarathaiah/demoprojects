import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../services/employee.service';

@Component({
  selector: 'app-employees',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})
export class EmployeeComponent  {

  newEmployee: string;
  employeeObj: any;
  emplloyees: Array<any>;
  employeeservice: EmployeeService;
  constructor() {
    emplloyees: [];
  }


  addEmployee(event) {
    this.employeeObj = {
      newEmployee: this.newEmployee,
      completed: false
    }
    this.emplloyees.push(this.employeeObj);
    this.newEmployee = '';
    event.preventDefault();
 //   this.employeeservice.save(this.newEmployee);
  }

  deleteEmployee(index) {
    this.emplloyees.splice(index, 1);
  //  this.employeeservice.remove(index);
  }

  removeEmployeeById(empId) {
    this.employeeservice.remove(empId).subscribe ( result =>
      {
        this.fetchEmployeeDetails();
      }),error => console.error(error);
  }

  fetchEmployeeDetails() {
    
    this.employeeservice.getEmployees()
    .subscribe(res => {
      this.emplloyees = res;
    }, err => {
      console.log(err);
    });
  }

  deleteSelectedEmployees() {
    for(var i=(this.emplloyees.length -1); i > -1; i--) {
      if(this.emplloyees[i].completed) {
        this.emplloyees.splice(i, 1);
      }
    }
  }

}




