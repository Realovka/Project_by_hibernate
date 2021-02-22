package by.realovka;


import by.realovka.table.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        EntityManagerHelper helper = EntityManagerHelper.getInstance();

        EntityManager em = helper.getEntityManager();
        EntityTransaction trx = em.getTransaction();
        trx.begin();
//
//        //from JPQL
//        TypedQuery<Product> queryJpqlFrom = em.createQuery("from Product", Product.class);
//        queryJpqlFrom.getResultList().forEach(Start::printCollection);
//
//        //from Criteria API
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Product> queryCriteriaFrom = cb.createQuery(Product.class);
//        queryCriteriaFrom.from(Product.class);
//        em.createQuery(queryCriteriaFrom).getResultList().forEach(Start::printCollection);
//
//        //select JPQL
//        TypedQuery<Product> queryJpqlSelect = em.createQuery("select p from Product p", Product.class);
//        queryJpqlSelect.getResultList().forEach(Start::printCollection);

        //select Criteria API
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Product> queryCriteriaSelect = criteriaBuilder.createQuery(Product.class);
        Root<Product> productRoot = queryCriteriaSelect.from(Product.class);
        queryCriteriaSelect.select(productRoot);
        em.createQuery(queryCriteriaSelect).getResultList().forEach(Start::printCollection);




        trx.commit();
        session.close();

    }

    private static void printCollection(Object object) {
        System.out.println(object);
    }
}
