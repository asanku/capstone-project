package com.ust.AthleteWellnessService.model;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "recommendations")
public class Recommendation {

    private String foodType;
    private String proteins;
    private long calories;

}
