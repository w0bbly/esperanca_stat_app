package com.joaopimentel.esperancastats.Repository.statistics;

import com.joaopimentel.esperancastats.Config.EntityMapper;
import com.joaopimentel.esperancastats.DTO.statistics.BallPossessionDTO;
import com.joaopimentel.esperancastats.Entity.statistics.BallPossession;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BallPossessionMapping extends EntityMapper<BallPossessionDTO, BallPossession> {
}
