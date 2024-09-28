import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgIf } from '@angular/common';
import { LoginComponent } from '../login/login.component';
import { RegistrationComponent } from '../registration/registration.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [LoginComponent, NgIf, RegistrationComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  showLogin = false; // Controls visibility of login page


  toggleLogin() {
    this.router.navigate(['/login']);
    // console.log('Login button clicked');
    // console.log('Current showLogin value:', this.showLogin);
    // this.showLogin = !this.showLogin;
    // console.log('New showLogin value:', this.showLogin);
  }
  
  constructor(private router: Router) {}

  onAbout() {
    // Navigate to the about page
    // this.router.navigate(['/about']);
    alert('About section clicked');
  }

//   onLogin() {
//     // Navigate to the login page
//     // this.router.navigate(['/login']);
//     alert('Login button clicked');
//   }

  onAthlete() {
    // Handle athlete button click
    this.router.navigate(['/registration']);
    // alert('Athlete button clicked');
  }

  onCoach() {
    // Handle coach button click
    this.router.navigate(['/registration']);
    // alert('Coach button clicked');
  }

//   goToLogin() {
//   this.router.navigate(['/login']);
// }


  // constructor(private router: Router) {}

  // onAbout() {
  //   // Navigate to the about page
  //   // this.router.navigate(['/about']);
  //   alert('About section clicked');
  // }

  // onLogin() {
  //   // Navigate to the login page
  //   // this.router.navigate(['/login']);
  //   alert('Login button clicked');
  // }

  // onAthlete() {
  //   // Handle athlete button click
  //   alert('Athlete button clicked');
  // }

  // onCoach() {
  //   // Handle coach button click
  //   alert('Coach button clicked');
  // }

}
