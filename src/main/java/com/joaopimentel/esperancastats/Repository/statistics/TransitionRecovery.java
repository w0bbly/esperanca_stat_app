package com.joaopimentel.esperancastats.Repository.statistics;

import com.joaopimentel.esperancastats.Entity.statistics.Transition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransitionRecovery extends JpaRepository<Transition, Long> {
}
