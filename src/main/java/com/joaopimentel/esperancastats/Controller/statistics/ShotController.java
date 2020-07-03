package com.joaopimentel.esperancastats.Controller.statistics;

import com.joaopimentel.esperancastats.DTO.statistics.ShotDTO;
import com.joaopimentel.esperancastats.Entity.statistics.Shot;
import com.joaopimentel.esperancastats.Service.statistics.ShotService;
import com.joaopimentel.esperancastats.Service.statistics.ShotService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/shot")
public class ShotController {

    private final ShotService shotService;

    public ShotController(ShotService shotService) {
        this.shotService = shotService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<ShotDTO>> getAllShots() {
        return ResponseEntity.ok(shotService.getAllShots());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ShotDTO> getShotById(@PathVariable Long id) {
        ShotDTO shotDTO = shotService.getShotById(id);

        if(shotDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(shotDTO);
    }

    @PostMapping(path = "/{statisticId}")
    public ResponseEntity<ShotDTO> createShot(@PathVariable Long statisticId, @RequestBody ShotDTO shot) {
        return ResponseEntity.ok(shotService.createShot(statisticId, shot));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShotDTO> editShot(@PathVariable Long id, @RequestBody ShotDTO shot) {
        ShotDTO shotDTO = shotService.editShot(id, shot);

        if(shotDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(shotDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteShotById(@PathVariable Long id) {
        String outcome = shotService.deleteShotById(id);

        if(outcome == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok(outcome);
        }
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllShots() {
        return ResponseEntity.ok(shotService.deleteAllShots());
    }
}
