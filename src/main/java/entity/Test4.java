package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;

public class Test4 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory(); Session session
                = sessionFactory.openSession()) {
            session.beginTransaction();
            Candidate candidate = Candidate.of("Alex", "2 ears", 34000);
            Candidate candidate2 = Candidate.of("Ivan", "1 ears", 30000);
            Candidate candidate3 = Candidate.of("Elena", "2 ears", 38000);
            session.save(candidate);
            session.save(candidate2);
            session.save(candidate3);
            Query query = session.createQuery("from Candidate");
            System.out.println(query.getResultList());
            query = session.createQuery("from Candidate c where c.name = :name");
            query.setParameter("name", "Alex");
            System.out.println(query.getSingleResult());
            session.createQuery("update Candidate c set  c.experience = :exp, c.salary = :sal where c.id = :id")
            .setParameter("exp", "3 ears")
            .setParameter("sal", 40000)
            .setParameter("id", 1)
                    .executeUpdate();
             session.createQuery("delete from Candidate where id = :id")
            .setParameter("id", 2)
                     .executeUpdate();
            session.getTransaction().commit();
        }

    }
}
