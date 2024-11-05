package com.ust.AthleteWellnessService.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ust.AthleteWellnessService.model.DailyPerformance;
import com.ust.AthleteWellnessService.model.Goal;
import com.ust.AthleteWellnessService.model.Recommendation;
import com.ust.AthleteWellnessService.service.PerformanceService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/wellness")
@AllArgsConstructor
public class Controller {

    private PerformanceService performanceService;

    @PostMapping("/goal")
    public ResponseEntity<Goal> createOrUpdateGoal(@RequestBody Goal goal){
        return new ResponseEntity<>(performanceService.createGoal(goal), HttpStatus.CREATED);
    }
    /*
    {
    "athleteId":"ATH44149",
    "startWeight":"60.00",
    "targetWeight":"100.00",
    "dailyCalories":"3000",
    "preference":"with in 2 months I need to attain the target weight"
}
*/

    @GetMapping("/dailyPerformance/{id}")
    public ResponseEntity<List<DailyPerformance>> getDailyPerformance(@PathVariable String id){
        return ResponseEntity.ok(performanceService.getDailyPerformance(id));
    }

    @PostMapping("/dailyPerformance/{id}")
    public ResponseEntity<DailyPerformance> createorUpdateDailyPerformance(@PathVariable String id, @RequestBody DailyPerformance performance){
        return ResponseEntity.ok(performanceService.createDailyPerformance(id, performance));
    }

    @GetMapping("/recommendations/{id}")
    public ResponseEntity<Recommendation> getRecommendations(@PathVariable String id){

        try {
            return new ResponseEntity<>(performanceService.getRecommandations(id), HttpStatus.OK);
        }
        catch (RuntimeException | JsonProcessingException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
