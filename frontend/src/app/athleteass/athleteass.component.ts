import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-athleteass',
  standalone: true,
  imports: [],
  templateUrl: './athleteass.component.html',
  styleUrl: './athleteass.component.css'
})
export class AthleteassComponent {
  constructor(private router: Router) {}

  editProfile(){
    this.router.navigate(['/editprocoach']);
  }

  athleteass(){
    this.router.navigate(['/athleteass']);
  }
  onLogin() {
    this.router.navigate(['/login']);
  }
}
