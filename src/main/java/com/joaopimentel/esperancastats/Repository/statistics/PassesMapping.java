package com.joaopimentel.esperancastats.Repository.statistics;

import com.joaopimentel.esperancastats.Config.EntityMapper;
import com.joaopimentel.esperancastats.DTO.statistics.PassDTO;
import com.joaopimentel.esperancastats.Entity.statistics.Pass;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PassesMapping extends EntityMapper<PassDTO, Pass> {
}
