package com.joaopimentel.esperancastats.Repository.statistics;

import com.joaopimentel.esperancastats.Config.EntityMapper;
import com.joaopimentel.esperancastats.DTO.statistics.StatisticsDTO;
import com.joaopimentel.esperancastats.Entity.statistics.Statistic;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatisticsMapping extends EntityMapper<StatisticsDTO, Statistic> {
}
