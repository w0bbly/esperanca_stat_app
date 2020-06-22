package com.joaopimentel.esperancastats.Controller;

import com.joaopimentel.esperancastats.Entity.Game;
import com.joaopimentel.esperancastats.Service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Game>> getAllGames() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Long id) {
        return ResponseEntity.ok(new Game());
    }

    @PostMapping
    public ResponseEntity<Game> createGame() {
        return ResponseEntity.ok(new Game());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> editGame(@PathVariable Long id) {
        return ResponseEntity.ok(new Game());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteGameById(@PathVariable Long id) {
        return ResponseEntity.ok("");
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllGames() {
        return ResponseEntity.ok("");
    }
}
