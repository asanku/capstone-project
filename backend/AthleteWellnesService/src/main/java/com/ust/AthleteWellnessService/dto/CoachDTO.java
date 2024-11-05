package com.ust.AthleteWellnessService.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CoachDTO(
        String id,
        String firstName,
        String lastName,
        LocalDate DOB,
        String email,
        String gender
) {

}
