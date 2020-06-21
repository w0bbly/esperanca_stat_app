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
@Table(name = "shots")
public class Shots extends StatCommonClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private TypeOfShot typeOfShot;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statistics_id", nullable = false)
    private Statistics statistics;
}
