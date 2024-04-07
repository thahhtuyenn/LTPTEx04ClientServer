package com.thahhtuyen.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "OnlineCourse")
@Getter
@Setter
@NoArgsConstructor
public class OnlineCourse extends Course{
    private String url;

    public OnlineCourse(int credits, String title, String url) {
        super(credits, title);
        this.url = url;
    }

    @Override
    public String toString() {
        return "OnlineCourse{" +
                "url='" + url + '\'' +
                ", credits=" + credits +
                ", title='" + title + '\'' +
                '}';
    }
}
