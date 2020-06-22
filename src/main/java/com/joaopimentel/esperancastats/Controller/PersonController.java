package com.joaopimentel.esperancastats.Controller;

import com.joaopimentel.esperancastats.DTO.PersonDTO;
import com.joaopimentel.esperancastats.Service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        return ResponseEntity.ok(personService.getAllPersons());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Long id) {
        PersonDTO personDTO = personService.getPersonById(id);

        if(personDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(personDTO);
    }

    @PostMapping
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO person) {
        return ResponseEntity.ok(personService.createPerson(person));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> editPerson(@PathVariable Long id, @RequestBody PersonDTO person) {
        PersonDTO personDTO = personService.editPerson(id, person);

        if(personDTO == null)
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.ok(personDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletePersonById(@PathVariable Long id) {
        String outcome = personService.deletePersonById(id);

        if(outcome == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok(outcome);
        }
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllPersons() {
        return ResponseEntity.ok(personService.deleteAllPersons());
    }
}
