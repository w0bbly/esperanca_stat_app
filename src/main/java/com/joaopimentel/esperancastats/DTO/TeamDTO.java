package com.joaopimentel.esperancastats.DTO;

import com.joaopimentel.esperancastats.Entity.Game;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class TeamDTO {
    private String teamName;
    private List<Game> games;
}
