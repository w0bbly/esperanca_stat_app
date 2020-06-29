package com.joaopimentel.esperancastats.DTO.statistics;

import com.joaopimentel.esperancastats.Entity.enumerators.TypeOfShot;
import com.joaopimentel.esperancastats.Entity.statistics.StatCommonClass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShotsDTO extends StatCommonClass {
    private TypeOfShot typeOfShot;
}
