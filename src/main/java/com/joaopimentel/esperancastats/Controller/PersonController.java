package com.joaopimentel.esperancastats.Controller;

import com.joaopimentel.esperancastats.Entity.Person;
import com.joaopimentel.esperancastats.Service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Person>> getAllPersons() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        return ResponseEntity.ok(new Person());
    }

    @PostMapping
    public ResponseEntity<Person> createPerson() {
        return ResponseEntity.ok(new Person());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> editPerson(@PathVariable Long id) {
        return ResponseEntity.ok(new Person());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletePersonById(@PathVariable Long id) {
        return ResponseEntity.ok("");
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<String> deleteAllPersons() {
        return ResponseEntity.ok("");
    }
}
