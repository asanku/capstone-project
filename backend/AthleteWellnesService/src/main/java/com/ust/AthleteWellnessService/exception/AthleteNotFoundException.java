package com.ust.AthleteWellnessService.exception;

public class AthleteNotFoundException extends RuntimeException{
    public AthleteNotFoundException(String message){
        super(message);
    }
}
