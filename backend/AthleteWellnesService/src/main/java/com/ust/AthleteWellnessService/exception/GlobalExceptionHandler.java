package com.ust.AthleteWellnessService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private HashMap<Object, Object> response = new HashMap<>();

    @ExceptionHandler(AthleteNotFoundException.class)
    public ResponseEntity<Object> handleAthleteNotFoundException(AthleteNotFoundException ex){
        response.clear();
        logger.error("An error occurred...");
        response.put("message",ex.getMessage());
        response.put("status", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GoalNotFoundException.class)
    public ResponseEntity<Object> handleGoalNotFoundException(GoalNotFoundException ex){
        response.clear();
        logger.error("An error occurred...");
        response.put("message",ex.getMessage());
        response.put("status", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
