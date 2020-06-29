package com.joaopimentel.esperancastats.Service;

import com.joaopimentel.esperancastats.DTO.GameDTO;
import com.joaopimentel.esperancastats.Entity.Game;
import com.joaopimentel.esperancastats.Entity.Team;
import com.joaopimentel.esperancastats.Entity.statistics.Statistic;
import com.joaopimentel.esperancastats.Repository.GameMapping;
import com.joaopimentel.esperancastats.Repository.GameRepository;
import com.joaopimentel.esperancastats.Repository.TeamRepository;
import com.joaopimentel.esperancastats.Repository.statistics.StatisticsMapping;
import com.joaopimentel.esperancastats.Repository.statistics.StatisticsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final GameMapping gameMapping;
    private final TeamRepository teamRepository;
    private final StatisticsMapping statisticsMapping;
    private final StatisticsRepository statisticsRepository;

    public GameService(GameRepository gameRepository, GameMapping gameMapping, TeamRepository teamRepository, StatisticsMapping statisticsMapping, StatisticsRepository statisticsRepository) {
        this.gameRepository = gameRepository;
        this.gameMapping = gameMapping;
        this.teamRepository = teamRepository;
        this.statisticsMapping = statisticsMapping;
        this.statisticsRepository = statisticsRepository;
    }

    public GameDTO getGameById(Long id) {
        Optional<Game> game = gameRepository.findById(id);

        return game.map(gameMapping::toDto).orElse(null);
    }

    public List<GameDTO> getAllGames() {
        return gameMapping.toDto(gameRepository.findAll());
    }

    public GameDTO createGame(Long teamId, GameDTO gameDTO) {
        Optional<Team> team = teamRepository.findById(teamId);

        if(team.isPresent()) {
            Game game = new Game();
            game.setTypeOfGame(gameDTO.getTypeOfGame());
            game.setTeam(team.get());
            game.setResult(gameDTO.getResult());
            game.setHomeGoals(gameDTO.getHomeGoals());
            game.setAwayGoals(gameDTO.getAwayGoals());

            gameRepository.save(game);

            Statistic statistic = new Statistic();
            statistic.setGame(game);
            statisticsRepository.save(statistic);

            game.setStatistic(statistic);

            List<Game> games = new ArrayList<>();
            games.add(game);
            team.get().setGames(games);

            teamRepository.save(team.get());
            gameRepository.save(game);

            return gameDTO;
        }

        return null;
    }

    public GameDTO editGame(Long id, GameDTO game) {
        Optional<Game> g = gameRepository.findById(id);

        if(g.isPresent()) {
            g.get().setAwayGoals(game.getAwayGoals());
            g.get().setHomeGoals(game.getHomeGoals());
            g.get().setStatistic(statisticsMapping.toEntity(game.getStatistic()));
            g.get().setResult(game.getResult());
            g.get().setTypeOfGame(game.getTypeOfGame());

            gameRepository.save(g.get());

            return gameMapping.toDto(g.get());
        }

        return null;
    }

    public String deleteGameById(Long id) {
        Optional<Game> g = gameRepository.findById(id);

        if(g.isPresent()) {
            gameRepository.delete(g.get());
            return "Game deleted with success!";
        } else
            return null;
    }

    public String deleteAllGames() {
        gameRepository.deleteAll();
        return  "All games deleted with success!";
    }
}
