/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komis;

import BazaDanych.Adresy;
import BazaDanych.Klienci;
import BazaDanychDao.AdresyDao;
import BazaDanychDao.KlienciDao;
import java.util.Arrays;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Bartek
 */
public class App extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("StronaGlowna.fxml"));
             
        Scene scene = new Scene(root);
        
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        
//        Adresy adres1 = new Adresy();
//        Klienci klient1 = new Klienci();
//        
//        KlienciDao klienciDao = new KlienciDao();
//        
//        
//        
//        adres1 = new Adresy("City", "Code", "Idk", "Beutiful", "2");
//        System.out.println("ADRES1: " + adres1);
//        
//        klient1 = new Klienci("John", "Doe", 99012213213L, 9221039281923L, 732839120L);
//        klient1.setAdresy(adres1);
//        
//        klienciDao.saveKlienci(klient1);
//        
//        System.out.println("KLIENT1 getAdresy(): " + klient1.getAdresy());
        
        
//        List<Adresy> adresy = adresyDao.getAdresy();
//        adresy.forEach(s -> System.out.println(s.getNazwa_miejscowosci()));

        
        
        HibernateUtil.getSessionFactory().openSession().close();
        launch(args);
        HibernateUtil.close();
    }
}
