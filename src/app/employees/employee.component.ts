import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employees',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})
export class EmployeeComponent  {

  newEmployee: string;
  emplloyees: any;
  employeeObj: any;

  constructor() {
    this.newEmployee = '';
    this.emplloyees = [];
  }

  addEmployee(event) {
    this.employeeObj = {
      newEmployee: this.newEmployee,
      completed: false
    }
    this.emplloyees.push(this.employeeObj);
    this.newEmployee = '';
    event.preventDefault();
  }

  deleteTodo(index) {
    this.emplloyees.splice(index, 1);
  }

  deleteSelectedTodos() {
    //need ES5 to reverse loop in order to splice by index
    for(var i=(this.emplloyees.length -1); i > -1; i--) {
      if(this.emplloyees[i].completed) {
        this.emplloyees.splice(i, 1);
      }
    }
  }

}




