/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komis.tabele.klienci;

import java.net.URL;

import org.hibernate.Transaction;
import tworzenie_bazy_danych.Klienci;
import tworzenie_bazy_danych.Transakcje;
import tworzenie_bazy_danych.Adresy;

import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

/**
 * FXML Controller class
 *
 * @author Bartek
 */
public class TabelaKlienciController implements Initializable {

    @FXML
    private TextField klienciIdKlientaField;
    @FXML
    private TextField klienciImieField;
    @FXML
    private TextField klienciNazwiskoField;
    @FXML
    private TextField klienciPeselField;
    @FXML
    private TextField klienciNipField;
    @FXML
    private TextField klienciNrTelefonuField;
    @FXML
    private TextField klienciIdAdresuField;
    @FXML
    private TableView<Klienci> klienciTv;
    @FXML
    private TableColumn<Klienci, Long> klienciColIdKlienta;
    @FXML
    private TableColumn<Klienci, String> klienciColImie;
    @FXML
    private TableColumn<Klienci, String> klienciColNazwisko;
    @FXML
    private TableColumn<Klienci, Long> klienciColPesel;
    @FXML
    private TableColumn<Klienci, Long> klienciColNip;
    @FXML
    private TableColumn<Klienci, Long> klienciColNrTelefonu;
    @FXML
    private TableColumn<Klienci, Long> klienciColIdAdresu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showKlienci();
    }    
    
    public ObservableList<Klienci> getKlienciList() {
  
        Configuration configuration =
            new Configuration().configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Klienci.class)
            .addAnnotatedClass(Adresy.class)
            .addAnnotatedClass(Transakcje.class);
   			
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
   		.applySettings(configuration.getProperties()).build();
                SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
                Session session = factory.openSession();
                Transaction transaction = session.beginTransaction();
                
                Query query = session.createQuery("FROM klienci");
                ObservableList<Klienci> listaKlientow;
                listaKlientow = FXCollections.observableArrayList(query.list());

                System.out.println("TO JEST LISTA KLIENTOW: " + listaKlientow);
                transaction.commit();
                session.close();
                factory.close();
                
                return listaKlientow;
    }
    
    public void showKlienci() {
        ObservableList<Klienci> list = getKlienciList();
    	
    	klienciColIdKlienta.setCellValueFactory(new PropertyValueFactory<>("id_klienta"));
    	klienciColImie.setCellValueFactory(new PropertyValueFactory<>("imie"));
    	klienciColNazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
    	klienciColNip.setCellValueFactory(new PropertyValueFactory<>("nip"));
    	klienciColNrTelefonu.setCellValueFactory(new PropertyValueFactory<>("numer_telefonu"));
        klienciColPesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        klienciColIdAdresu.setCellValueFactory(new PropertyValueFactory<>("id_adresu"));
    	
    	klienciTv.setItems(list);
    }
    
    @FXML
    private void insertButton() {
    	
    }
    
    
    @FXML 
    private void updateButton() {
        
    }
    
    @FXML
    private void deleteButton() {
    	
    }

}
