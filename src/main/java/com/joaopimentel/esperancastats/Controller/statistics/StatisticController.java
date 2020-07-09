package com.joaopimentel.esperancastats.Controller.statistics;

import com.joaopimentel.esperancastats.DTO.statistics.StatisticDTO;
import com.joaopimentel.esperancastats.Service.statistics.StatisticService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/statistics")
public class StatisticController {

    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<StatisticDTO>> getAllStatistics() {
        return ResponseEntity.ok(statisticService.getAllStatistics());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StatisticDTO> getStatisticById(@PathVariable Long id) {
        StatisticDTO statisticDTO = statisticService.getStatisticById(id);

        if(statisticDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(statisticDTO);
    }

    @GetMapping(path = "/team/{teamId}/all")
    public ResponseEntity<StatisticDTO> getFirstHalfStatisticsFromGames(@PathVariable Long teamId,
                                                                        @RequestParam(value = "minMinutes", required = false) Integer minMinutes,
                                                                        @RequestParam(value = "maxMinutes", required = false) Integer maxMinutes,
                                                                        @RequestParam(value = "minMatchDay", required = false) Integer minMatchDay,
                                                                        @RequestParam(value = "maxMatchDay", required = false) Integer maxMatchDay) {
        return ResponseEntity.ok(statisticService.getFilteredStatisticsFromAllGames(teamId, minMinutes, maxMinutes, minMatchDay, maxMatchDay));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteStatisticById(@PathVariable Long id) {
        String outcome = statisticService.deleteStatisticById(id);

        if(outcome == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok(outcome);
        }
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllStatistics() {
        return ResponseEntity.ok(statisticService.deleteAllStatistics());
    }
}
