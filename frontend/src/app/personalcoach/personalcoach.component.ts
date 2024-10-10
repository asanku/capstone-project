import { Component } from '@angular/core';
// import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
// import { AthleteprofComponent } from '../coachprof/coachprof.component';


@Component({
  selector: 'app-personalcoach',
  standalone: true,
  // imports: [AthleteprofComponent,FormsModule],
  templateUrl: './personalcoach.component.html',
  styleUrl: './personalcoach.component.css'
})
export class PersonalcoachComponent {


  // firstName: string = '';
  // lastName: string = '';
  // dob: string = '';
  // email: string = '';
  // gender: string = '';

  constructor(private router: Router) {}

  // editProfile(profileForm: any) {
  //   if (profileForm.valid) {
  //     console.log('Form Data:', {
  //       firstName: this.firstName,
  //       lastName: this.lastName,
  //       dob: this.dob,
  //       email: this.email,
  //       gender: this.gender,
  //     });
  //   }
  // }

  onSubmit(){
    this.router.navigate(['/athleteprof']);
  }
  onLogin() {
    this.router.navigate(['/login']);
  }
}