package com.joaopimentel.esperancastats.Service.statistics;

import com.joaopimentel.esperancastats.DTO.statistics.StatisticDTO;
import com.joaopimentel.esperancastats.Entity.Game;
import com.joaopimentel.esperancastats.Entity.statistics.*;
import com.joaopimentel.esperancastats.Repository.GameRepository;
import com.joaopimentel.esperancastats.Repository.GameSpecs;
import com.joaopimentel.esperancastats.Repository.statistics.StatisticMapping;
import com.joaopimentel.esperancastats.Repository.statistics.StatisticRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class StatisticService {

    private final StatisticRepository statisticRepository;
    private final StatisticMapping statisticMapping;
    private final GameRepository gameRepository;

    public StatisticService(StatisticRepository statisticRepository, StatisticMapping statisticMapping, GameRepository gameRepository) {
        this.statisticRepository = statisticRepository;
        this.statisticMapping = statisticMapping;
        this.gameRepository = gameRepository;
    }

    public StatisticDTO getStatisticById(Long id) {
        Optional<Statistic> statistic = statisticRepository.findById(id);
        return statistic.map(statisticMapping::toDto).orElse(null);
    }

    public List<StatisticDTO> getAllStatistics() {
        return statisticMapping.toDto(statisticRepository.findAll());
    }

    public String deleteStatisticById(Long id) {
        Optional<Statistic> statistic = statisticRepository.findById(id);

        if(statistic.isPresent()) {
            statisticRepository.delete(statistic.get());
            return "Statistic deleted with success!";
        } else
            return null;
    }

    public String deleteAllStatistics() {
        statisticRepository.deleteAll();
        return "All statistics deleted!";
    }

    public StatisticDTO getFilteredStatisticsFromAllGames(Long teamId, Integer minMinutes, Integer maxMinutes, Integer minMatchDay, Integer maxMatchDay) {
        List<Game> games = gameRepository.findAll(where(GameSpecs.ByMatchDay(minMatchDay, maxMatchDay))
                .and(GameSpecs.ByTeamId(teamId)));

        Statistic statistic = new Statistic();

        if(games.size() > 0) {

            games.forEach(game -> {
                game.getStatistic().getCrosses().forEach(cross -> {
                    if(minMinutes > 0 || maxMinutes > 0) {
                        if (firstIntegerOfTime(cross.getTimeStat()) >= minMinutes && firstIntegerOfTime(cross.getTimeStat()) < maxMinutes)
                            statistic.addCross(cross);
                    } else {
                        statistic.addCross(cross);
                    }
                });

                game.getStatistic().getDeadBalls().forEach(deadBall -> {
                    if(minMinutes > 0 || maxMinutes > 0) {
                        if (firstIntegerOfTime(deadBall.getTimeStat()) >= minMinutes && firstIntegerOfTime(deadBall.getTimeStat()) < maxMinutes)
                            statistic.addDeadBall(deadBall);
                    } else {
                        statistic.addDeadBall(deadBall);
                    }
                });

                game.getStatistic().getGoals().forEach(goal -> {
                    if(minMinutes > 0 || maxMinutes > 0) {
                        if (firstIntegerOfTime(goal.getTimeStat()) >= minMinutes && firstIntegerOfTime(goal.getTimeStat()) < maxMinutes)
                            statistic.addGoal(goal);
                    } else {
                        statistic.addGoal(goal);
                    }
                });

                game.getStatistic().getOffsides().forEach(offside -> {
                    if(minMinutes > 0 || maxMinutes > 0) {
                        if (firstIntegerOfTime(offside.getTimeStat()) >= minMinutes && firstIntegerOfTime(offside.getTimeStat()) < maxMinutes)
                            statistic.addOffside(offside);
                    } else {
                        statistic.addOffside(offside);
                    }
                });

                game.getStatistic().getPasses().forEach(pass -> {
                    if(minMinutes > 0 || maxMinutes > 0) {
                        if (firstIntegerOfTime(pass.getTimeStat()) >= minMinutes && firstIntegerOfTime(pass.getTimeStat()) < maxMinutes)
                            statistic.addPass(pass);
                    } else {
                        statistic.addPass(pass);
                    }
                });

                game.getStatistic().getPossessionLosses().forEach(possessionLost -> {
                    if(minMinutes > 0 || maxMinutes > 0) {
                        if (firstIntegerOfTime(possessionLost.getTimeStat()) >= minMinutes && firstIntegerOfTime(possessionLost.getTimeStat()) < maxMinutes)
                            statistic.addPossessionLost(possessionLost);
                    } else {
                        statistic.addPossessionLost(possessionLost);
                    }
                });

                game.getStatistic().getPossessionRecoveries().forEach(possessionRecovery -> {
                    if(minMinutes > 0 || maxMinutes > 0) {
                        if (firstIntegerOfTime(possessionRecovery.getTimeStat()) >= minMinutes && firstIntegerOfTime(possessionRecovery.getTimeStat()) < maxMinutes)
                            statistic.addPossessionRecovery(possessionRecovery);
                    } else {
                        statistic.addPossessionRecovery(possessionRecovery);
                    }
                });

                game.getStatistic().getShots().forEach(shot -> {
                    if(minMinutes > 0 || maxMinutes > 0) {
                        if (firstIntegerOfTime(shot.getTimeStat()) >= minMinutes && firstIntegerOfTime(shot.getTimeStat()) < maxMinutes)
                            statistic.addShot(shot);
                    } else {
                        statistic.addShot(shot);
                    }
                });

                game.getStatistic().getTransitions().forEach(transition -> {
                    if(minMinutes > 0 || maxMinutes > 0) {
                        if (firstIntegerOfTime(transition.getTimeStat()) >= minMinutes && firstIntegerOfTime(transition.getTimeStat()) < maxMinutes)
                            statistic.addTransition(transition);
                    } else {
                        statistic.addTransition(transition);
                    }
                });
            });

            return statisticMapping.toDto(statistic);
        }

        return statisticMapping.toDto(statistic);
    }

    private int firstIntegerOfTime(String time) {
        return Integer.parseInt(time.split(":")[0]);
    }
}
