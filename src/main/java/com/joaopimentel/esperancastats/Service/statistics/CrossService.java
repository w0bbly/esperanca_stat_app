package com.joaopimentel.esperancastats.Service.statistics;

import com.joaopimentel.esperancastats.DTO.statistics.CrossDTO;
import com.joaopimentel.esperancastats.Entity.statistics.Cross;
import com.joaopimentel.esperancastats.Entity.statistics.Statistic;
import com.joaopimentel.esperancastats.Repository.statistics.CrossMapping;
import com.joaopimentel.esperancastats.Repository.statistics.CrossRepository;
import com.joaopimentel.esperancastats.Repository.statistics.StatisticsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrossService {

    private final CrossRepository crossRepository;
    private final CrossMapping crossMapping;
    private final StatisticsRepository statisticsRepository;


    public CrossService(CrossRepository crossRepository, CrossMapping crossMapping, StatisticsRepository statisticsRepository) {
        this.crossRepository = crossRepository;
        this.crossMapping = crossMapping;
        this.statisticsRepository = statisticsRepository;
    }

    public CrossDTO getCrossById(Long id) {
        Optional<Cross> cross = crossRepository.findById(id);
        return cross.map(crossMapping::toDto).orElse(null);
    }

    public List<CrossDTO> getAllCrosses() {
        return crossMapping.toDto(crossRepository.findAll());
    }

    public CrossDTO createCross(Long statisticId, CrossDTO dto) {
        Optional<Statistic> statistic = statisticsRepository.findById(statisticId);

        if(statistic.isPresent()) {
            Cross cross = new Cross();
            cross.setStatistic(statistic.get());
            cross.setDecisions(dto.getDecisions());
            cross.setTypeOfCross(dto.getTypeOfCross());
            cross.setFieldCorridors(dto.getFieldCorridors());
            cross.setFieldThirds(dto.getFieldThirds());
            cross.setTimeStat(dto.getTimeStat());

            statistic.get().addCross(cross);

            statisticsRepository.save(statistic.get());
            return dto;
        }

        return null;
    }

    public CrossDTO editCross(Long id, CrossDTO dto) {
        Optional<Cross> cross = crossRepository.findById(id);

        if(cross.isPresent()) {
            cross.get().setTimeStat(dto.getTimeStat());
            cross.get().setFieldThirds(dto.getFieldThirds());
            cross.get().setFieldCorridors(dto.getFieldCorridors());
            cross.get().setTypeOfCross(dto.getTypeOfCross());
            cross.get().setDecisions(dto.getDecisions());

            crossRepository.save(cross.get());

            return crossMapping.toDto(cross.get());
        }

        return null;
    }

    public String deleteCrossById(Long id) {
        Optional<Cross> cross = crossRepository.findById(id);

        if(cross.isPresent()) {
            crossRepository.delete(cross.get());
            return "Cross deleted with success!";
        } else
            return null;
    }

    public String deleteAllCrosses() {
        crossRepository.deleteAll();
        return "All crosses deleted!";
    }
}
