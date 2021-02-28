package by.realovka;


import by.realovka.join.DietarySupplement;
import by.realovka.join.Medicine;
import by.realovka.join.Product;
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

        Product object = session.find(Product.class, biogaya.getId());
        System.out.println(object);

        List<Product> products = session.createQuery("from Product", Product.class).getResultList();
        System.out.println(products);

        Product product = session.find(Product.class, biogaya.getId());
        product.setColdStorage(true);
        session.saveOrUpdate(product);

        Product productBiogaya = session.find(Product.class, biogaya.getId());
        session.delete(productBiogaya);

        Medicine medicine = session.find(Medicine.class, cerebrolizat.getId());
        medicine.setRecipe(false);
        session.saveOrUpdate(medicine);

        trx.commit();
        session.close();
    }
}
