package com.joaopimentel.esperancastats.Service.statistics;

import com.joaopimentel.esperancastats.DTO.statistics.PassDTO;
import com.joaopimentel.esperancastats.DTO.statistics.PassDTO;
import com.joaopimentel.esperancastats.Entity.statistics.Pass;
import com.joaopimentel.esperancastats.Entity.statistics.Statistic;
import com.joaopimentel.esperancastats.Repository.statistics.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassService {

    private final PassRepository passRepository;
    private final PassMapping passMapping;
    private final StatisticsRepository statisticsRepository;


    public PassService(PassRepository passRepository, PassMapping passMapping, StatisticsRepository statisticsRepository) {
        this.passRepository = passRepository;
        this.passMapping = passMapping;
        this.statisticsRepository = statisticsRepository;
    }

    public PassDTO getPassById(Long id) {
        Optional<Pass> pass = passRepository.findById(id);
        return pass.map(passMapping::toDto).orElse(null);
    }

    public List<PassDTO> getAllPasses() {
        return passMapping.toDto(passRepository.findAll());
    }

    public PassDTO createPass(Long statisticId, PassDTO dto) {
        Optional<Statistic> statistic = statisticsRepository.findById(statisticId);

        if(statistic.isPresent()) {
            Pass pass = new Pass();
            pass.setStatistic(statistic.get());
            pass.setActionOutcome(dto.getActionOutcome());
            pass.setTypeOfPass(dto.getTypeOfPass());
            pass.setFieldThirds(dto.getFieldThirds());
            pass.setFieldCorridors(dto.getFieldCorridors());
            pass.setTimeStat(dto.getTimeStat());

            statistic.get().addPass(pass);

            statisticsRepository.save(statistic.get());
            passRepository.save(pass);
            return dto;
        }

        return null;
    }

    public PassDTO editPass(Long id, PassDTO dto) {
        Optional<Pass> pass = passRepository.findById(id);

        if(pass.isPresent()) {
            pass.get().setTimeStat(dto.getTimeStat());
            pass.get().setFieldThirds(dto.getFieldThirds());
            pass.get().setFieldCorridors(dto.getFieldCorridors());
            pass.get().setTypeOfPass(dto.getTypeOfPass());
            pass.get().setActionOutcome(dto.getActionOutcome());

            passRepository.save(pass.get());

            return passMapping.toDto(pass.get());
        }

        return null;
    }

    public String deletePassById(Long id) {
        Optional<Pass> pass = passRepository.findById(id);

        if(pass.isPresent()) {
            passRepository.delete(pass.get());
            return "Pass deleted with success!";
        } else
            return null;
    }

    public String deleteAllPasses() {
        passRepository.deleteAll();
        return "All Passes deleted!";
    }
}
