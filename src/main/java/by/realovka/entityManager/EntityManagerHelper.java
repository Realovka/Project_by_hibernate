package by.realovka.entityManager;

import lombok.SneakyThrows;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.util.Properties;

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

    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.jdbc.batch_size", "2");
        return properties;
    }
}