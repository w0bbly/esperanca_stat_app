package com.joaopimentel.esperancastats.Entity.statistics;

import com.joaopimentel.esperancastats.Entity.enumerators.ActionOutcome;
import com.joaopimentel.esperancastats.Entity.enumerators.FieldCorridors;
import com.joaopimentel.esperancastats.Entity.enumerators.FieldThirds;
import com.joaopimentel.esperancastats.Entity.enumerators.TypeOfPass;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pass")
public class Pass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private TypeOfPass typeOfPass;
    @Enumerated(value = EnumType.STRING)
    private ActionOutcome actionOutcome;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statistic_id", nullable = false)
    private Statistic statistic;
    @Enumerated(value = EnumType.STRING)
    private FieldThirds fieldThirds;
    @Enumerated(value = EnumType.STRING)
    private FieldCorridors fieldCorridors;
    private String timeStat;
}
