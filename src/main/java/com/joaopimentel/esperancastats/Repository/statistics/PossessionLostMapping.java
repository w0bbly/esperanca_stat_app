package com.joaopimentel.esperancastats.Repository.statistics;

import com.joaopimentel.esperancastats.Config.EntityMapper;
import com.joaopimentel.esperancastats.DTO.statistics.PossessionLostDTO;
import com.joaopimentel.esperancastats.Entity.statistics.PossessionLost;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PossessionLostMapping extends EntityMapper<PossessionLostDTO, PossessionLost> {
}
