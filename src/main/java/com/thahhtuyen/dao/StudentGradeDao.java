package com.thahhtuyen.dao;

import com.thahhtuyen.entity.StudentGrade;

import java.util.List;

public interface StudentGradeDao {
    public StudentGrade addStudentGrade(StudentGrade stg);
    public boolean updateStudentGrade(StudentGrade stg);
    public boolean deleteStudentGradeById(int enrollmentID);
    public StudentGrade getStudentGradeById(int enrollmentID);
    public List<StudentGrade> getAllStudentGrade();
}
