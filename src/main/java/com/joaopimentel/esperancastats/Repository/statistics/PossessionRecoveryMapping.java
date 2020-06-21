package com.joaopimentel.esperancastats.Repository.statistics;

import com.joaopimentel.esperancastats.Config.EntityMapper;
import com.joaopimentel.esperancastats.DTO.statistics.PossessionRecoveryDTO;
import com.joaopimentel.esperancastats.Entity.statistics.PossessionRecovery;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PossessionRecoveryMapping extends EntityMapper<PossessionRecoveryDTO, PossessionRecovery> {
}
