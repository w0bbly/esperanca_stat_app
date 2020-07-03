package com.joaopimentel.esperancastats.Controller.statistics;

import com.joaopimentel.esperancastats.DTO.statistics.PossessionLostDTO;
import com.joaopimentel.esperancastats.DTO.statistics.PossessionRecoveryDTO;
import com.joaopimentel.esperancastats.Entity.statistics.PossessionRecovery;
import com.joaopimentel.esperancastats.Service.statistics.PossessionLostService;
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
    public ResponseEntity<List<PossessionRecoveryDTO>> getAllPossessionLosses() {
        return ResponseEntity.ok(possessionRecoveryService.getAllPossessionRecoveries());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PossessionRecoveryDTO> getPossessionRecoveryById(@PathVariable Long id) {
        PossessionRecoveryDTO possessionRecoveryDTO = possessionRecoveryService.getPossessionRecoveryById(id);

        if(possessionRecoveryDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(possessionRecoveryDTO);
    }

    @PostMapping(path = "/{statisticId}")
    public ResponseEntity<PossessionRecoveryDTO> createPossessionRecovery(@PathVariable Long statisticId, @RequestBody PossessionRecoveryDTO possessionRecovery) {
        return ResponseEntity.ok(possessionRecoveryService.createPossessionRecovery(statisticId, possessionRecovery));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PossessionRecoveryDTO> editPossessionRecovery(@PathVariable Long id, @RequestBody PossessionRecoveryDTO possessionRecovery) {
        PossessionRecoveryDTO possessionRecoveryDTO = possessionRecoveryService.editPossessionRecovery(id, possessionRecovery);

        if(possessionRecoveryDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(possessionRecoveryDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletePossessionRecoveryById(@PathVariable Long id) {
        String outcome = possessionRecoveryService.deletePossessionRecoveryById(id);

        if(outcome == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok(outcome);
        }
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllPossessionLosses() {
        return ResponseEntity.ok(possessionRecoveryService.deleteAllPossessionRecoveries());
    }
}
