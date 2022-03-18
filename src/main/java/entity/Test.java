package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession()) {
            session.beginTransaction();
           Model model1 = Model.of("ModelOne");
           Model model2 = Model.of("ModelTwo");
           Model model3 = Model.of("ModelTree");
           Model model4 = Model.of("ModelFore");
           Model model5 = Model.of("ModelFive");
           Company company = Company.of("BestCar");
           company.addModel(model1);
           company.addModel(model2);
           company.addModel(model3);
           company.addModel(model4);
           company.addModel(model5);
           session.persist(company);
           session.getTransaction().commit();

        }

    }
}




