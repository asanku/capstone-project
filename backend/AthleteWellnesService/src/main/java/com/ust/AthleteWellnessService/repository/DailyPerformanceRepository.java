package com.ust.AthleteWellnessService.repository;

import com.ust.AthleteWellnessService.model.DailyPerformance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DailyPerformanceRepository extends JpaRepository<DailyPerformance, Long> {

    List<DailyPerformance> findAllByAthleteId(String id);

}
