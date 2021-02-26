package by.realovka;


import by.realovka.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.HashSet;
import java.util.Set;


public class Start {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction trx = session.beginTransaction();

        Team team = Team.builder()
                .name("Dinamo Minsk")
                .build();
        session.save(team);

//        @OneToOne
        Team teamDinamo = session.find(Team.class, 4L);
        HeadCoach craigWoodcroft = HeadCoach.builder()
                .firstName("Craig")
                .lastName("Woodcroft")
                .age(51)
                .workChiefYears(10)
                .team(teamDinamo)
                .build();

        session.save(craigWoodcroft);

        MemberTeam hc = session.find(MemberTeam.class, 2L);
        System.out.println(hc);

        HeadCoach woodcroft = session.find(HeadCoach.class, 7L);
        woodcroft.setWorkChiefYears(13);
        session.saveOrUpdate(woodcroft);

        //@OneToMany & @ManyToOne


        Team dinamoMinsk = session.find(Team.class, 5L);

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
        for(AssistantHeadCoach item : assistantHeadCoaches) {
            session.save(item);
        }
        dinamoMinsk.setAssistants(assistantHeadCoaches);
        session.saveOrUpdate(dinamoMinsk);

        Team teamFromDb = session.find(Team.class, 5L);
        System.out.println(teamFromDb);

        Team nationalTeam = Team.builder()
                .name("national team")
                .build();
        session.save(nationalTeam);
//
//        @ManyToMany
        Team dnm = session.find(Team.class, 5L);

        HockeyPlayer ilyaShinkevich = HockeyPlayer.builder()
                .firstName("Iliya")
                .lastName("Shinkivich")
                .age(31)
                .height(189)
                .weight(83)
                .amplua("D")
                .teams(Set.of(dnm))
                .build();

        dnm.setPlayers(Set.of(ilyaShinkevich));
        session.saveOrUpdate(dnm);
        session.save(ilyaShinkevich);

        HockeyPlayer hp = session.find(HockeyPlayer.class, 14L);
        Team t = session.find(Team.class, 6L);
        hp.getTeams().add(t);
        t.getPlayers().add(hp);
        session.saveOrUpdate(hp);
        session.saveOrUpdate(t);

        trx.commit();
        session.close();
    }
}
