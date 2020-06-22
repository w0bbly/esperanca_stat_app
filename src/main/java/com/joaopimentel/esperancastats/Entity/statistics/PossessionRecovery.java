package com.joaopimentel.esperancastats.Entity.statistics;

import com.joaopimentel.esperancastats.Entity.enumerators.TypeOfOutcome;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "possession_recovery")
public class PossessionRecovery extends StatCommonClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private TypeOfOutcome typeOfOutcome;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statistic_id", nullable = false)
    private Statistic statistic;
}
