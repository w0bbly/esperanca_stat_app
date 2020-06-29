package com.joaopimentel.esperancastats.Repository.statistics;

import com.joaopimentel.esperancastats.Config.EntityMapper;
import com.joaopimentel.esperancastats.DTO.statistics.CrossDTO;
import com.joaopimentel.esperancastats.Entity.statistics.Cross;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CrossMapping extends EntityMapper<CrossDTO, Cross> {
}
