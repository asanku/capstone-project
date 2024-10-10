import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-editproathlete',
  standalone: true,
  imports: [],
  templateUrl: './editproathlete.component.html',
  styleUrl: './editproathlete.component.css'
})
export class EditproathleteComponent {
  constructor(private router: Router) {}

  editProfile(){
    this.router.navigate(['/editproathlete']);
  }

  dashboard(){
    this.router.navigate(['/dashboard'])
  }

  dietplan(){
    this.router.navigate(['/diet']);
  }

  goal(){
    this.router.navigate(['/goal']);
  }

  coachass(){
    this.router.navigate(['/coachass']);
  }

  onSubmit(){
    this.router.navigate(['/coachprof']);
  }
  onLogin() {
    this.router.navigate(['/login']);
  }


}
