package com.joaopimentel.esperancastats.Repository.statistics;

import com.joaopimentel.esperancastats.Config.EntityMapper;
import com.joaopimentel.esperancastats.DTO.statistics.TransitionDTO;
import com.joaopimentel.esperancastats.Entity.statistics.Offside;
import com.joaopimentel.esperancastats.Entity.statistics.Transition;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransitionMapping extends EntityMapper<TransitionDTO, Transition> {
}
