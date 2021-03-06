package com.joaopimentel.esperancastats.Service;

import com.joaopimentel.esperancastats.DTO.GameDTO;
import com.joaopimentel.esperancastats.Entity.Game;
import com.joaopimentel.esperancastats.Entity.Team;
import com.joaopimentel.esperancastats.Entity.statistics.Statistic;
import com.joaopimentel.esperancastats.Repository.GameMapping;
import com.joaopimentel.esperancastats.Repository.GameRepository;
import com.joaopimentel.esperancastats.Repository.TeamRepository;
import com.joaopimentel.esperancastats.Repository.statistics.StatisticMapping;
import com.joaopimentel.esperancastats.Repository.statistics.StatisticRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final GameMapping gameMapping;
    private final TeamRepository teamRepository;
    private final StatisticMapping statisticMapping;
    private final StatisticRepository statisticRepository;

    public GameService(GameRepository gameRepository, GameMapping gameMapping, TeamRepository teamRepository, StatisticMapping statisticMapping, StatisticRepository statisticRepository) {
        this.gameRepository = gameRepository;
        this.gameMapping = gameMapping;
        this.teamRepository = teamRepository;
        this.statisticMapping = statisticMapping;
        this.statisticRepository = statisticRepository;
    }

    public GameDTO getGameById(Long id) {
        Optional<Game> game = gameRepository.findById(id);

        return game.map(gameMapping::toDto).orElse(null);
    }

    public List<GameDTO> getAllGames() {
        return gameMapping.toDto(gameRepository.findAll());
    }

    public GameDTO createGame(Long teamIdOne, Long teamIdTwo, GameDTO gameDTO) {
        Optional<Team> teamOne = teamRepository.findById(teamIdOne);
        Optional<Team> teamTwo = teamRepository.findById(teamIdTwo);

        if(teamOne.isPresent() && teamTwo.isPresent()) {
            List<Team> teams = new ArrayList<>();
            teams.add(teamOne.get());
            teams.add(teamTwo.get());

            Game game = new Game();
            game.setTypeOfGame(gameDTO.getTypeOfGame());
            game.setTeams(teams);
            game.setResult(gameDTO.getResult());
            game.setHomeGoals(gameDTO.getHomeGoals());
            game.setAwayGoals(gameDTO.getAwayGoals());

            gameRepository.save(game);

            Statistic statistic = new Statistic();
            statistic.setGame(game);
            statisticRepository.save(statistic);

            game.setStatistic(statistic);

            List<Game> games = new ArrayList<>();
            games.add(game);
            teamOne.get().setGames(games);
            teamTwo.get().setGames(games);

            teamRepository.save(teamOne.get());
            teamRepository.save(teamTwo.get());
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
            g.get().setStatistic(statisticMapping.toEntity(game.getStatistic()));
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
