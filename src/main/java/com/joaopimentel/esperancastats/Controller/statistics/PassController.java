package com.joaopimentel.esperancastats.Controller.statistics;

import com.joaopimentel.esperancastats.DTO.statistics.PassDTO;
import com.joaopimentel.esperancastats.Entity.statistics.Pass;
import com.joaopimentel.esperancastats.Service.statistics.PassService;
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
    public ResponseEntity<List<PassDTO>> getAllPasses() {
        return ResponseEntity.ok(passService.getAllPasses());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PassDTO> getPassById(@PathVariable Long id) {
        PassDTO passDTO = passService.getPassById(id);

        if(passDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(passDTO);
    }

    @PostMapping(path = "/{statisticId}")
    public ResponseEntity<PassDTO> createPass(@PathVariable Long statisticId, @RequestBody PassDTO pass) {
        return ResponseEntity.ok(passService.createPass(statisticId, pass));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PassDTO> editPass(@PathVariable Long id, @RequestBody PassDTO pass) {
        PassDTO passDTO = passService.editPass(id, pass);

        if(passDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(passDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletePassById(@PathVariable Long id) {
        String outcome = passService.deletePassById(id);

        if(outcome == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok(outcome);
        }
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllPasses() {
        return ResponseEntity.ok(passService.deleteAllPasses());
    }
}
