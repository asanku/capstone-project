import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginComponent } from '../login/login.component';
// import { PersonalComponent } from '../personal/personal.component';
import { PersonalcoachComponent } from '../personalcoach/personalcoach.component';

@Component({
  selector: 'app-registration',
  standalone: true,
  imports: [LoginComponent, PersonalcoachComponent],
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.css'
})
export class RegistrationComponent {
  constructor(private router: Router) {}

  onLogin() {
    // Navigate to the about page
    this.router.navigate(['/login']);
    // alert('About section clicked');
  }

  signup(){
    this.router.navigate(['/personal']);
  }

}
