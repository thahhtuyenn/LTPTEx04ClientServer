package com.thahhtuyen.dao.impl;

import com.thahhtuyen.dao.PersonDao;
import com.thahhtuyen.entity.Person;
import com.thahhtuyen.utils.AppUtils;

import java.util.List;

public class PersonDaoImpl extends AppUtils implements PersonDao{
    @Override
    public Person addPerson(Person person) {
        try (var em = getEntityManager()){
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
            person = em.find(Person.class, person.getId());
            return person;
        }
    }

    @Override
    public boolean updatePerson(Person person) {
        try (var em = getEntityManager()){
            Person p = em.find(Person.class, person.getId());
            if (p != null){
                em.getTransaction().begin();
                em.merge(person);
                em.getTransaction().commit();
                return true;
            }
            return false;
        }
    }

    @Override
    public Person getPersonById(int id) {
        try (var em = getEntityManager()){
            return em.find(Person.class, id);
        }
    }

    @Override
    public boolean deletePerson(int id) {
        try (var em = getEntityManager()){
            Person p = em.find(Person.class, id);
            if (p != null){
                em.getTransaction().begin();
                em.remove(p);
                em.getTransaction().commit();
                return true;
            }
            return false;
        }
    }

    @Override
    public List<Person> getAllPerson() {
        try (var em = getEntityManager()){
            return em.createQuery("select p from Person p", Person.class).getResultList();
        }
    }
}
