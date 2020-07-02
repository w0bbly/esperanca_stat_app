package com.joaopimentel.esperancastats.Service.statistics;

import com.joaopimentel.esperancastats.DTO.statistics.BallPossessionDTO;
import com.joaopimentel.esperancastats.Entity.statistics.BallPossession;
import com.joaopimentel.esperancastats.Entity.statistics.Statistic;
import com.joaopimentel.esperancastats.Repository.statistics.BallPossessionMapping;
import com.joaopimentel.esperancastats.Repository.statistics.BallPossessionRepository;
import com.joaopimentel.esperancastats.Repository.statistics.StatisticRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BallPossessionService {

    private final BallPossessionRepository ballPossessionRepository;
    private final BallPossessionMapping ballPossessionMapping;
    private final StatisticRepository statisticRepository;


    public BallPossessionService(BallPossessionRepository ballPossessionRepository, BallPossessionMapping ballPossessionMapping, StatisticRepository statisticRepository) {
        this.ballPossessionRepository = ballPossessionRepository;
        this.ballPossessionMapping = ballPossessionMapping;
        this.statisticRepository = statisticRepository;
    }

    public BallPossessionDTO getBallPossessionById(Long id) {
        Optional<BallPossession> ballPossession = ballPossessionRepository.findById(id);
        return ballPossession.map(ballPossessionMapping::toDto).orElse(null);
    }

    public List<BallPossessionDTO> getAllBallPossessions() {
        return ballPossessionMapping.toDto(ballPossessionRepository.findAll());
    }

    public BallPossessionDTO createBallPossession(Long statisticId, BallPossessionDTO dto) {
        Optional<Statistic> statistic = statisticRepository.findById(statisticId);

        if(statistic.isPresent()) {
            BallPossession ballPossession = new BallPossession();
            ballPossession.setStatistic(statistic.get());
            ballPossession.setTimeOfPossessionAway(dto.getTimeOfPossessionAway());
            ballPossession.setTimeOfPossessionHome(dto.getTimeOfPossessionHome());

            statistic.get().setBallPossession(ballPossession);

            statisticRepository.save(statistic.get());
            ballPossessionRepository.save(ballPossession);
            return dto;
        }

        return null;
    }

    public BallPossessionDTO editBallPossession(Long id, BallPossessionDTO dto) {
        Optional<BallPossession> ballPossession = ballPossessionRepository.findById(id);

        if(ballPossession.isPresent()) {
            ballPossession.get().setTimeOfPossessionHome(dto.getTimeOfPossessionHome());
            ballPossession.get().setTimeOfPossessionAway(dto.getTimeOfPossessionAway());

            ballPossessionRepository.save(ballPossession.get());

            return ballPossessionMapping.toDto(ballPossession.get());
        }

        return null;
    }

    public String deleteBallPossessionById(Long id) {
        Optional<BallPossession> ballPossession = ballPossessionRepository.findById(id);

        if(ballPossession.isPresent()) {
            ballPossessionRepository.delete(ballPossession.get());
            return "Ball possession deleted with success!";
        } else
            return null;
    }

    public String deleteAllBallPossessions() {
        ballPossessionRepository.deleteAll();
        return "All ball possessions deleted!";
    }
}
