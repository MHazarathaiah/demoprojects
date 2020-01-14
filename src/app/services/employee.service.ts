import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employee } from '../models/employee/employee';
import { Observable, of } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  public EMPLOYEE_API = '//localhost:8080/v1/';

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  getAll(): Observable<any> {
    return this.http.get(this.EMPLOYEE_API + '/employees');
  }

  get(id: string) {
    return this.http.get(this.EMPLOYEE_API + '/' + id);
  }

  getEmployees (): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.EMPLOYEE_API + 'employees', this.httpOptions)
      .pipe(
        tap(employees => console.log('fetched employees')),
        catchError(this.handleError('getEmployees', []))
      );
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
   
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
   
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  save(employee: any): Observable<any> {
    let result: Observable<Object>;
    if (employee['href']) {
      result = this.http.put(employee.href, employee);
    } else {
      result = this.http.post(this.EMPLOYEE_API, employee);
    }
    return result;
  }

  remove(empId: string) {
    return this.http.delete(this.EMPLOYEE_API + 'employee/' + empId);
  }

}
