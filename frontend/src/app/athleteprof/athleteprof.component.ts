import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AthleteassComponent } from '../athleteass/athleteass.component';
import { EditprocoachComponent } from '../editprocoach/editprocoach.component';

@Component({
  selector: 'app-athleteprof',
  standalone: true,
  imports: [ AthleteassComponent, EditprocoachComponent],
  templateUrl: './athleteprof.component.html',
  styleUrl: './athleteprof.component.css'
})
export class AthleteprofComponent {

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
