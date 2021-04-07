package ru.sibadi.demowebapp.repository;

import org.springframework.stereotype.Repository;
import ru.sibadi.demowebapp.domain.Person;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {

    private static int id = 1;

    private final List<Person> persons = new ArrayList<>();

    public PersonRepository() {
        addPerson("Надыкто М.О.", 10_000);
    }

    public List<Person> findAllPersons() {
        return persons;
    }

    public Person findPersonById(int id) {
        Person foundPerson = null;
        for (Person p : persons) {
            if (p.getId() == id) {
                foundPerson = p;
            }
        }
        return foundPerson;
    }

    public Person addPerson(String name, int salary) {
        Person person = new Person(id, name, salary);
        persons.add(person);
        id++;
        return person;
    }
}
