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
//        Medicine cerebrolizat = Medicine.builder()
//                .name("cerebrolizat")
//                .coldStorage(true)
//                .dosageForm("amp")
//                .recipe(true)
//                .build();
//        DietarySupplement biogaya = DietarySupplement.builder()
//                .name("biogaya")
//                .coldStorage(false)
//                .packageDivision(false)
//                .belarusianProduct(false)
//                .build();
        Medicine sedavit = Medicine.builder()
                .name("sedavit")
                .coldStorage(false)
                .dosageForm("tab")
                .recipe(false)
                .build();
        DietarySupplement normobakt = DietarySupplement.builder()
                .name("normobakt")
                .coldStorage(false)
                .packageDivision(true)
                .belarusianProduct(false)
                .build();
        DietarySupplement babycalm = DietarySupplement.builder()
                .name("babycalm")
                .coldStorage(true)
                .packageDivision(false)
                .belarusianProduct(false)
                .build();
//        session.save(sedavit);
//        session.save(normobakt);
//        session.save(babycalm);

//        Product object = session.find(Product.class, 2L);
//        System.out.println(object);

//        List<Product> products = session.createQuery("from Product", Product.class).getResultList();
//        System.out.println(products);

//        babycalm.setPackageDivision(true);
//        session.saveOrUpdate(babycalm);

        session.delete(babycalm);

        trx.commit();
        session.close();
    }
}
