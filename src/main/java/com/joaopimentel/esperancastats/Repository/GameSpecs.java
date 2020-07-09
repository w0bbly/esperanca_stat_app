package com.joaopimentel.esperancastats.Repository;

import com.joaopimentel.esperancastats.Entity.Game;
import org.springframework.data.jpa.domain.Specification;

public class GameSpecs {

    public static Specification<Game> ByMatchDay(Integer minMatchDay, Integer maxMatchDay) {
        return (Specification<Game>) (root, criteriaQuery, criteriaBuilder) -> {
            if(minMatchDay == null && maxMatchDay == null)
                return null;
            if(minMatchDay != null && maxMatchDay == null)
                return criteriaBuilder.greaterThanOrEqualTo(root.get("matchDay"), minMatchDay);
            if(minMatchDay == null)
                return criteriaBuilder.lessThanOrEqualTo(root.get("matchDay"), maxMatchDay);

            return criteriaBuilder.between(root.get("value"), minMatchDay, maxMatchDay);
        };
    }

    public static Specification<Game> ByTeamId(Long teamId) {
        return (Specification<Game>) (root, criteriaQuery, criteriaBuilder) -> {
            if(teamId == null)
                return null;


            return criteriaBuilder.equal(root.get("teamId"), teamId);
        };
    }
}
