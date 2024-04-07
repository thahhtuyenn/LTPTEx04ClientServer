package com.thahhtuyen.dao.impl;

import com.thahhtuyen.dao.DepartmentDao;
import com.thahhtuyen.entity.Department;
import com.thahhtuyen.utils.AppUtils;

import java.util.List;

public class DepartmentDaoImpl extends AppUtils implements DepartmentDao {

    @Override
    public Department addDepartment(Department department) {
        try (var em = getEntityManager()){
            em.getTransaction().begin();
            em.persist(department);
            em.getTransaction().commit();
            department = em.find(Department.class, department.getId());
            return department;
        }
    }

    @Override
    public boolean updateDepartment(Department department) {
        return false;
    }

    @Override
    public boolean deleteDepartment(String departmentId) {
        return false;
    }

    @Override
    public Department getDepartment() {
        return null;
    }

    @Override
    public List<Department> getAllDepartments() {
        return null;
    }
}
