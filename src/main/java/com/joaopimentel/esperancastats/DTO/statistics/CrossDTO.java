package com.joaopimentel.esperancastats.DTO.statistics;

import com.joaopimentel.esperancastats.Entity.enumerators.Decisions;
import com.joaopimentel.esperancastats.Entity.enumerators.TypeOfCross;
import com.joaopimentel.esperancastats.Entity.statistics.StatCommonClass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CrossDTO extends StatCommonClass {
    private TypeOfCross typeOfCross;
    private Decisions decisions;
}
