package by.realovka;


import by.realovka.single.DietarySupplement;
import by.realovka.single.Medicine;
import by.realovka.single.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Start {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction trx = session.beginTransaction();

        Medicine cerebrolizat = Medicine.builder()
                .name("cerebrolizat")
                .coldStorage(true)
                .dosageForm("amp")
                .recipe(true)
                .build();
        DietarySupplement biogaya = DietarySupplement.builder()
                .name("biogaya")
                .coldStorage(false)
                .packageDivision(false)
                .belarusianProduct(false)
                .build();

        session.save(cerebrolizat);
        session.save(biogaya);

        List<Product> products = session.createQuery("from Product", Product.class).getResultList();
        System.out.println(products);

        Product object = session.find(Product.class, biogaya.getId());
        System.out.println(object);

        Product productFromDb = session.find(Product.class, cerebrolizat.getId());
        productFromDb.setColdStorage(false);
        session.saveOrUpdate(productFromDb);

        Product product = session.find(Product.class, biogaya.getId());
        session.delete(product);

        trx.commit();
        session.close();
    }
}
