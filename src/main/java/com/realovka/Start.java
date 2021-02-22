package com.realovka;


import com.realovka.table.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CompoundSelection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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


//        //select Criteria API
//        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//        CriteriaQuery<Product> queryCriteriaSelect = criteriaBuilder.createQuery(Product.class);
//        Root<Product> productRoot = queryCriteriaSelect.from(Product.class);
//        queryCriteriaSelect.select(productRoot);
//        em.createQuery(queryCriteriaSelect).getResultList().forEach(Start::printCollection);

//        //select JPQL by field
//        TypedQuery<String> queryJpqlSelectField = em.createQuery("select p.name from Product p", String.class);
//        queryJpqlSelectField.getResultList().forEach(Start::printCollection);

//        //select Criteria API by field variant 1, get String
//        CriteriaBuilder criteriaBuilderField = em.getCriteriaBuilder();
//        CriteriaQuery<Product> queryCriteriaSelectField = criteriaBuilderField.createQuery(Product.class);
//        Root<Product> productRoot = queryCriteriaSelectField.from(Product.class);
//        CompoundSelection<Product> name = criteriaBuilderField.construct(Product.class, productRoot.get("name"));
//        queryCriteriaSelectField.select(name);
//        em.createQuery(queryCriteriaSelectField).getResultList().forEach(n -> printCollection(n.getName()));

//        //select Criteria API by field variant 1, get Boolean
//        CriteriaBuilder criteriaBuilderField = em.getCriteriaBuilder();
//        CriteriaQuery<Product> queryCriteriaSelectField = criteriaBuilderField.createQuery(Product.class);
//        Root<Product> productRoot = queryCriteriaSelectField.from(Product.class);
//        CompoundSelection<Product> coldStorage = criteriaBuilderField.construct(Product.class, productRoot.get("coldStorage"));
//        queryCriteriaSelectField.select(coldStorage);
//        em.createQuery(queryCriteriaSelectField).getResultList().forEach(n -> printCollection(n.getColdStorage()));


        //select Criteria API by field variant 2, get String
        CriteriaBuilder criteriaBuilderField = em.getCriteriaBuilder();
        CriteriaQuery<String> queryCriteriaSelectField = criteriaBuilderField.createQuery(String.class);
        Root<Product> productRoot = queryCriteriaSelectField.from(Product.class);
        queryCriteriaSelectField.select(productRoot.get("name"));
        em.createQuery(queryCriteriaSelectField).getResultList().forEach(Start::printCollection);


        trx.commit();
        session.close();

    }

    private static void printCollection(Object object) {
        System.out.println(object);
    }
}
