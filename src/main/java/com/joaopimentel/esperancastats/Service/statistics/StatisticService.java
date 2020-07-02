package com.joaopimentel.esperancastats.Service.statistics;

import com.joaopimentel.esperancastats.DTO.statistics.StatisticDTO;
import com.joaopimentel.esperancastats.Entity.statistics.Statistic;
import com.joaopimentel.esperancastats.Repository.statistics.StatisticMapping;
import com.joaopimentel.esperancastats.Repository.statistics.StatisticRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatisticService {

    private final StatisticRepository statisticRepository;
    private final StatisticMapping statisticMapping;

    public StatisticService(StatisticRepository statisticRepository, StatisticMapping statisticMapping) {
        this.statisticRepository = statisticRepository;
        this.statisticMapping = statisticMapping;
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
}
