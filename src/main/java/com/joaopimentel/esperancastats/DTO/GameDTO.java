package com.joaopimentel.esperancastats.DTO;

import com.joaopimentel.esperancastats.Entity.enumerators.Result;
import com.joaopimentel.esperancastats.Entity.statistics.Statistics;
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
    private List<Statistics> listOfStatistics;
}
