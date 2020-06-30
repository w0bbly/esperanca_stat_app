package com.joaopimentel.esperancastats.Entity.statistics;

import com.joaopimentel.esperancastats.Entity.enumerators.FieldCorridors;
import com.joaopimentel.esperancastats.Entity.enumerators.FieldThirds;
import com.joaopimentel.esperancastats.Entity.enumerators.StateOfGame;
import com.joaopimentel.esperancastats.Entity.enumerators.TechnicalGesture;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "possession_lost")
public class PossessionLost {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private StateOfGame stateOfGame;
    @Enumerated(value = EnumType.STRING)
    private TechnicalGesture technicalGesture;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statistic_id", nullable = false)
    private Statistic statistic;
    @Enumerated(value = EnumType.STRING)
    private FieldThirds fieldThirds;
    @Enumerated(value = EnumType.STRING)
    private FieldCorridors fieldCorridors;
    private String timeStat;
}
