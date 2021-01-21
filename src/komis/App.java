/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komis;

import BazaDanych.Adresy;
import BazaDanychDao.AdresyDao;
import java.util.List;

/**
 *
 * @author Bartek
 */
public class App {
    public static void main(String[] args) {
        AdresyDao adresyDao = new AdresyDao();
        Adresy adres = new Adresy("Krosno", "38-400", "Podkarpackie", "Podkarpacka", "2");
        adresyDao.saveAdresy(adres);
        
        List<Adresy> adresy = adresyDao.getAdresy();
        adresy.forEach(s -> System.out.println(s.getNazwa_miejscowosci()));
    }
}
