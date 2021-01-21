/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BazaDanychDao;

import BazaDanych.Silniki;
import java.util.List;
import komis.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Bartek
 */
public class SilnikiDao {
    public void saveKlienci(Silniki silniki) {
       Transaction transaction = null;
       try (Session session = HibernateUtil.getSessionFactory().openSession()) {
           transaction = session.beginTransaction();
           session.save(silniki);
           transaction.commit();
       } catch (Exception e) {
           if (transaction != null) {
               transaction.rollback();
           }
           System.out.println("ERROR in SilnikiDao [saveSilniki]: " + e);
       }
   }
    
    public List<Silniki> getSilniki() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Silniki", Silniki.class).list();
        }
    }            
}
