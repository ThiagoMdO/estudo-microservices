package com.curso.Nav.services;

import com.curso.Nav.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    public Person createPerson(Person person){
        return person;
    }

    public Person UpdatePerson(Person person){
        return person;
    }

    public void deletePerson(String id){

    }
    public Person findId(String id) {

        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Thiago");
        person.setLastName("Mendes");
        person.setAddress("Pintadas, BA");
        person.setGender("Male");
        return person;
    }

    public List<Person> findAll() {

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person Name: " + i);
        person.setLastName("Last Name" + i);
        person.setAddress("Some address in brazil" + i);
        person.setGender("Male" + i);
        return person;
    }
}
