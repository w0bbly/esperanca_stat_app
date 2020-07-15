package com.joaopimentel.esperancastats.Controller;

import com.joaopimentel.esperancastats.DTO.GameDTO;
import com.joaopimentel.esperancastats.Service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<GameDTO>> getAllGames() {
        return ResponseEntity.ok(gameService.getAllGames());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<GameDTO> getGameById(@PathVariable Long id) {
        GameDTO gameDTO = gameService.getGameById(id);

        if(gameDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(gameDTO);
    }

    @PostMapping(path = "/{homeTeamId}/{awayTeamId}")
    public ResponseEntity<GameDTO> createGame(@PathVariable Long homeTeamId, @PathVariable Long awayTeamId, @RequestBody GameDTO game) {
        return ResponseEntity.ok(gameService.createGame(homeTeamId, awayTeamId, game));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameDTO> editGame(@PathVariable Long id, @RequestBody GameDTO game) {
        GameDTO gameDTO = gameService.editGame(id, game);

        if(gameDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(gameDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteGameById(@PathVariable Long id) {
        String outcome = gameService.deleteGameById(id);

        if(outcome == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok(outcome);
        }
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllGames() {
        return ResponseEntity.ok(gameService.deleteAllGames());
    }
}
