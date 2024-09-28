import { Component , OnInit} from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AthleteMetricsService } from '../athlete-metrics-service.service';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit{


    athleteMetrics: any;
  
    // constructor(private athleteMetricsService: AthleteMetricsService) { }
  
    ngOnInit(): void {
      // Fetch historical data using the mock service
      this.athleteMetrics = this.athleteMetricsService.getAthleteMetrics();
    }
  
    // Method to manually update data (e.g., after each training session)
    updateMetrics(newMetrics: any): void {
      this.athleteMetrics = { 
        ...this.athleteMetrics, 
        lastTrainingSession: {
          date: new Date().toISOString().split('T')[0],
          distance: newMetrics.newDistance || this.athleteMetrics.lastTrainingSession.distance,
          averageSpeed: newMetrics.newAverageSpeed || this.athleteMetrics.lastTrainingSession.averageSpeed,
          caloriesBurned: newMetrics.newCaloriesBurned || this.athleteMetrics.lastTrainingSession.caloriesBurned
        }
      };
  
      // Optionally update other metrics based on new data
      this.athleteMetrics.totalDistance += this.athleteMetrics.lastTrainingSession.distance;
    }


  constructor(private router: Router, private athleteMetricsService: AthleteMetricsService) {}

  editProfile(){
    this.router.navigate(['/editproathlete']);
  }
  dashboard(){
    this.router.navigate(['/dashboard']);
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

  onSubmit(){
    this.router.navigate(['/coachprof']);
  }

}
