package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();
        try (
                SessionFactory sessionFactory = configuration.buildSessionFactory();
                Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Book book = session.get(Book.class, 1);
            session.remove(book);
            session.getTransaction().commit();

        }
    }

}
