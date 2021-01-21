/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komis;

import BazaDanych.Adresy;
import BazaDanychDao.AdresyDao;
import java.util.List;

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
        
        AdresyDao adresyDao = new AdresyDao();
        Adresy adres = new Adresy("Krosno", "38-400", "Podkarpackie", "Podkarpacka", "2");
        adresyDao.saveAdresy(adres);
        
        List<Adresy> adresy = adresyDao.getAdresy();
        adresy.forEach(s -> System.out.println(s.getNazwa_miejscowosci()));
        
        HibernateUtil.getSessionFactory().openSession().close();
        launch(args);
        HibernateUtil.close();
    }
}
