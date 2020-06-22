package com.joaopimentel.esperancastats.Controller.statistics;

import com.joaopimentel.esperancastats.Entity.statistics.Cross;
import com.joaopimentel.esperancastats.Service.statistics.CrossService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/crosses")
public class CrossController {

    private final CrossService crossService;

    public CrossController(CrossService crossService) {
        this.crossService = crossService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Cross>> getAllCrosses() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Cross> getCrossById(@PathVariable Long id) {
        return ResponseEntity.ok(new Cross());
    }

    @PostMapping
    public ResponseEntity<Cross> createCross() {
        return ResponseEntity.ok(new Cross());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cross> editCross(@PathVariable Long id) {
        return ResponseEntity.ok(new Cross());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteCrossById(@PathVariable Long id) {
        return ResponseEntity.ok("");
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllCrosses() {
        return ResponseEntity.ok("");
    }
}
