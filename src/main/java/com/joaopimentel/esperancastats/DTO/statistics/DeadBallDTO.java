package com.joaopimentel.esperancastats.DTO.statistics;

import com.joaopimentel.esperancastats.Entity.enumerators.ActionOutcome;
import com.joaopimentel.esperancastats.Entity.enumerators.TypeOfBall;
import com.joaopimentel.esperancastats.Entity.enumerators.TypeOfDeadBall;
import com.joaopimentel.esperancastats.Entity.statistics.StatCommonClass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeadBallDTO extends StatCommonClass {
    private TypeOfDeadBall typeOfDeadBall;
    private TypeOfBall typeOfBall;
    private ActionOutcome actionOutcome;
}
