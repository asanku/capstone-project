package com.ust.AtheleteCoachService.exception;

public class DuplicateAthleteException extends RuntimeException{
    public DuplicateAthleteException(String message){
        super(message);
    }
}
