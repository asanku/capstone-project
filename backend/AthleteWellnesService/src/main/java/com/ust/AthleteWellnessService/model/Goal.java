package com.ust.AthleteWellnessService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "goal")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String athleteId;
    private double startWeight;
    private double targetWeight;
    private long dailyCalories;
    private String preference;
//    private long dailyCaloriesGoal;

}
