package com.joaopimentel.esperancastats.Entity.statistics;

import com.joaopimentel.esperancastats.Entity.Game;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "statistic")
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "statistic")
    private List<Cross> crosses;
    @OneToOne(cascade = CascadeType.ALL)
    private BallPossession ballPossession;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "statistic")
    private List<DeadBall> deadBalls;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "statistic")
    private List<Goal> goals;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "statistic")
    private List<Offside> offsides;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "statistic")
    private List<Pass> passes;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "statistic")
    private List<PossessionLost> possessionLosses;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "statistic")
    private List<PossessionRecovery> possessionRecoveries;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "statistic")
    private List<Shot> shots;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "statistic")
    private List<Transition> transitions;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    public void addCross(Cross cross) {
        this.crosses.add(cross);
    }
    public void addGoal(Goal goal) { this.goals.add(goal); }
    public void addDeadBall(DeadBall deadBall) { this.deadBalls.add(deadBall); }
}
