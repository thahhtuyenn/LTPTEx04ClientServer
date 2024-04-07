package com.thahhtuyen.dao.impl;

import com.thahhtuyen.dao.CourseDao;
import com.thahhtuyen.entity.Course;
import com.thahhtuyen.utils.AppUtils;

import java.util.List;

public class CourseDaoImpl extends AppUtils implements CourseDao {
    @Override
    public Course addCourse(Course course) {
        try (var em = getEntityManager()){
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
            course = em.find(Course.class, course.getId());
            return course;
        }
    }

    @Override
    public boolean updateCourse(Course course) {
        try (var em = getEntityManager()){
            Course c = em.find(Course.class, course.getId());
            if (c != null){
                em.getTransaction().begin();
                em.merge(course); // merge() is used to update an entity (course) in the database
                em.getTransaction().commit();
                return true;
            }
            return false;
        }
    }

    @Override
    public boolean deleteCourseById(int courseId) {
        try (var em = getEntityManager()){
            Course c = em.find(Course.class, courseId);
            if(c != null){
                em.getTransaction().begin();
                em.remove(c);
                em.getTransaction().commit();
                return true;
            }
            return false;
        }
    }

    @Override
    public Course getCourseById(int courseId) {
        try (var em = getEntityManager()){
            return em.find(Course.class, courseId);
        }
    }

    @Override
    public List<Course> getAllCourse() {
        try (var em = getEntityManager()){
            return em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
        }
    }
}
