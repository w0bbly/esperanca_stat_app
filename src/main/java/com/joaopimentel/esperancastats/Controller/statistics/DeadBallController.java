package com.joaopimentel.esperancastats.Controller.statistics;

import com.joaopimentel.esperancastats.Entity.statistics.DeadBall;
import com.joaopimentel.esperancastats.Service.statistics.DeadBallService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/deadball")
public class DeadBallController {

    private final DeadBallService deadBallService;

    public DeadBallController(DeadBallService deadBallService) {
        this.deadBallService = deadBallService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<DeadBall>> getAllDeadBalls() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DeadBall> getDeadBallById(@PathVariable Long id) {
        return ResponseEntity.ok(new DeadBall());
    }

    @PostMapping
    public ResponseEntity<DeadBall> createDeadBall() {
        return ResponseEntity.ok(new DeadBall());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeadBall> editDeadBall(@PathVariable Long id) {
        return ResponseEntity.ok(new DeadBall());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteDeadBallById(@PathVariable Long id) {
        return ResponseEntity.ok("");
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllDeadBalls() {
        return ResponseEntity.ok("");
    }
}
