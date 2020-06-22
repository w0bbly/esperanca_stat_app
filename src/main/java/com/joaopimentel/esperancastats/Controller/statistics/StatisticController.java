package com.joaopimentel.esperancastats.Controller.statistics;

import com.joaopimentel.esperancastats.Entity.statistics.Statistic;
import com.joaopimentel.esperancastats.Service.statistics.StatisticService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/statistics")
public class StatisticController {

    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Statistic>> getAllStatistics() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Statistic> getStatisticById(@PathVariable Long id) {
        return ResponseEntity.ok(new Statistic());
    }

    @PostMapping
    public ResponseEntity<Statistic> createStatistic() {
        return ResponseEntity.ok(new Statistic());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Statistic> editStatistic(@PathVariable Long id) {
        return ResponseEntity.ok(new Statistic());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteStatisticById(@PathVariable Long id) {
        return ResponseEntity.ok("");
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllStatistics() {
        return ResponseEntity.ok("");
    }
}
