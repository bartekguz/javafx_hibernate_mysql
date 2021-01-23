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
    
    public Adresy addAdresy(String nazwaMiejscowosci, String kodPocztowy, String nazwaWojewodztwa, String nazwaUlicy, String numerDomu) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            
            Adresy adres = new Adresy();
            
            adres.setNazwa_miejscowosci(nazwaMiejscowosci);
            adres.setKod_pocztowy(kodPocztowy);
            adres.setNazwa_wojewodztwa(nazwaWojewodztwa);
            adres.setNazwa_ulicy(nazwaUlicy);
            adres.setNumer_domu(numerDomu);
            
            return adres;
        }
    }
}
