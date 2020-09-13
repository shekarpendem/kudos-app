import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { Employee } from '../employee';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { Kudo } from '../kudo';

@Component({
  selector: 'app-add-kudos',
  templateUrl: './add-kudos.component.html',
  styleUrls: ['./add-kudos.component.css']
})
export class AddKudosComponent implements OnInit {
  employees: Observable<Employee[]>;
  id: number;
  kudo: Kudo = new Kudo();
  submitted = false;

  constructor(private route: ActivatedRoute, private router: Router,
    private employeeService: EmployeeService) { }

  ngOnInit() {
    console.log('in init');
    this.employees = this.employeeService.getEmployeesList();
    console.log(this.employees)
  }

  save() {
    this.employeeService
    .addKudos(this.kudo).subscribe(data => {
      console.log(data)
      this.kudo = new Kudo();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/employees']);
  }

}
