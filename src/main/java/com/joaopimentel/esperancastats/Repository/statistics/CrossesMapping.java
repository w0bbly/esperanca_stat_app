package com.joaopimentel.esperancastats.Repository.statistics;

import com.joaopimentel.esperancastats.Config.EntityMapper;
import com.joaopimentel.esperancastats.DTO.statistics.CrossesDTO;
import com.joaopimentel.esperancastats.Entity.statistics.Crosses;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CrossesMapping extends EntityMapper<CrossesDTO, Crosses> {
}
