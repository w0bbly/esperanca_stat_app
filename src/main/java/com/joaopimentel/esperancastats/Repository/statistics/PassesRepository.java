package com.joaopimentel.esperancastats.Repository.statistics;

import com.joaopimentel.esperancastats.Entity.statistics.Pass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassesRepository extends JpaRepository<Pass, Long> {
}
