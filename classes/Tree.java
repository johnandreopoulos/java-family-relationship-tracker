package classes;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private String name;
    private String relation;
    private List<Person> persons = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public String getName() {
        return name;
    }

    public String getRelation() {
        return relation;
    }

    public List<Person> getPersons() {
        return persons;
    }
}
