/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BazaDanychDao;

import BazaDanych.Transakcje;
import java.util.List;
import komis.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Bartek
 */
public class TransakcjeDao {
    public void saveTransakcje(Transakcje transakcje) {
       Transaction transaction = null;
       try (Session session = HibernateUtil.getSessionFactory().openSession()) {
           transaction = session.beginTransaction();
           session.save(transakcje);
           transaction.commit();
       } catch (Exception e) {
           if (transaction != null) {
               transaction.rollback();
           }
           System.out.println("ERROR in TransakcjeDao [saveTransakcje]: " + e);
       }
   }
    
    public List<Transakcje> getTransakcje() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Transakcje", Transakcje.class).list();
        }
    }        
}
