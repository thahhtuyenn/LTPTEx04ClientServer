package com.thahhtuyen.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Person")
@Entity
public class Instructor extends Person{
    private LocalDateTime hireDate;

    @ManyToMany(mappedBy = "instructors")
    private Set<Course> courses;

    public Instructor(String firstName, String lastName, LocalDateTime hireDate) {
        super(firstName, lastName);
        this.hireDate = hireDate;
    }


    @Override
    public String toString() {
        return "Instructor{" +
                "hireDate=" + hireDate +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
