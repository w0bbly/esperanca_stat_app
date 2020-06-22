package com.joaopimentel.esperancastats.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class TeamDTO {
    private String teamName;
    private List<GameDTO> games;
}
