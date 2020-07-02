package com.joaopimentel.esperancastats.Service.statistics;

import com.joaopimentel.esperancastats.DTO.statistics.GoalDTO;
import com.joaopimentel.esperancastats.Entity.statistics.Goal;
import com.joaopimentel.esperancastats.Entity.statistics.Statistic;
import com.joaopimentel.esperancastats.Repository.statistics.GoalMapping;
import com.joaopimentel.esperancastats.Repository.statistics.GoalRepository;
import com.joaopimentel.esperancastats.Repository.statistics.StatisticRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalService {

    private final GoalRepository goalRepository;
    private final GoalMapping goalMapping;
    private final StatisticRepository statisticRepository;


    public GoalService(GoalRepository goalRepository, GoalMapping goalMapping, StatisticRepository statisticRepository) {
        this.goalRepository = goalRepository;
        this.goalMapping = goalMapping;
        this.statisticRepository = statisticRepository;
    }

    public GoalDTO getGoalById(Long id) {
        Optional<Goal> goal = goalRepository.findById(id);
        return goal.map(goalMapping::toDto).orElse(null);
    }

    public List<GoalDTO> getAllGoals() {
        return goalMapping.toDto(goalRepository.findAll());
    }

    public GoalDTO createGoal(Long statisticId, GoalDTO dto) {
        Optional<Statistic> statistic = statisticRepository.findById(statisticId);

        if(statistic.isPresent()) {
            Goal goal = new Goal();
            goal.setStatistic(statistic.get());
            goal.setStateOfGame(dto.getStateOfGame());
            goal.setTypeOfGoal(dto.getTypeOfGoal());
            goal.setFieldThirds(dto.getFieldThirds());
            goal.setFieldCorridors(dto.getFieldCorridors());
            goal.setTimeStat(dto.getTimeStat());

            statistic.get().addGoal(goal);

            statisticRepository.save(statistic.get());
            goalRepository.save(goal);
            return dto;
        }

        return null;
    }

    public GoalDTO editGoal(Long id, GoalDTO dto) {
        Optional<Goal> goal = goalRepository.findById(id);

        if(goal.isPresent()) {
            goal.get().setTimeStat(dto.getTimeStat());
            goal.get().setFieldThirds(dto.getFieldThirds());
            goal.get().setFieldCorridors(dto.getFieldCorridors());
            goal.get().setTypeOfGoal(dto.getTypeOfGoal());
            goal.get().setStateOfGame(dto.getStateOfGame());

            goalRepository.save(goal.get());

            return goalMapping.toDto(goal.get());
        }

        return null;
    }

    public String deleteGoalById(Long id) {
        Optional<Goal> goal = goalRepository.findById(id);

        if(goal.isPresent()) {
            goalRepository.delete(goal.get());
            return "Goal deleted with success!";
        } else
            return null;
    }

    public String deleteAllGoals() {
        goalRepository.deleteAll();
        return "All goals deleted!";
    }
}
