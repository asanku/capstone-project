import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AthleteMetricsService {

  constructor() { }
    // Method to simulate fetching historical data from an API

    getAthleteMetrics() {
      return {
        averageHeartRate: 75, // in bpm
        totalDistance: 150,   // in km
        weeklyDistance: [5, 10, 7, 8, 12, 5, 9], // in km for each day of the week
        bestSpeed: 15, // in km/h
        lastTrainingSession: {
          date: '2024-09-01',
          distance: 10, // in km
          averageSpeed: 12, // in km/h
          caloriesBurned: 600 // in kcal
        }
      };
    }

}



