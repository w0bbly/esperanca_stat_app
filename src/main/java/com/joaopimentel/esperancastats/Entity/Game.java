package com.joaopimentel.esperancastats.Entity;

import com.joaopimentel.esperancastats.Entity.enumerators.Result;
import com.joaopimentel.esperancastats.Entity.enumerators.TypeOfGame;
import com.joaopimentel.esperancastats.Entity.statistics.Statistic;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private int homeGoals;
    private int awayGoals;
    @Enumerated(value = EnumType.STRING)
    private Result result;
    @Enumerated(value = EnumType.STRING)
    private TypeOfGame typeOfGame;
    @OneToOne(cascade = CascadeType.ALL)
    private Statistic statistic;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;
}
