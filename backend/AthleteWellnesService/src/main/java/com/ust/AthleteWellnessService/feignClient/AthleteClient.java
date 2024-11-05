package com.ust.AthleteWellnessService.feignClient;

import com.ust.AthleteWellnessService.dto.AthleteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name ="ATHELETECOACHSERVICE", url = "http://localhost:8080/api/v1/athlete/athletes")
public interface AthleteClient {

    @GetMapping("/{id}")
    public Optional<AthleteDTO> findAthlete(@PathVariable String id);

}
