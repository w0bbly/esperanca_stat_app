package com.joaopimentel.esperancastats.Repository.statistics;

import com.joaopimentel.esperancastats.Entity.statistics.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticRepository extends JpaRepository<Statistic, Long> {
}
