package com.joaopimentel.esperancastats.Controller.statistics;

import com.joaopimentel.esperancastats.Entity.statistics.Pass;
import com.joaopimentel.esperancastats.Service.statistics.PassService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/pass")
public class PassController {

    private final PassService passService;

    public PassController(PassService passService) {
        this.passService = passService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Pass>> getAllPasses() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Pass> getPassById(@PathVariable Long id) {
        return ResponseEntity.ok(new Pass());
    }

    @PostMapping
    public ResponseEntity<Pass> createPass() {
        return ResponseEntity.ok(new Pass());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pass> editPass(@PathVariable Long id) {
        return ResponseEntity.ok(new Pass());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletePassById(@PathVariable Long id) {
        return ResponseEntity.ok("");
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllPasses() {
        return ResponseEntity.ok("");
    }
}
