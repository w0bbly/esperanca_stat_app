package com.joaopimentel.esperancastats.DTO.statistics;

import com.joaopimentel.esperancastats.Entity.enumerators.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeadBallDTO {
    private TypeOfDeadBall typeOfDeadBall;
    private TypeOfBall typeOfBall;
    private ActionOutcome actionOutcome;
    private FieldThirds fieldThirds;
    private FieldCorridors fieldCorridors;
    private String timeStat;
}
