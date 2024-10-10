import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CoachprofComponent } from '../coachprof/coachprof.component';

@Component({
  selector: 'app-personal',
  standalone: true,
  imports: [CoachprofComponent],
  templateUrl: './personal.component.html',
  styleUrl: './personal.component.css'
})
export class PersonalComponent {
  constructor(private router: Router) {}

  onSubmit(){
    this.router.navigate(['/coachprof']);
  }
  onLogin() {
    this.router.navigate(['/login']);
  }

}
