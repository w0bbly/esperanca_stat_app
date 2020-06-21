package com.joaopimentel.esperancastats.Repository;

import com.joaopimentel.esperancastats.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
