package com.joaopimentel.esperancastats.Controller.statistics;

import com.joaopimentel.esperancastats.Entity.statistics.Offside;
import com.joaopimentel.esperancastats.Service.statistics.OffsideService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/offside")
public class OffsideController {

    private final OffsideService offsideService;

    public OffsideController(OffsideService offsideService) {
        this.offsideService = offsideService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Offside>> getAllOffsides() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Offside> getOffsideById(@PathVariable Long id) {
        return ResponseEntity.ok(new Offside());
    }

    @PostMapping
    public ResponseEntity<Offside> createOffside() {
        return ResponseEntity.ok(new Offside());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Offside> editOffside(@PathVariable Long id) {
        return ResponseEntity.ok(new Offside());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteOffsideById(@PathVariable Long id) {
        return ResponseEntity.ok("");
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllOffsides() {
        return ResponseEntity.ok("");
    }
}
