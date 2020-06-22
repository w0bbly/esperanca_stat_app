package com.joaopimentel.esperancastats.Controller.statistics;

import com.joaopimentel.esperancastats.Entity.statistics.Shot;
import com.joaopimentel.esperancastats.Service.statistics.ShotService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/shot")
public class ShotController {

    private final ShotService shotService;

    public ShotController(ShotService shotService) {
        this.shotService = shotService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Shot>> getAllShots() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Shot> getShotById(@PathVariable Long id) {
        return ResponseEntity.ok(new Shot());
    }

    @PostMapping
    public ResponseEntity<Shot> createShot() {
        return ResponseEntity.ok(new Shot());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shot> editShot(@PathVariable Long id) {
        return ResponseEntity.ok(new Shot());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteShotById(@PathVariable Long id) {
        return ResponseEntity.ok("");
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllShots() {
        return ResponseEntity.ok("");
    }
}
