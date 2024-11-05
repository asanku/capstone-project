package com.ust.AthleteWellnessService.repository;

import com.ust.AthleteWellnessService.model.DailyPerformance;
import com.ust.AthleteWellnessService.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GoalRepository extends JpaRepository<Goal, Long> {

    public Optional<Goal> findByAthleteId(String id);

}
