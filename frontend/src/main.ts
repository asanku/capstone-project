import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { provideRouter } from '@angular/router';
import { HomeComponent } from './app/home/home.component';
import { routes as approutes } from './app/app.routes' // Import your routes

const routes = [
  { path: '', component: HomeComponent }
];

bootstrapApplication(AppComponent, {
  providers: [provideRouter(approutes)]
}).catch(err => console.error(err));
