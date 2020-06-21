package com.joaopimentel.esperancastats.Repository;

import com.joaopimentel.esperancastats.Config.EntityMapper;
import com.joaopimentel.esperancastats.DTO.TeamDTO;
import com.joaopimentel.esperancastats.Entity.Team;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapping extends EntityMapper<TeamDTO, Team> {
}
