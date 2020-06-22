package com.joaopimentel.esperancastats.DTO.statistics;

import com.joaopimentel.esperancastats.Entity.enumerators.StateOfGame;
import com.joaopimentel.esperancastats.Entity.enumerators.TechnicalGesture;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PossessionLostDTO {
    private StateOfGame stateOfGame;
    private TechnicalGesture technicalGesture;
}