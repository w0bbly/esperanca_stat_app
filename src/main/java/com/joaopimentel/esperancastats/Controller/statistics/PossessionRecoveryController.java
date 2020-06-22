package com.joaopimentel.esperancastats.Controller.statistics;

import com.joaopimentel.esperancastats.Entity.statistics.PossessionRecovery;
import com.joaopimentel.esperancastats.Service.statistics.PossessionRecoveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/possessionrecovery")
public class PossessionRecoveryController {

    private final PossessionRecoveryService possessionRecoveryService;

    public PossessionRecoveryController(PossessionRecoveryService possessionRecoveryService) {
        this.possessionRecoveryService = possessionRecoveryService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<PossessionRecovery>> getAllPossessionsRecovery() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PossessionRecovery> getPossessionRecoveryById(@PathVariable Long id) {
        return ResponseEntity.ok(new PossessionRecovery());
    }

    @PostMapping
    public ResponseEntity<PossessionRecovery> createPossessionRecovery() {
        return ResponseEntity.ok(new PossessionRecovery());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PossessionRecovery> editPossessionRecovery(@PathVariable Long id) {
        return ResponseEntity.ok(new PossessionRecovery());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletePossessionRecoveryById(@PathVariable Long id) {
        return ResponseEntity.ok("");
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllPossessionsRecovery() {
        return ResponseEntity.ok("");
    }
}
