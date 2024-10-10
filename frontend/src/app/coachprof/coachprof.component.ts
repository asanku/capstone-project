import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { EditproathleteComponent } from '../editproathlete/editproathlete.component';
import { DietComponent } from '../diet/diet.component';
import { DashboardComponent } from '../dashboard/dashboard.component';
import { GoalComponent } from '../goal/goal.component';
import { CoachassComponent } from '../coachass/coachass.component';

@Component({
  selector: 'app-coachprof',
  standalone: true,
  imports: [EditproathleteComponent, DietComponent, DashboardComponent, GoalComponent, CoachassComponent],
  templateUrl: './coachprof.component.html',
  styleUrl: './coachprof.component.css'
})
export class CoachprofComponent {
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
  onLogin() {
    this.router.navigate(['/login']);
  }

  
}
