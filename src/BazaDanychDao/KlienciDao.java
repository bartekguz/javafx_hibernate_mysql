/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BazaDanychDao;

import BazaDanych.Klienci;
import java.util.List;
import komis.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Bartek
 */
public class KlienciDao {
    public void saveKlienci(Klienci klienci) {
       Transaction transaction = null;
       try (Session session = HibernateUtil.getSessionFactory().openSession()) {
           transaction = session.beginTransaction();
           session.save(klienci);
           transaction.commit();
       } catch (Exception e) {
           if (transaction != null) {
               transaction.rollback();
           }
           System.out.println("ERROR in KlienciDao [saveKlienci]: " + e);
       }
   }
    
    public List<Klienci> getKlienci() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Klienci", Klienci.class).list();
        }
    }            
}
