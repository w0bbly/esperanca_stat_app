package com.joaopimentel.esperancastats.Repository;

import com.joaopimentel.esperancastats.Entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
