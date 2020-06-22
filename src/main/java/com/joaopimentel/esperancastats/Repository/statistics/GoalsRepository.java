package com.joaopimentel.esperancastats.Repository.statistics;

import com.joaopimentel.esperancastats.Entity.statistics.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalsRepository extends JpaRepository<Goal, Long> {
}
