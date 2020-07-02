package com.joaopimentel.esperancastats.Service.statistics;

import com.joaopimentel.esperancastats.DTO.statistics.TransitionDTO;
import com.joaopimentel.esperancastats.Entity.statistics.Statistic;
import com.joaopimentel.esperancastats.Entity.statistics.Transition;
import com.joaopimentel.esperancastats.Repository.statistics.StatisticRepository;
import com.joaopimentel.esperancastats.Repository.statistics.TransitionMapping;
import com.joaopimentel.esperancastats.Repository.statistics.TransitionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransitionService {

    private final TransitionRepository transitionRepository;
    private final TransitionMapping transitionMapping;
    private final StatisticRepository statisticRepository;


    public TransitionService(TransitionRepository transitionRepository, TransitionMapping transitionMapping, StatisticRepository statisticRepository) {
        this.transitionRepository = transitionRepository;
        this.transitionMapping = transitionMapping;
        this.statisticRepository = statisticRepository;
    }

    public TransitionDTO getTransitionById(Long id) {
        Optional<Transition> transition = transitionRepository.findById(id);
        return transition.map(transitionMapping::toDto).orElse(null);
    }

    public List<TransitionDTO> getAllTransitions() {
        return transitionMapping.toDto(transitionRepository.findAll());
    }

    public TransitionDTO createTransition(Long statisticId, TransitionDTO dto) {
        Optional<Statistic> statistic = statisticRepository.findById(statisticId);

        if(statistic.isPresent()) {
            Transition transition = new Transition();
            transition.setStatistic(statistic.get());
            transition.setActionOutcome(dto.getActionOutcome());
            transition.setTypeOfTransition(dto.getTypeOfTransition());
            transition.setFieldThirds(dto.getFieldThirds());
            transition.setFieldCorridors(dto.getFieldCorridors());
            transition.setTimeStat(dto.getTimeStat());

            statistic.get().addTransition(transition);

            statisticRepository.save(statistic.get());
            transitionRepository.save(transition);
            return dto;
        }

        return null;
    }

    public TransitionDTO editTransition(Long id, TransitionDTO dto) {
        Optional<Transition> transition = transitionRepository.findById(id);

        if(transition.isPresent()) {
            transition.get().setTimeStat(dto.getTimeStat());
            transition.get().setFieldThirds(dto.getFieldThirds());
            transition.get().setFieldCorridors(dto.getFieldCorridors());
            transition.get().setTypeOfTransition(dto.getTypeOfTransition());
            transition.get().setActionOutcome(dto.getActionOutcome());

            transitionRepository.save(transition.get());

            return transitionMapping.toDto(transition.get());
        }

        return null;
    }

    public String deleteTransitionById(Long id) {
        Optional<Transition> transition = transitionRepository.findById(id);

        if(transition.isPresent()) {
            transitionRepository.delete(transition.get());
            return "Transition deleted with success!";
        } else
            return null;
    }

    public String deleteAllTransitions() {
        transitionRepository.deleteAll();
        return "All transitions deleted!";
    }
}
