package com.joaopimentel.esperancastats.DTO.statistics;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class StatisticsDTO {
    private List<CrossesDTO> crosses;
    private BallPossessionDTO ballPossession;
    private List<DeadBallDTO> deadBalls;
    private List<GoalsDTO> goals;
    private List<OffsideDTO> offsides;
    private List<PassesDTO> passes;
    private List<PossessionLostDTO> possessionLosses;
    private List<PossessionRecoveryDTO> possessionRecoveries;
    private List<ShotsDTO> shots;
    private List<TransitionDTO> transitions;
}
