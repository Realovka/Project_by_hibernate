package com.realovka;

import lombok.SneakyThrows;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class EntityManagerHelper {

    private final SessionFactory factory;

    @SneakyThrows
    private EntityManagerHelper() {
        Configuration cfg = new Configuration().configure();
        this.factory = cfg.buildSessionFactory();
    }

    private static class EntityManagerHelperHolder {
        private static final EntityManagerHelper HOLDER_INSTANCE = new EntityManagerHelper();
    }

    public static EntityManagerHelper getInstance() {
        return EntityManagerHelper.EntityManagerHelperHolder.HOLDER_INSTANCE;
    }

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}