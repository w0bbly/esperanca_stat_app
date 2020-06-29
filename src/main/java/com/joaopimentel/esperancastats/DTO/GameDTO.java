package com.joaopimentel.esperancastats.DTO;

import com.joaopimentel.esperancastats.DTO.statistics.StatisticsDTO;
import com.joaopimentel.esperancastats.Entity.enumerators.Result;
import com.joaopimentel.esperancastats.Entity.enumerators.TypeOfGame;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GameDTO {
    private int homeGoals;
    private int awayGoals;
    private Result result;
    private TypeOfGame typeOfGame;
    private StatisticsDTO statistic;
}
