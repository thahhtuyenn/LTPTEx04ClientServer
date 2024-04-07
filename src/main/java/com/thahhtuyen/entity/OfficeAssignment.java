package com.thahhtuyen.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Setter
@Getter
@Table(name = "OfficeAssignment")
@NoArgsConstructor
public class OfficeAssignment {
    private String location;
    private Timestamp timeStamp;

    // The thi khoi doi
    @OneToOne
    @JoinColumn(name = "personID")
    @Id
    private Instructor instructor;

    public OfficeAssignment(String location, Timestamp timeStamp) {
        this.location = location;
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "OfficeAssignment{" +
                "location='" + location + '\'' +
                ", timeStamp=" + timeStamp  +
                '}';
    }
}
