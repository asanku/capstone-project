package com.ust.AthleteWellnessService.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ust.AthleteWellnessService.model.DailyPerformance;
import com.ust.AthleteWellnessService.model.Goal;
import com.ust.AthleteWellnessService.model.Recommendation;

import java.util.List;

public interface PerformanceService {

    public Goal createGoal(Goal goal);

    public DailyPerformance createDailyPerformance(String id, DailyPerformance dailyPerformance);

    public Recommendation getRecommandations(String athleteId) throws JsonProcessingException;

    public List<DailyPerformance> getDailyPerformance(String athleteId);



}
