package com.ust.AthleteWellnessService.exception;

public class GoalNotFoundException extends RuntimeException{
    public GoalNotFoundException(String message){
        super(message);
    }
}
