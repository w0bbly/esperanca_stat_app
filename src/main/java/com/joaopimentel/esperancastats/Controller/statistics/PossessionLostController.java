package com.joaopimentel.esperancastats.Controller.statistics;

import com.joaopimentel.esperancastats.Entity.statistics.PossessionLost;
import com.joaopimentel.esperancastats.Service.statistics.PossessionLostService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/possessionlost")
public class PossessionLostController {

    private final PossessionLostService possessionLostService;

    public PossessionLostController(PossessionLostService possessionLostService) {
        this.possessionLostService = possessionLostService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<PossessionLost>> getAllPossessionsLost() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PossessionLost> getPossessionLostById(@PathVariable Long id) {
        return ResponseEntity.ok(new PossessionLost());
    }

    @PostMapping
    public ResponseEntity<PossessionLost> createPossessionLost() {
        return ResponseEntity.ok(new PossessionLost());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PossessionLost> editPossessionLost(@PathVariable Long id) {
        return ResponseEntity.ok(new PossessionLost());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletePossessionLostById(@PathVariable Long id) {
        return ResponseEntity.ok("");
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllPossessionsLost() {
        return ResponseEntity.ok("");
    }
}
