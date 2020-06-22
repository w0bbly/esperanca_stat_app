package com.joaopimentel.esperancastats.Service;

import com.joaopimentel.esperancastats.DTO.PersonDTO;
import com.joaopimentel.esperancastats.Entity.Person;
import com.joaopimentel.esperancastats.Repository.PersonMapping;
import com.joaopimentel.esperancastats.Repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapping personMapping;

    public PersonService(PersonRepository personRepository, PersonMapping personMapping) {
        this.personRepository = personRepository;
        this.personMapping = personMapping;
    }

    public PersonDTO getPersonById(Long id) {
        Optional<Person> person = personRepository.findById(id);

        return person.map(personMapping::toDto).orElse(null);
    }

    public List<PersonDTO> getAllPersons() {
        return personMapping.toDto(personRepository.findAll());
    }

    public PersonDTO createPerson(PersonDTO personDTO) {
        personRepository.save(personMapping.toEntity(personDTO));
        return personDTO;
    }

    public PersonDTO editPerson(Long id, PersonDTO person) {
        Optional<Person> p = personRepository.findById(id);

        if(p.isPresent()) {
            p.get().setUsername(personMapping.toEntity(person).getUsername());
            p.get().setPassword(personMapping.toEntity(person).getPassword());
            personRepository.save(p.get());
            return personMapping.toDto(p.get());
        }

        return null;
    }

    public String deletePersonById(Long id) {
        Optional<Person> p = personRepository.findById(id);

        if(p.isPresent()) {
            personRepository.delete(p.get());
            return p.get().getUsername() + " deleted with success!";
        } else
            return null;
    }

    public String deleteAllPersons() {
        personRepository.deleteAll();
        return  "All persons deleted with success!";
    }
}
