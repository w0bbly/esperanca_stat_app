package com.joaopimentel.esperancastats.Entity.statistics;

import com.joaopimentel.esperancastats.Entity.enumerators.Decisions;
import com.joaopimentel.esperancastats.Entity.enumerators.TypeOfCross;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cross")
public class Cross extends StatCommonClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private TypeOfCross typeOfCross;
    @Enumerated(value = EnumType.STRING)
    private Decisions decisions;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statistic_id", nullable = false)
    private Statistic statistic;
}
