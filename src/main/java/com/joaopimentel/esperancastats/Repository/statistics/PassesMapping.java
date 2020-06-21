package com.joaopimentel.esperancastats.Repository.statistics;

import com.joaopimentel.esperancastats.Config.EntityMapper;
import com.joaopimentel.esperancastats.DTO.statistics.PassesDTO;
import com.joaopimentel.esperancastats.Entity.statistics.Passes;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PassesMapping extends EntityMapper<PassesDTO, Passes> {
}
