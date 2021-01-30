/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komis;


import BazaDanych.Adresy;
import BazaDanych.Klienci;
import BazaDanych.Pracownicy;
import BazaDanych.Samochody;
import BazaDanych.Silniki;
import BazaDanych.Transakcje;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Bartek
 */
public class HibernateUtil {
    
    private static SessionFactory sessionFactory;
    
    public static final SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost/komis");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                
                settings.put(Environment.SHOW_SQL, "false");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "update");
                
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Adresy.class);
                configuration.addAnnotatedClass(Klienci.class);
                configuration.addAnnotatedClass(Pracownicy.class);
                configuration.addAnnotatedClass(Samochody.class);
                configuration.addAnnotatedClass(Silniki.class);
                configuration.addAnnotatedClass(Transakcje.class);
                
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                System.out.println("ERROR in HibernateUtil: " + e.getMessage());
            }
        }
        return sessionFactory;
    }
    
    public static void close() {
        if (sessionFactory != null) sessionFactory.close();
    }   
    
}
