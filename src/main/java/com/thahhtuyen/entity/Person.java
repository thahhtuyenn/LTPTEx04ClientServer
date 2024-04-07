package com.thahhtuyen.entity;

import jakarta.persistence.*;
import lombok.*;
import org.checkerframework.checker.units.qual.A;

@Setter
@Getter
@NoArgsConstructor
@Table(name = "Person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public abstract class Person {
    @Id
    @Column(name = "personID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column(nullable = false)
    protected String firstName;
    @Column(nullable = false)
    protected String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
