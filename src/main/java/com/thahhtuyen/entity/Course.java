package com.thahhtuyen.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "Course")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Getter
@Setter
public abstract class Course {
    @Id
    @Column(name = "courseID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected int credits;
    protected String title;

    @ManyToMany
    @JoinTable(name = "CourseInstructor",
    joinColumns = @JoinColumn(name = "courseID"),
    inverseJoinColumns = @JoinColumn(name = "personID"))
    protected Set<Instructor> instructors;

    @ManyToOne
    @JoinColumn(name = "departmentID")
    protected Department department;

    public Course(int credits, String title) {
        this.credits = credits;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Course{" +
                "credits=" + credits +
                ", title='" + title + '\'' +
                '}';
    }
}
