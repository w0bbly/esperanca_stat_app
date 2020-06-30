package com.joaopimentel.esperancastats.Entity.statistics;

import com.joaopimentel.esperancastats.Entity.enumerators.FieldCorridors;
import com.joaopimentel.esperancastats.Entity.enumerators.FieldThirds;
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
public class Shot {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private TypeOfShot typeOfShot;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statistic_id", nullable = false)
    private Statistic statistic;
    @Enumerated(value = EnumType.STRING)
    private FieldThirds fieldThirds;
    @Enumerated(value = EnumType.STRING)
    private FieldCorridors fieldCorridors;
    private String timeStat;
}
