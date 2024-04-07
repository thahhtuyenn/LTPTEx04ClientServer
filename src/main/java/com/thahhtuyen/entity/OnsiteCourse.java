package com.thahhtuyen.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "OnsiteCourse")
@NoArgsConstructor
@Getter
@Setter
public class OnsiteCourse extends Course{
    private String days;
    private String location;
    private LocalDateTime time;

    public OnsiteCourse(int credits, String title, String days, String location, LocalDateTime time) {
        super(credits, title);
        this.days = days;
        this.location = location;
        this.time = time;
    }

    @Override
    public String toString() {
        return "OnsiteCourse{" +
                "days='" + days + '\'' +
                ", location='" + location + '\'' +
                ", time=" + time +
                ", credits=" + credits +
                ", title='" + title + '\'' +
                '}';
    }
}
