package com.thahhtuyen.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "Department")
public class Department {
    @Id
    @Column(name = "departmentID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int administrator;
    private double budget;
    private LocalDateTime startDate;

    public Department(String name, int administrator, double budget, LocalDateTime startDate) {
        this.name = name;
        this.administrator = administrator;
        this.budget = budget;
        this.startDate = startDate;
    }
}
