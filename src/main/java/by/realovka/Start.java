package by.realovka;



import by.realovka.table.DietarySupplement;
import by.realovka.table.Medicine;
import by.realovka.table.Product;
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

        Product object = session.find(Product.class, cerebrolizat.getId());
        System.out.println(object);

        List<Product> products = session.createQuery("from Product", Product.class).getResultList();
        System.out.println(products);

        Product biogayaFromDb = session.find( Product.class, biogaya.getId());
        biogayaFromDb.setColdStorage(false);
        session.saveOrUpdate(biogayaFromDb);

        trx.commit();
        session.close();
    }
}
