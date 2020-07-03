package com.joaopimentel.esperancastats.Service.statistics;

import com.joaopimentel.esperancastats.DTO.statistics.DeadBallDTO;
import com.joaopimentel.esperancastats.Entity.statistics.DeadBall;
import com.joaopimentel.esperancastats.Entity.statistics.Statistic;
import com.joaopimentel.esperancastats.Repository.statistics.DeadBallMapping;
import com.joaopimentel.esperancastats.Repository.statistics.DeadBallRepository;
import com.joaopimentel.esperancastats.Repository.statistics.StatisticRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeadBallService {

    private final DeadBallRepository deadBallRepository;
    private final DeadBallMapping deadBallMapping;
    private final StatisticRepository statisticRepository;


    public DeadBallService(DeadBallRepository deadBallRepository, DeadBallMapping deadBallMapping, StatisticRepository statisticRepository) {
        this.deadBallRepository = deadBallRepository;
        this.deadBallMapping = deadBallMapping;
        this.statisticRepository = statisticRepository;
    }

    public DeadBallDTO getDeadBallById(Long id) {
        Optional<DeadBall> deadBall = deadBallRepository.findById(id);
        return deadBall.map(deadBallMapping::toDto).orElse(null);
    }

    public List<DeadBallDTO> getAllDeadBalls() {
        return deadBallMapping.toDto(deadBallRepository.findAll());
    }

    public DeadBallDTO createDeadBall(Long statisticId, DeadBallDTO dto) {
        Optional<Statistic> statistic = statisticRepository.findById(statisticId);

        if(statistic.isPresent()) {
            DeadBall deadBall = new DeadBall();
            deadBall.setStatistic(statistic.get());
            deadBall.setActionOutcome(dto.getActionOutcome());
            deadBall.setTypeOfBall(dto.getTypeOfBall());
            deadBall.setTypeOfDeadBall(dto.getTypeOfDeadBall());
            deadBall.setFieldThirds(dto.getFieldThirds());
            deadBall.setTimeStat(dto.getTimeStat());
            deadBall.setFieldCorridors(dto.getFieldCorridors());

            statistic.get().addDeadBall(deadBall);

            statisticRepository.save(statistic.get());
            deadBallRepository.save(deadBall);
            return dto;
        }

        return null;
    }

    public DeadBallDTO editDeadBall(Long id, DeadBallDTO dto) {
        Optional<DeadBall> deadBall = deadBallRepository.findById(id);

        if(deadBall.isPresent()) {
            deadBall.get().setTimeStat(dto.getTimeStat());
            deadBall.get().setFieldThirds(dto.getFieldThirds());
            deadBall.get().setFieldCorridors(dto.getFieldCorridors());
            deadBall.get().setTypeOfDeadBall(dto.getTypeOfDeadBall());
            deadBall.get().setTypeOfBall(dto.getTypeOfBall());
            deadBall.get().setActionOutcome(dto.getActionOutcome());

            deadBallRepository.save(deadBall.get());

            return deadBallMapping.toDto(deadBall.get());
        }

        return null;
    }

    public String deleteDeadBallById(Long id) {
        Optional<DeadBall> deadBall = deadBallRepository.findById(id);

        if(deadBall.isPresent()) {
            deadBallRepository.delete(deadBall.get());
            return "DeadBall deleted with success!";
        } else
            return null;
    }

    public String deleteAllDeadBalls() {
        deadBallRepository.deleteAll();
        return "All dead balls deleted!";
    }
}
