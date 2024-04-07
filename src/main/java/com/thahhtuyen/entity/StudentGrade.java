package com.thahhtuyen.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "StudentGrade")
@Getter
@Setter
@NoArgsConstructor
public class StudentGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enrollmentID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseID")
    private Course course;

    private double grade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personID")
    private Student student;

    public StudentGrade(Course course, double grade, Student student) {
        this.course = course;
        this.grade = grade;
        this.student = student;
    }

    @Override
    public String toString() {
        return "StudentGrade{" +
                "enrollmentID=" + enrollmentID +
                ", course=" + course +
                ", grade=" + grade +
                ", student=" + student +
                '}';
    }
}
