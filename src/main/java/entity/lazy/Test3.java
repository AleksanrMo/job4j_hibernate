package entity.lazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test3 {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        Company2 company1;
        Company2 company2;
        Company2 company3;
        Company2 company4;
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            company1 = session.get(Company2.class, 1);
            company1.getModels().get(0);
            company2 = session.get(Company2.class, 2);
            company2.getModels().get(0);
            company3 = session.get(Company2.class, 3);
            company3.getModels().get(0);
            company4 = session.get(Company2.class, 4);
            company4.getModels().get(0);
            session.getTransaction().commit();
        }

        System.out.println(company1.getModels());
        System.out.println(company2.getModels());
        System.out.println(company3.getModels());
        System.out.println(company4.getModels());

    }
}
