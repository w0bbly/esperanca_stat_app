package com.joaopimentel.esperancastats.Repository;

import com.joaopimentel.esperancastats.Config.EntityMapper;
import com.joaopimentel.esperancastats.DTO.PersonDTO;
import com.joaopimentel.esperancastats.Entity.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapping extends EntityMapper<PersonDTO, Person> {
}
