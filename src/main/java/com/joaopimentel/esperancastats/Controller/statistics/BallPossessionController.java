package com.joaopimentel.esperancastats.Controller.statistics;

import com.joaopimentel.esperancastats.DTO.statistics.BallPossessionDTO;
import com.joaopimentel.esperancastats.Service.statistics.BallPossessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/ballpossession")
public class BallPossessionController {

    private final BallPossessionService ballPossessionService;

    public BallPossessionController(BallPossessionService ballPossessionService) {
        this.ballPossessionService = ballPossessionService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<BallPossessionDTO>> getAllBallPossessions() {
        return ResponseEntity.ok(ballPossessionService.getAllBallPossessions());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BallPossessionDTO> getBallPossessionById(@PathVariable Long id) {
        BallPossessionDTO ballPossessionDTO = ballPossessionService.getBallPossessionById(id);

        if(ballPossessionDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(ballPossessionDTO);
    }

    @PostMapping(path = "/{statisticId}")
    public ResponseEntity<BallPossessionDTO> createBallPossession(@PathVariable Long statisticId, @RequestBody BallPossessionDTO ballPossession) {
        return ResponseEntity.ok(ballPossessionService.createBallPossession(statisticId, ballPossession));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BallPossessionDTO> editBallPossession(@PathVariable Long id, @RequestBody BallPossessionDTO ballPossession) {
        BallPossessionDTO ballPossessionDTO = ballPossessionService.editBallPossession(id, ballPossession);

        if(ballPossessionDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(ballPossessionDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteBallPossessionById(@PathVariable Long id) {
        String outcome = ballPossessionService.deleteBallPossessionById(id);

        if(outcome == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok(outcome);
        }
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllBallPossessions() {
        return ResponseEntity.ok(ballPossessionService.deleteAllBallPossessions());
    }
}
