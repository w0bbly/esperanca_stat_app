package com.joaopimentel.esperancastats.Controller.statistics;

import com.joaopimentel.esperancastats.DTO.statistics.DeadBallDTO;
import com.joaopimentel.esperancastats.DTO.statistics.GoalDTO;
import com.joaopimentel.esperancastats.Entity.statistics.Goal;
import com.joaopimentel.esperancastats.Service.statistics.DeadBallService;
import com.joaopimentel.esperancastats.Service.statistics.GoalService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/goal")
public class GoalController {

    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<GoalDTO>> getAllGoals() {
        return ResponseEntity.ok(goalService.getAllGoals());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<GoalDTO> getGoalById(@PathVariable Long id) {
        GoalDTO goalDTO = goalService.getGoalById(id);

        if(goalDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(goalDTO);
    }

    @PostMapping(path = "/{statisticId}")
    public ResponseEntity<GoalDTO> createGoal(@PathVariable Long statisticId, @RequestBody GoalDTO goal) {
        return ResponseEntity.ok(goalService.createGoal(statisticId, goal));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GoalDTO> editGoal(@PathVariable Long id, @RequestBody GoalDTO goal) {
        GoalDTO goalDTO = goalService.editGoal(id, goal);

        if(goalDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(goalDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteGoalById(@PathVariable Long id) {
        String outcome = goalService.deleteGoalById(id);

        if(outcome == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok(outcome);
        }
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllGoals() {
        return ResponseEntity.ok(goalService.deleteAllGoals());
    }
}
