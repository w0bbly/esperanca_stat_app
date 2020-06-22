package com.joaopimentel.esperancastats.Controller;

import com.joaopimentel.esperancastats.DTO.TeamDTO;
import com.joaopimentel.esperancastats.Entity.Team;
import com.joaopimentel.esperancastats.Service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/team")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<TeamDTO>> getAllTeams() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TeamDTO> getTeamById(@PathVariable Long id) {
        TeamDTO teamDTO = teamService.getTeamById(id);

        if(teamDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(teamDTO);
    }

    @PostMapping
    public ResponseEntity<TeamDTO> createTeam(@RequestBody Team team) {
        return ResponseEntity.ok(teamService.createTeam(team));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamDTO> editTeam(@PathVariable Long id, @RequestBody TeamDTO team) {
        TeamDTO teamDTO = teamService.editTeam(id, team);

        if(teamDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(teamDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteTeamById(@PathVariable Long id) {
        String outcome = teamService.deleteTeamById(id);

        if(outcome == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok(outcome);
        }
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllTeams() {
        return ResponseEntity.ok(teamService.deleteAllTeams());
    }
}
