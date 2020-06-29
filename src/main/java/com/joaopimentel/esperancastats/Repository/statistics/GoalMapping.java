package com.joaopimentel.esperancastats.Repository.statistics;

import com.joaopimentel.esperancastats.Config.EntityMapper;
import com.joaopimentel.esperancastats.DTO.statistics.GoalDTO;
import com.joaopimentel.esperancastats.Entity.statistics.Goal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GoalMapping extends EntityMapper<GoalDTO, Goal> {
}
