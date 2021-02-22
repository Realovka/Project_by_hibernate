package by.realovka;



import by.realovka.table.DietarySupplement;
import by.realovka.table.Medicine;
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
//        session.save(cerebrolizat);
//        session.save(biogaya);

//        Product object = session.find(Product.class, 2L);
//        System.out.println(object);

//        List<Product> products = session.createQuery("from Product", Product.class).getResultList();
//        System.out.println(products);

        biogaya.setPackageDivision(true);
        session.saveOrUpdate(biogaya);

        trx.commit();
        session.close();
    }
}
