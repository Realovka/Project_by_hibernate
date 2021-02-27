package by.realovka;


import by.realovka.entityManager.EntityManagerHelper;
import by.realovka.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.HashSet;
import java.util.Set;


public class Start {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        EntityManagerHelper helper = EntityManagerHelper.getInstance();

        EntityManager em = helper.getEntityManager();
        em.unwrap(Session.class).setJdbcBatchSize(3);
        EntityTransaction trx = em.getTransaction();
        trx.begin();

//        Team team = Team.builder()
//                .name("Dinamo Minsk")
//                .build();
//        em.persist(team);

//        @OneToOne
//        Team teamDinamo = em.find(Team.class, 4L);
//        HeadCoach craigWoodcroft = HeadCoach.builder()
//                .firstName("Craig")
//                .lastName("Woodcroft")
//                .age(51)
//                .workChiefYears(10)
//                .team(teamDinamo)
//                .build();
//
//        session.save(craigWoodcroft);
//
//        MemberTeam hc = em.find(MemberTeam.class, 1L);
//        System.out.println(hc);
////
//        HeadCoach woodcroft = em.find(HeadCoach.class, 1L);
//        woodcroft.setWorkChiefYears(13);
//        em.merge(woodcroft);
//
//        //@OneToMany & @ManyToOne
//
//
        Team dinamoMinsk = em.find(Team.class, 1L);

        AssistantHeadCoach mikhailGrabovski = AssistantHeadCoach.builder()
                .firstName("Mikhail")
                .lastName("Grabovski")
                .age(37)
                .workAssistantYears(2)
                .team(dinamoMinsk)
                .build();

        AssistantHeadCoach pavelPerepehin = AssistantHeadCoach.builder()
                .firstName("Pavel")
                .lastName("Perepehin")
                .age(42)
                .workAssistantYears(10)
                .team(dinamoMinsk)
                .build();


        Set<AssistantHeadCoach> assistantHeadCoaches = new HashSet<>();
        assistantHeadCoaches.add(mikhailGrabovski);
        assistantHeadCoaches.add(pavelPerepehin);
        for (AssistantHeadCoach item : assistantHeadCoaches) {
            em.persist(item);
        }
        dinamoMinsk.setAssistants(assistantHeadCoaches);
        em.merge(dinamoMinsk);
//
//        Team teamFromDb = session.find(Team.class, 5L);
//        System.out.println(teamFromDb);
//
//        Team nationalTeam = Team.builder()
//                .name("national team")
//                .build();
//        session.save(nationalTeam);
////
////        @ManyToMany
//        Team dnm = session.find(Team.class, 5L);
//
//        HockeyPlayer ilyaShinkevich = HockeyPlayer.builder()
//                .firstName("Iliya")
//                .lastName("Shinkivich")
//                .age(31)
//                .height(189)
//                .weight(83)
//                .amplua("D")
//                .teams(Set.of(dnm))
//                .build();
//
//        dnm.setPlayers(Set.of(ilyaShinkevich));
//        session.saveOrUpdate(dnm);
//        session.save(ilyaShinkevich);
//
//        HockeyPlayer hp = session.find(HockeyPlayer.class, 14L);
//        Team t = session.find(Team.class, 6L);
//        hp.getTeams().add(t);
//        t.getPlayers().add(hp);
//        session.saveOrUpdate(hp);
//        session.saveOrUpdate(t);

        trx.commit();
        session.close();
    }

}

