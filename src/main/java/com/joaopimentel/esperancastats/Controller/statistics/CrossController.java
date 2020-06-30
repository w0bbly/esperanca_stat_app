package com.joaopimentel.esperancastats.Controller.statistics;

import com.joaopimentel.esperancastats.DTO.statistics.CrossDTO;
import com.joaopimentel.esperancastats.Service.statistics.CrossService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/cross")
public class CrossController {

    private final CrossService crossService;

    public CrossController(CrossService crossService) {
        this.crossService = crossService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<CrossDTO>> getAllCrosses() {
        return ResponseEntity.ok(crossService.getAllCrosses());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CrossDTO> getCrossById(@PathVariable Long id) {
        CrossDTO crossDTO = crossService.getCrossById(id);

        if(crossDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(crossDTO);
    }

    @PostMapping(path = "/{statisticId}")
    public ResponseEntity<CrossDTO> createCross(@PathVariable Long statisticId, @RequestBody CrossDTO cross) {
        return ResponseEntity.ok(crossService.createCross(statisticId, cross));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CrossDTO> editBallPossession(@PathVariable Long id, @RequestBody CrossDTO cross) {
        CrossDTO crossDTO = crossService.editCross(id, cross);

        if(crossDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(crossDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteCrossById(@PathVariable Long id) {
        String outcome = crossService.deleteCrossById(id);

        if(outcome == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok(outcome);
        }
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllCrosses() {
        return ResponseEntity.ok(crossService.deleteAllCrosses());
    }
}
