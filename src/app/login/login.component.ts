import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PersonalComponent } from '../personal/personal.component';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [PersonalComponent],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  constructor(private router: Router) {}

  onLogin() {
    // Navigate to the about page
    this.router.navigate(['/login']);
    // alert('About section clicked');
  }
  //   onLogin(event: Event) {
  //     event.preventDefault(); 
  // }


}

