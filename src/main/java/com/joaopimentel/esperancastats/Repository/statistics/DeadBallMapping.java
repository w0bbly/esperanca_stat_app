package com.joaopimentel.esperancastats.Repository.statistics;

import com.joaopimentel.esperancastats.Config.EntityMapper;
import com.joaopimentel.esperancastats.DTO.statistics.DeadBallDTO;
import com.joaopimentel.esperancastats.Entity.statistics.DeadBall;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeadBallMapping extends EntityMapper<DeadBallDTO, DeadBall> {
}
