package com.joaopimentel.esperancastats.DTO.statistics;

import com.joaopimentel.esperancastats.Entity.enumerators.ActionOutcome;
import com.joaopimentel.esperancastats.Entity.enumerators.TypeOfTransition;
import com.joaopimentel.esperancastats.Entity.statistics.StatCommonClass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransitionDTO extends StatCommonClass {
    private TypeOfTransition typeOfTransition;
    private ActionOutcome actionOutcome;
}
