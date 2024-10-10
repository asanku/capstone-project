import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-goal',
  standalone: true,
  imports: [],
  templateUrl: './goal.component.html',
  styleUrl: './goal.component.css'
})
export class GoalComponent {
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
    this.router.navigate(['/coachass'])
  }

  onSubmit(){
    this.router.navigate(['/coachprof']);
  }
  onLogin() {
    this.router.navigate(['/login']);
  }
}
