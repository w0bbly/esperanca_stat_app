package com.joaopimentel.esperancastats.Controller.statistics;

import com.joaopimentel.esperancastats.Entity.statistics.BallPossession;
import com.joaopimentel.esperancastats.Service.statistics.BallPossessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/ballpossession")
public class BallPossessionController {

    private final BallPossessionService ballPossessionService;

    public BallPossessionController(BallPossessionService ballPossessionService) {
        this.ballPossessionService = ballPossessionService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<BallPossession>> getAllBallPossessions() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BallPossession> getBallPossessionById(@PathVariable Long id) {
        return ResponseEntity.ok(new BallPossession());
    }

    @PostMapping
    public ResponseEntity<BallPossession> createBallPossession() {
        return ResponseEntity.ok(new BallPossession());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BallPossession> editBallPossession(@PathVariable Long id) {
        return ResponseEntity.ok(new BallPossession());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteBallPossessionById(@PathVariable Long id) {
        return ResponseEntity.ok("");
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllBallPossessions() {
        return ResponseEntity.ok("");
    }
}
