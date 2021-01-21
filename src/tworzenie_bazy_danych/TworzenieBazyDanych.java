package tworzenie_bazy_danych;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class TworzenieBazyDanych {

    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Adresy.class);
        configuration.addAnnotatedClass(Klienci.class);
        configuration.addAnnotatedClass(Pracownicy.class);
        configuration.addAnnotatedClass(Samochody.class);
        configuration.addAnnotatedClass(Silniki.class);
        configuration.addAnnotatedClass(Transakcje.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        transaction.commit();
        System.out.println("Transaction Completed !");
        session.close(); factory.close();
    }
}
