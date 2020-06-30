package com.joaopimentel.esperancastats.DTO.statistics;

import com.joaopimentel.esperancastats.Entity.enumerators.FieldCorridors;
import com.joaopimentel.esperancastats.Entity.enumerators.FieldThirds;
import com.joaopimentel.esperancastats.Entity.enumerators.TypeOfOutcome;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PossessionRecoveryDTO {
    private TypeOfOutcome typeOfOutcome;
    private FieldThirds fieldThirds;
    private FieldCorridors fieldCorridors;
    private String timeStat;
}
