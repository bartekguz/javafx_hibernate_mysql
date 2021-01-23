/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BazaDanychDao;

import BazaDanych.Adresy;
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
           session.persist(klienci);
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
            List<Klienci> selectAll = session.createQuery("from Klienci", Klienci.class).list();
            System.out.println(selectAll);
            return selectAll;
        }
    }     
        
    public Klienci addKlienci(String imie, String nazwisko, Long pesel, Long nip, Long numerTelefonu) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            
            Klienci klient = new Klienci();
            
            klient.setImie(imie);
            klient.setNazwisko(nazwisko);
            klient.setPesel(pesel);
            klient.setNip(nip);
            klient.setNumer_telefonu(numerTelefonu);
            
            return klient;
        }
    }
}
