package com.joaopimentel.esperancastats.DTO.statistics;

import com.joaopimentel.esperancastats.Entity.enumerators.FieldCorridors;
import com.joaopimentel.esperancastats.Entity.enumerators.FieldThirds;
import com.joaopimentel.esperancastats.Entity.enumerators.StateOfGame;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OffsideDTO {
    private StateOfGame stateOfGame;
    private FieldThirds fieldThirds;
    private FieldCorridors fieldCorridors;
    private String timeStat;
}
