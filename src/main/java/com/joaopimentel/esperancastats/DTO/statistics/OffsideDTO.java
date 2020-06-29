package com.joaopimentel.esperancastats.DTO.statistics;

import com.joaopimentel.esperancastats.Entity.enumerators.StateOfGame;
import com.joaopimentel.esperancastats.Entity.statistics.StatCommonClass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OffsideDTO extends StatCommonClass {
    private StateOfGame stateOfGame;
}
