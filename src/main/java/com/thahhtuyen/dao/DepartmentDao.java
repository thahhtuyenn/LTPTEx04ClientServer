package com.thahhtuyen.dao;

import com.thahhtuyen.entity.Department;

import java.awt.*;
import java.util.List;

public interface DepartmentDao {
    public Department addDepartment(Department department);
    public boolean updateDepartment(Department department);
    public boolean deleteDepartment(int departmentId);
    public Department getDepartment(int departmentId);
    public List<Department> getAllDepartments();
}
