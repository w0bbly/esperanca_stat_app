package com.joaopimentel.esperancastats.Repository;

import com.joaopimentel.esperancastats.Entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long>, JpaSpecificationExecutor<Game> {
    List<Game> findAllByTeamId(Long teamId);
}
