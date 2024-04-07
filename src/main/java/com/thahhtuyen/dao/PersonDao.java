package com.thahhtuyen.dao;

import com.thahhtuyen.entity.Person;

import java.util.List;

public interface PersonDao {
    public Person addPerson(Person person);
    public boolean updatePerson(Person person);
    public Person getPersonById(int id);
    public boolean deletePerson(int id);
    public List<Person> getAllPerson();
}
