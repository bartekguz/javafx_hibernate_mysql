/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BazaDanychDao;

import BazaDanych.Pracownicy;
import java.util.List;
import komis.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Bartek
 */
public class PracownicyDao {
    public void savePracownicy(Pracownicy pracownicy) {
       Transaction transaction = null;
       try (Session session = HibernateUtil.getSessionFactory().openSession()) {
           transaction = session.beginTransaction();
           session.save(pracownicy);
           transaction.commit();
       } catch (Exception e) {
           if (transaction != null) {
               transaction.rollback();
           }
           System.out.println("ERROR in PracownicyDao [savePracownicy]: " + e);
       }
   }
    
    public List<Pracownicy> getPracownicy() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Pracownicy", Pracownicy.class).list();
        }
    }            
}
