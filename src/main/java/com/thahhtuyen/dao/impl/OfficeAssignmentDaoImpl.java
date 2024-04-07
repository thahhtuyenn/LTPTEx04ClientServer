package com.thahhtuyen.dao.impl;

import com.thahhtuyen.dao.OfficeAssignmentDao;
import com.thahhtuyen.entity.OfficeAssignment;
import com.thahhtuyen.utils.AppUtils;

import java.util.List;

public class OfficeAssignmentDaoImpl extends AppUtils implements OfficeAssignmentDao {
    @Override
    public OfficeAssignment addOfficeAssignment(OfficeAssignment of) {
        try (var em = getEntityManager()){
            em.getTransaction().begin();
            em.persist(of);
            em.getTransaction().commit();
            of = em.find(OfficeAssignment.class, of.getInstructor().getId());
            return of;
        }
    }

    @Override
    public boolean updateOfficeAssignment(OfficeAssignment of) {
        try(var em = getEntityManager()) {
            OfficeAssignment off = em.find(OfficeAssignment.class, of.getInstructor().getId());
            if (off != null) {
                em.getTransaction().begin();
                em.merge(of); // merge() method is used to update the object in the database
                em.getTransaction().commit();
                return true;
            }
            return false;
        }
    }

    @Override
    public OfficeAssignment getOfficeAssignmentById(int instructorId) {
        try (var em = getEntityManager()){
            return em.find(OfficeAssignment.class, instructorId);
        }
    }

    @Override
    public boolean deleteOfficeAssignmentById(int instructorId) {
        try (var em = getEntityManager()){
            OfficeAssignment of = em.find(OfficeAssignment.class, instructorId);
            if (of != null){
                em.getTransaction().begin();
                em.remove(of);
                em.getTransaction().commit();
                return true;
            }
            return false;
        }
    }

    @Override
    public List<OfficeAssignment> getAllOfficeAssignment() {
        try(var em = getEntityManager()){
            return em.createQuery("SELECT office FROM OfficeAssignment office", OfficeAssignment.class).getResultList();
        }
    }
}
