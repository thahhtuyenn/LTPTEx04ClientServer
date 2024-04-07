package com.thahhtuyen.dao;

import com.thahhtuyen.entity.Course;

import java.util.List;

public interface CourseDao {
    public Course addCourse(Course course);
    public boolean updateCourse(Course course);
    public boolean deleteCourseById(int courseId);
    public Course getCourseById(int courseId);
    public List<Course> getAllCourse();
}
