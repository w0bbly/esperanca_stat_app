package com.joaopimentel.esperancastats.Repository.statistics;

import com.joaopimentel.esperancastats.Config.EntityMapper;
import com.joaopimentel.esperancastats.DTO.statistics.GoalsDTO;
import com.joaopimentel.esperancastats.Entity.statistics.Goals;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GoalsMapping extends EntityMapper<GoalsDTO, Goals> {
}
