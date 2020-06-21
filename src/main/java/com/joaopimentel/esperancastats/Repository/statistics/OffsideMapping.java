package com.joaopimentel.esperancastats.Repository.statistics;

import com.joaopimentel.esperancastats.Config.EntityMapper;
import com.joaopimentel.esperancastats.DTO.statistics.OffsideDTO;
import com.joaopimentel.esperancastats.Entity.statistics.Offside;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OffsideMapping extends EntityMapper<OffsideDTO, Offside> {
}
