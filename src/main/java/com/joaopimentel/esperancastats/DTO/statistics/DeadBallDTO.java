package com.joaopimentel.esperancastats.DTO.statistics;

import com.joaopimentel.esperancastats.Entity.enumerators.ActionOutcome;
import com.joaopimentel.esperancastats.Entity.enumerators.TypeOfBall;
import com.joaopimentel.esperancastats.Entity.enumerators.TypeOfDeadBall;
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
}
