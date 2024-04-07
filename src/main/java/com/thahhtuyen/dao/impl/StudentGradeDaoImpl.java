package com.thahhtuyen.dao.impl;

import com.thahhtuyen.dao.StudentGradeDao;
import com.thahhtuyen.entity.StudentGrade;
import com.thahhtuyen.utils.AppUtils;

import java.util.List;

public class StudentGradeDaoImpl extends AppUtils implements StudentGradeDao {
    @Override
    public StudentGrade addStudentGrade(StudentGrade stg) {
        try (var em = getEntityManager()){
            em.getTransaction().begin();
            em.persist(stg);
            em.getTransaction().commit();
            StudentGrade studentGrade = em.find(StudentGrade.class, stg.getEnrollmentID());
            return studentGrade;
        }
    }

    @Override
    public boolean updateStudentGrade(StudentGrade stg) {
        try (var em = getEntityManager()){
            StudentGrade studentGrade = em.find(StudentGrade.class, stg.getEnrollmentID());
            if (studentGrade != null){
                em.getTransaction().begin();
                em.merge(stg); // update student grade
                em.getTransaction().commit();
                return true;
            }
            return false;
        }
    }

    @Override
    public boolean deleteStudentGradeById(int enrollmentID) {
        try (var em = getEntityManager()){
            StudentGrade studentGrade = em.find(StudentGrade.class, enrollmentID);
            if (studentGrade != null){
                em.getTransaction().begin();
                em.remove(studentGrade);
                em.getTransaction().commit();
                return true;
            }
            return false;
        }
    }

    @Override
    public StudentGrade getStudentGradeById(int enrollmentID) {
        try (var em = getEntityManager()){
            return em.find(StudentGrade.class, enrollmentID);
        }
    }

    @Override
    public List<StudentGrade> getAllStudentGrade() {
        try (var em = getEntityManager()){
            return em.createQuery("SELECT stg FROM StudentGrade stg", StudentGrade.class).getResultList();
        }
    }
}
