package com.joaopimentel.esperancastats.Controller.statistics;

import com.joaopimentel.esperancastats.DTO.statistics.DeadBallDTO;
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
    public ResponseEntity<List<DeadBallDTO>> getAllDeadBalls() {
        return ResponseEntity.ok(deadBallService.getAllDeadBalls());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DeadBallDTO> getDeadBallById(@PathVariable Long id) {
        DeadBallDTO deadBallDTO = deadBallService.getDeadBallById(id);

        if(deadBallDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(deadBallDTO);
    }

    @PostMapping(path = "/{statisticId}")
    public ResponseEntity<DeadBallDTO> createDeadBall(@PathVariable Long statisticId, @RequestBody DeadBallDTO deadBall) {
        return ResponseEntity.ok(deadBallService.createDeadBall(statisticId, deadBall));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeadBallDTO> editDeadBall(@PathVariable Long id, @RequestBody DeadBallDTO deadBall) {
        DeadBallDTO deadBallDTO = deadBallService.editDeadBall(id, deadBall);

        if(deadBallDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(deadBallDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteDeadBallById(@PathVariable Long id) {
        String outcome = deadBallService.deleteDeadBallById(id);

        if(outcome == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok(outcome);
        }
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllDeadBalls() {
        return ResponseEntity.ok(deadBallService.deleteAllDeadBalls());
    }
}
