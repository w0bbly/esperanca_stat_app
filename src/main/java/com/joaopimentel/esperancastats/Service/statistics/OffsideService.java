package com.joaopimentel.esperancastats.Service.statistics;

import com.joaopimentel.esperancastats.DTO.statistics.OffsideDTO;
import com.joaopimentel.esperancastats.Entity.statistics.Offside;
import com.joaopimentel.esperancastats.Entity.statistics.Statistic;
import com.joaopimentel.esperancastats.Repository.statistics.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OffsideService {

    private final OffsideRepository offsideRepository;
    private final OffsideMapping offsideMapping;
    private final StatisticRepository statisticsRepository;


    public OffsideService(OffsideRepository offsideRepository, OffsideMapping offsideMapping, StatisticRepository statisticsRepository) {
        this.offsideRepository = offsideRepository;
        this.offsideMapping = offsideMapping;
        this.statisticsRepository = statisticsRepository;
    }

    public OffsideDTO getOffsideById(Long id) {
        Optional<Offside> offside = offsideRepository.findById(id);
        return offside.map(offsideMapping::toDto).orElse(null);
    }

    public List<OffsideDTO> getAllOffsides() {
        return offsideMapping.toDto(offsideRepository.findAll());
    }

    public OffsideDTO createOffside(Long statisticId, OffsideDTO dto) {
        Optional<Statistic> statistic = statisticsRepository.findById(statisticId);

        if(statistic.isPresent()) {
            Offside offside = new Offside();
            offside.setStatistic(statistic.get());
            offside.setStateOfGame(dto.getStateOfGame());
            offside.setFieldThirds(dto.getFieldThirds());
            offside.setFieldCorridors(dto.getFieldCorridors());
            offside.setTimeStat(dto.getTimeStat());

            statistic.get().addOffside(offside);

            statisticsRepository.save(statistic.get());
            offsideRepository.save(offside);
            return dto;
        }

        return null;
    }

    public OffsideDTO editOffside(Long id, OffsideDTO dto) {
        Optional<Offside> offside = offsideRepository.findById(id);

        if(offside.isPresent()) {
            offside.get().setTimeStat(dto.getTimeStat());
            offside.get().setFieldThirds(dto.getFieldThirds());
            offside.get().setFieldCorridors(dto.getFieldCorridors());
            offside.get().setStateOfGame(dto.getStateOfGame());

            offsideRepository.save(offside.get());

            return offsideMapping.toDto(offside.get());
        }

        return null;
    }

    public String deleteOffsideById(Long id) {
        Optional<Offside> offside = offsideRepository.findById(id);

        if(offside.isPresent()) {
            offsideRepository.delete(offside.get());
            return "Offside deleted with success!";
        } else
            return null;
    }

    public String deleteAllOffsides() {
        offsideRepository.deleteAll();
        return "All offsides deleted!";
    }
}
