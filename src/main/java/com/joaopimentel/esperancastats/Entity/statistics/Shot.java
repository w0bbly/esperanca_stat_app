package com.joaopimentel.esperancastats.Entity.statistics;

import com.joaopimentel.esperancastats.Entity.enumerators.TypeOfShot;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shot")
public class Shot extends StatCommonClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private TypeOfShot typeOfShot;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statistic_id", nullable = false)
    private Statistic statistic;
}
