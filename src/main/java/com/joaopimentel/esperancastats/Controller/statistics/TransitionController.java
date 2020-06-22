package com.joaopimentel.esperancastats.Controller.statistics;

import com.joaopimentel.esperancastats.Entity.statistics.Transition;
import com.joaopimentel.esperancastats.Service.statistics.TransitionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/transition")
public class TransitionController {

    private final TransitionService transitionService;

    public TransitionController(TransitionService transitionService) {
        this.transitionService = transitionService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Transition>> getAllTransitions() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Transition> getTransitionById(@PathVariable Long id) {
        return ResponseEntity.ok(new Transition());
    }

    @PostMapping
    public ResponseEntity<Transition> createTransition() {
        return ResponseEntity.ok(new Transition());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transition> editTransition(@PathVariable Long id) {
        return ResponseEntity.ok(new Transition());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteTransitionById(@PathVariable Long id) {
        return ResponseEntity.ok("");
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllTransitions() {
        return ResponseEntity.ok("");
    }
}
