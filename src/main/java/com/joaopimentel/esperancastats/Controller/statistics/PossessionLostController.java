package com.joaopimentel.esperancastats.Controller.statistics;

import com.joaopimentel.esperancastats.DTO.statistics.PossessionLostDTO;
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
    public ResponseEntity<List<PossessionLostDTO>> getAllPossessionLosses() {
        return ResponseEntity.ok(possessionLostService.getAllPossessionLosses());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PossessionLostDTO> getPossessionLostById(@PathVariable Long id) {
        PossessionLostDTO possessionLostDTO = possessionLostService.getPossessionLostById(id);

        if(possessionLostDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(possessionLostDTO);
    }

    @PostMapping(path = "/{statisticId}")
    public ResponseEntity<PossessionLostDTO> createPossessionLost(@PathVariable Long statisticId, @RequestBody PossessionLostDTO possessionLost) {
        return ResponseEntity.ok(possessionLostService.createPossessionLost(statisticId, possessionLost));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PossessionLostDTO> editPossessionLost(@PathVariable Long id, @RequestBody PossessionLostDTO possessionLost) {
        PossessionLostDTO possessionLostDTO = possessionLostService.editPossessionLost(id, possessionLost);

        if(possessionLostDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(possessionLostDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletePossessionLostById(@PathVariable Long id) {
        String outcome = possessionLostService.deletePossessionLostById(id);

        if(outcome == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok(outcome);
        }
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllPossessionLosses() {
        return ResponseEntity.ok(possessionLostService.deleteAllPossessionLosses());
    }
}
