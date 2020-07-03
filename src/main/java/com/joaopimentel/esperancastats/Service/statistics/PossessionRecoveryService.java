package com.joaopimentel.esperancastats.Service.statistics;

import com.joaopimentel.esperancastats.DTO.statistics.PossessionRecoveryDTO;
import com.joaopimentel.esperancastats.Entity.statistics.PossessionRecovery;
import com.joaopimentel.esperancastats.Entity.statistics.Statistic;
import com.joaopimentel.esperancastats.Repository.statistics.PossessionRecoveryMapping;
import com.joaopimentel.esperancastats.Repository.statistics.PossessionRecoveryRepository;
import com.joaopimentel.esperancastats.Repository.statistics.StatisticRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PossessionRecoveryService {

    private final PossessionRecoveryRepository possessionRecoveryRepository;
    private final PossessionRecoveryMapping possessionRecoveryMapping;
    private final StatisticRepository statisticRepository;


    public PossessionRecoveryService(PossessionRecoveryRepository possessionRecoveryRepository, PossessionRecoveryMapping possessionRecoveryMapping, StatisticRepository statisticRepository) {
        this.possessionRecoveryRepository = possessionRecoveryRepository;
        this.possessionRecoveryMapping = possessionRecoveryMapping;
        this.statisticRepository = statisticRepository;
    }

    public PossessionRecoveryDTO getPossessionRecoveryById(Long id) {
        Optional<PossessionRecovery> possessionRecovery = possessionRecoveryRepository.findById(id);
        return possessionRecovery.map(possessionRecoveryMapping::toDto).orElse(null);
    }

    public List<PossessionRecoveryDTO> getAllPossessionRecoveries() {
        return possessionRecoveryMapping.toDto(possessionRecoveryRepository.findAll());
    }

    public PossessionRecoveryDTO createPossessionRecovery(Long statisticId, PossessionRecoveryDTO dto) {
        Optional<Statistic> statistic = statisticRepository.findById(statisticId);

        if(statistic.isPresent()) {
            PossessionRecovery possessionRecovery = new PossessionRecovery();
            possessionRecovery.setStatistic(statistic.get());
            possessionRecovery.setTypeOfOutcome(dto.getTypeOfOutcome());
            possessionRecovery.setFieldThirds(dto.getFieldThirds());
            possessionRecovery.setFieldCorridors(dto.getFieldCorridors());
            possessionRecovery.setTimeStat(dto.getTimeStat());

            statistic.get().addPossessionRecovery(possessionRecovery);

            statisticRepository.save(statistic.get());
            possessionRecoveryRepository.save(possessionRecovery);
            return dto;
        }

        return null;
    }

    public PossessionRecoveryDTO editPossessionRecovery(Long id, PossessionRecoveryDTO dto) {
        Optional<PossessionRecovery> possessionRecovery = possessionRecoveryRepository.findById(id);

        if(possessionRecovery.isPresent()) {
            possessionRecovery.get().setTimeStat(dto.getTimeStat());
            possessionRecovery.get().setFieldThirds(dto.getFieldThirds());
            possessionRecovery.get().setFieldCorridors(dto.getFieldCorridors());
            possessionRecovery.get().setTypeOfOutcome(dto.getTypeOfOutcome());

            possessionRecoveryRepository.save(possessionRecovery.get());

            return possessionRecoveryMapping.toDto(possessionRecovery.get());
        }

        return null;
    }

    public String deletePossessionRecoveryById(Long id) {
        Optional<PossessionRecovery> possessionRecovery = possessionRecoveryRepository.findById(id);

        if(possessionRecovery.isPresent()) {
            possessionRecoveryRepository.delete(possessionRecovery.get());
            return "Possession recovery deleted with success!";
        } else
            return null;
    }

    public String deleteAllPossessionRecoveries() {
        possessionRecoveryRepository.deleteAll();
        return "All possession recoveries deleted!";
    }
}
