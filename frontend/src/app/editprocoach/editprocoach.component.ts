import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-editprocoach',
  standalone: true,
  imports: [],
  templateUrl: './editprocoach.component.html',
  styleUrl: './editprocoach.component.css'
})
export class EditprocoachComponent {
  constructor(private router: Router) {}

  editProfile(){
    this.router.navigate(['/editprocoach']);
  }

  athleteass(){
    this.router.navigate(['/athleteass']);
  }
  onSubmit(){
    this.router.navigate(['/athleteprof']);
  }
  onLogin() {
    this.router.navigate(['/login']);
  }


}
