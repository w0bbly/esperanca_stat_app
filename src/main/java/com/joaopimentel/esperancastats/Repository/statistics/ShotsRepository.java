package com.joaopimentel.esperancastats.Repository.statistics;

import com.joaopimentel.esperancastats.Entity.statistics.Shot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShotsRepository extends JpaRepository<Shot, Long> {
}
