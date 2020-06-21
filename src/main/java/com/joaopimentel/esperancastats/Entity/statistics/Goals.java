package com.joaopimentel.esperancastats.Entity.statistics;

import com.joaopimentel.esperancastats.Entity.enumerators.StateOfGame;
import com.joaopimentel.esperancastats.Entity.enumerators.TypeOfGoal;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "goals")
public class Goals extends StatCommonClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private StateOfGame stateOfGame;
    @Enumerated(value = EnumType.STRING)
    private TypeOfGoal typeOfGoal;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statistics_id", nullable = false)
    private Statistics statistics;
}
