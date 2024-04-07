package com.thahhtuyen.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class AppUtils {
    public static EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("StudentDB MSSQL")
                .createEntityManager();
    }
}
