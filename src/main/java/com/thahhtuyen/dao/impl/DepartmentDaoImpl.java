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
        try (var em = getEntityManager()){
            Department d = em.find(Department.class, department.getId());
            if(d != null){
                em.getTransaction().begin();
                em.merge(department); // update
                em.getTransaction().commit();
                return true;
            }
            return false;
        }
    }

    @Override
    public boolean deleteDepartment(int departmentId) {
        try (var em = getEntityManager()){
            Department d = em.find(Department.class, departmentId);
            if(d != null){
                em.getTransaction().begin();
                em.remove(d);
                em.getTransaction().commit();
                return true;
            }
            return false;
        }
    }

    @Override
    public Department getDepartment(int departmentId) {
        try (var em = getEntityManager()){
            return em.find(Department.class, departmentId);
        }
    }

    @Override
    public List<Department> getAllDepartments() {
        try (var em = getEntityManager()){
            return em.createQuery("SELECT d FROM Department d", Department.class).getResultList();
        }
    }
}
