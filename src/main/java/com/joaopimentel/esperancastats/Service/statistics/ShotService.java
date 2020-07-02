package com.joaopimentel.esperancastats.Service.statistics;

import com.joaopimentel.esperancastats.DTO.statistics.ShotDTO;
import com.joaopimentel.esperancastats.Entity.statistics.Shot;
import com.joaopimentel.esperancastats.Entity.statistics.Statistic;
import com.joaopimentel.esperancastats.Repository.statistics.ShotMapping;
import com.joaopimentel.esperancastats.Repository.statistics.ShotRepository;
import com.joaopimentel.esperancastats.Repository.statistics.StatisticRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShotService {

    private final ShotRepository shotRepository;
    private final ShotMapping shotMapping;
    private final StatisticRepository statisticRepository;


    public ShotService(ShotRepository shotRepository, ShotMapping shotMapping, StatisticRepository statisticRepository) {
        this.shotRepository = shotRepository;
        this.shotMapping = shotMapping;
        this.statisticRepository = statisticRepository;
    }

    public ShotDTO getShotById(Long id) {
        Optional<Shot> shot = shotRepository.findById(id);
        return shot.map(shotMapping::toDto).orElse(null);
    }

    public List<ShotDTO> getAllShots() {
        return shotMapping.toDto(shotRepository.findAll());
    }

    public ShotDTO createShot(Long statisticId, ShotDTO dto) {
        Optional<Statistic> statistic = statisticRepository.findById(statisticId);

        if(statistic.isPresent()) {
            Shot shot = new Shot();
            shot.setStatistic(statistic.get());
            shot.setTypeOfShot(dto.getTypeOfShot());
            shot.setFieldThirds(dto.getFieldThirds());
            shot.setFieldCorridors(dto.getFieldCorridors());
            shot.setTimeStat(dto.getTimeStat());

            statistic.get().addShot(shot);

            statisticRepository.save(statistic.get());
            shotRepository.save(shot);
            return dto;
        }

        return null;
    }

    public ShotDTO editShot(Long id, ShotDTO dto) {
        Optional<Shot> shot = shotRepository.findById(id);

        if(shot.isPresent()) {
            shot.get().setTimeStat(dto.getTimeStat());
            shot.get().setFieldThirds(dto.getFieldThirds());
            shot.get().setFieldCorridors(dto.getFieldCorridors());
            shot.get().setTypeOfShot(dto.getTypeOfShot());

            shotRepository.save(shot.get());

            return shotMapping.toDto(shot.get());
        }

        return null;
    }

    public String deleteShotById(Long id) {
        Optional<Shot> shot = shotRepository.findById(id);

        if(shot.isPresent()) {
            shotRepository.delete(shot.get());
            return "Shot deleted with success!";
        } else
            return null;
    }

    public String deleteAllShots() {
        shotRepository.deleteAll();
        return "All shots deleted!";
    }
}
