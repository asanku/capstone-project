import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-coachass',
  standalone: true,
  imports: [],
  templateUrl: './coachass.component.html',
  styleUrl: './coachass.component.css'
})
export class CoachassComponent {
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
