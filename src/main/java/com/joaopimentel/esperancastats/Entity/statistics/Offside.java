package com.joaopimentel.esperancastats.Entity.statistics;

import com.joaopimentel.esperancastats.Entity.enumerators.StateOfGame;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "offside")
public class Offside extends StatCommonClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private StateOfGame stateOfGame;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statistic_id", nullable = false)
    private Statistic statistic;
}
