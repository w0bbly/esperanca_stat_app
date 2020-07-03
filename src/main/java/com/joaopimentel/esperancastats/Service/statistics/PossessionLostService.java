package com.joaopimentel.esperancastats.Service.statistics;

import com.joaopimentel.esperancastats.DTO.statistics.PossessionLostDTO;
import com.joaopimentel.esperancastats.Entity.statistics.PossessionLost;
import com.joaopimentel.esperancastats.Entity.statistics.Statistic;
import com.joaopimentel.esperancastats.Repository.statistics.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PossessionLostService {

    private final PossessionLostRepository possessionLostRepository;
    private final PossessionLostMapping possessionLostMapping;
    private final StatisticRepository statisticsRepository;


    public PossessionLostService(PossessionLostRepository possessionLostRepository, PossessionLostMapping possessionLostMapping, StatisticRepository statisticsRepository) {
        this.possessionLostRepository = possessionLostRepository;
        this.possessionLostMapping = possessionLostMapping;
        this.statisticsRepository = statisticsRepository;
    }

    public PossessionLostDTO getPossessionLostById(Long id) {
        Optional<PossessionLost> possessionLost = possessionLostRepository.findById(id);
        return possessionLost.map(possessionLostMapping::toDto).orElse(null);
    }

    public List<PossessionLostDTO> getAllPossessionLosses() {
        return possessionLostMapping.toDto(possessionLostRepository.findAll());
    }

    public PossessionLostDTO createPossessionLost(Long statisticId, PossessionLostDTO dto) {
        Optional<Statistic> statistic = statisticsRepository.findById(statisticId);

        if(statistic.isPresent()) {
            PossessionLost possessionLost = new PossessionLost();
            possessionLost.setStatistic(statistic.get());
            possessionLost.setTechnicalGesture(dto.getTechnicalGesture());
            possessionLost.setStateOfGame(dto.getStateOfGame());
            possessionLost.setFieldThirds(dto.getFieldThirds());
            possessionLost.setFieldCorridors(dto.getFieldCorridors());
            possessionLost.setTimeStat(dto.getTimeStat());

            statistic.get().addPossessionLost(possessionLost);

            statisticsRepository.save(statistic.get());
            possessionLostRepository.save(possessionLost);
            return dto;
        }

        return null;
    }

    public PossessionLostDTO editPossessionLost(Long id, PossessionLostDTO dto) {
        Optional<PossessionLost> possessionLost = possessionLostRepository.findById(id);

        if(possessionLost.isPresent()) {
            possessionLost.get().setTimeStat(dto.getTimeStat());
            possessionLost.get().setFieldThirds(dto.getFieldThirds());
            possessionLost.get().setFieldCorridors(dto.getFieldCorridors());
            possessionLost.get().setStateOfGame(dto.getStateOfGame());
            possessionLost.get().setTechnicalGesture(dto.getTechnicalGesture());

            possessionLostRepository.save(possessionLost.get());

            return possessionLostMapping.toDto(possessionLost.get());
        }

        return null;
    }

    public String deletePossessionLostById(Long id) {
        Optional<PossessionLost> possessionLost = possessionLostRepository.findById(id);

        if(possessionLost.isPresent()) {
            possessionLostRepository.delete(possessionLost.get());
            return "Possession Lost deleted with success!";
        } else
            return null;
    }

    public String deleteAllPossessionLosses() {
        possessionLostRepository.deleteAll();
        return "All lost possessions deleted!";
    }
}
