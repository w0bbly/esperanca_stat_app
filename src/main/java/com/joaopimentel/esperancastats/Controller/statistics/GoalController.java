package com.joaopimentel.esperancastats.Controller.statistics;

import com.joaopimentel.esperancastats.Entity.statistics.Goal;
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
    public ResponseEntity<List<Goal>> getAllGoals() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Goal> getGoalById(@PathVariable Long id) {
        return ResponseEntity.ok(new Goal());
    }

    @PostMapping
    public ResponseEntity<Goal> createGoal() {
        return ResponseEntity.ok(new Goal());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Goal> editGoal(@PathVariable Long id) {
        return ResponseEntity.ok(new Goal());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteGoalById(@PathVariable Long id) {
        return ResponseEntity.ok("");
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllGoals() {
        return ResponseEntity.ok("");
    }
}
