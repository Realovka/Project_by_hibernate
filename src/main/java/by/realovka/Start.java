package by.realovka;


import by.realovka.single.DietarySupplement;
import by.realovka.single.Medicine;
import by.realovka.single.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Start {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction trx = session.beginTransaction();
        Medicine cerebrolizat = Medicine.builder()
                .coldStorage(true)
                .dosageForm("amp")
                .recipe(true)
                .build();
        DietarySupplement biogaya = DietarySupplement.builder()
                .coldStorage(false)
                .packageDivision(false)
                .belarusianProduct(false)
                .build();
//        session.save(cerebrolizat);
//        session.save(biogaya);
        Product object = session.find(Product.class, 3L);
        System.out.println(object);
        trx.commit();
        session.close();
    }
}
