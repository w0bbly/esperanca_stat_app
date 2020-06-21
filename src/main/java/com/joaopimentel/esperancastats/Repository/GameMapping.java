package com.joaopimentel.esperancastats.Repository;

import com.joaopimentel.esperancastats.Config.EntityMapper;
import com.joaopimentel.esperancastats.DTO.GameDTO;
import com.joaopimentel.esperancastats.Entity.Game;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameMapping extends EntityMapper<GameDTO, Game> {
}
