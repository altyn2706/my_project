package org.example.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DbConnection {


    private final static EntityManagerFactory em = Persistence.createEntityManagerFactory("aisalbek");

    public static EntityManager getEntityManager(){
        return em.createEntityManager();
    }

}
