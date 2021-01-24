/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BazaDanychDao;

import BazaDanych.Samochody;
import java.util.List;
import komis.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Bartek
 */
public class SamochodyDao {
    public void saveSamochody(Samochody samochody) {
       Transaction transaction = null;
       try (Session session = HibernateUtil.getSessionFactory().openSession()) {
           transaction = session.beginTransaction();
           session.save(samochody);
           transaction.commit();
       } catch (Exception e) {
           if (transaction != null) {
               transaction.rollback();
           }
           System.out.println("ERROR in SamochodyDao [saveSamochody]: " + e);
       }
   }
    
    public List<Samochody> getSamochody() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Samochody", Samochody.class).list();
        }
    }         
}
