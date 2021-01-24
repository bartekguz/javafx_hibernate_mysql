/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BazaDanychDao;

import BazaDanych.Adresy;
import java.util.List;
import komis.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author Bartek
 */
public class AdresyDao {
    
    public void saveAdresy(Adresy adresy) {
       Transaction transaction = null;
       try (Session session = HibernateUtil.getSessionFactory().openSession()) {
           transaction = session.beginTransaction();
           session.save(adresy);
           transaction.commit();
       } catch (Exception e) {
           if (transaction != null) {
               transaction.rollback();
           }
           System.out.println("ERROR in AdresyDao [saveAdresy]: " + e);
       }
   }
    
    public List<Adresy> getAdresy() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Adresy", Adresy.class).list();
        }
    }
    
    public List<Adresy> getAdresyById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {        
            return session.createQuery("FROM Adresy E WHERE E.id_adresu = " + id).list();
        } catch (Exception e) {
            System.out.println("ERROR [getAdresyById]: " + e);
            return null;
        }
    }

}
