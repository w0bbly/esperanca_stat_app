package com.joaopimentel.esperancastats.Entity.statistics;

import com.joaopimentel.esperancastats.Entity.enumerators.ActionOutcome;
import com.joaopimentel.esperancastats.Entity.enumerators.TypeOfBall;
import com.joaopimentel.esperancastats.Entity.enumerators.TypeOfDeadBall;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dead_ball")
public class DeadBall extends StatCommonClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private TypeOfDeadBall typeOfDeadBall;
    @Enumerated(value = EnumType.STRING)
    private TypeOfBall typeOfBall;
    @Enumerated(value = EnumType.STRING)
    private ActionOutcome actionOutcome;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statistics_id", nullable = false)
    private Statistics statistics;
}
