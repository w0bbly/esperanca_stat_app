package com.joaopimentel.esperancastats.Controller.statistics;

import com.joaopimentel.esperancastats.DTO.statistics.TransitionDTO;
import com.joaopimentel.esperancastats.Entity.statistics.Transition;
import com.joaopimentel.esperancastats.Service.statistics.TransitionService;
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
    public ResponseEntity<List<TransitionDTO>> getAllTransitions() {
        return ResponseEntity.ok(transitionService.getAllTransitions());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TransitionDTO> getTransitionById(@PathVariable Long id) {
        TransitionDTO transitionDTO = transitionService.getTransitionById(id);

        if(transitionDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(transitionDTO);
    }

    @PostMapping(path = "/{statisticId}")
    public ResponseEntity<TransitionDTO> createTransition(@PathVariable Long statisticId, @RequestBody TransitionDTO transition) {
        return ResponseEntity.ok(transitionService.createTransition(statisticId, transition));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransitionDTO> editTransition(@PathVariable Long id, @RequestBody TransitionDTO transition) {
        TransitionDTO transitionDTO = transitionService.editTransition(id, transition);

        if(transitionDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(transitionDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteTransitionById(@PathVariable Long id) {
        String outcome = transitionService.deleteTransitionById(id);

        if(outcome == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok(outcome);
        }
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllTransitions() {
        return ResponseEntity.ok(transitionService.deleteAllTransitions());
    }
}
