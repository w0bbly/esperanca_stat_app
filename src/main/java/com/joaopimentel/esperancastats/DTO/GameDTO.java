package com.joaopimentel.esperancastats.DTO;

import com.joaopimentel.esperancastats.DTO.statistics.StatisticsDTO;
import com.joaopimentel.esperancastats.Entity.enumerators.Result;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class GameDTO {
    private Long id;
    private int homeGoals;
    private int awayGoals;
    private Result result;
    private List<StatisticsDTO> listOfStatistics;
}
