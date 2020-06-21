package com.joaopimentel.esperancastats.Repository;

import com.joaopimentel.esperancastats.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
