package com.joaopimentel.esperancastats.Controller.statistics;

import com.joaopimentel.esperancastats.DTO.statistics.OffsideDTO;
import com.joaopimentel.esperancastats.Entity.statistics.Offside;
import com.joaopimentel.esperancastats.Service.statistics.OffsideService;
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
    public ResponseEntity<List<OffsideDTO>> getAllOffsides() {
        return ResponseEntity.ok(offsideService.getAllOffsides());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<OffsideDTO> getOffsideById(@PathVariable Long id) {
        OffsideDTO offsideDTO = offsideService.getOffsideById(id);

        if(offsideDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(offsideDTO);
    }

    @PostMapping(path = "/{statisticId}")
    public ResponseEntity<OffsideDTO> createOffside(@PathVariable Long statisticId, @RequestBody OffsideDTO offside) {
        return ResponseEntity.ok(offsideService.createOffside(statisticId, offside));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OffsideDTO> editOffside(@PathVariable Long id, @RequestBody OffsideDTO offside) {
        OffsideDTO offsideDTO = offsideService.editOffside(id, offside);

        if(offsideDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(offsideDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteOffsideById(@PathVariable Long id) {
        String outcome = offsideService.deleteOffsideById(id);

        if(outcome == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok(outcome);
        }
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllOffsides() {
        return ResponseEntity.ok(offsideService.deleteAllOffsides());
    }
}
