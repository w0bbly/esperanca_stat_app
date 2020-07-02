package com.joaopimentel.esperancastats.Repository.statistics;

import com.joaopimentel.esperancastats.Config.EntityMapper;
import com.joaopimentel.esperancastats.DTO.statistics.ShotDTO;
import com.joaopimentel.esperancastats.Entity.statistics.Shot;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShotMapping extends EntityMapper<ShotDTO, Shot> {
}
