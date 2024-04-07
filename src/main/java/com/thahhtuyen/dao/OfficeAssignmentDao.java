package com.thahhtuyen.dao;

import com.thahhtuyen.entity.OfficeAssignment;

import java.util.List;

public interface OfficeAssignmentDao {
    public OfficeAssignment addOfficeAssignment(OfficeAssignment of);
    public boolean updateOfficeAssignment(OfficeAssignment of);
    public OfficeAssignment getOfficeAssignmentById(int instructorId);
    public boolean deleteOfficeAssignmentById(int instructorId);
    public List<OfficeAssignment> getAllOfficeAssignment();
}
