/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komis.tabele.pracownicy;

import java.net.URL;

import org.hibernate.Transaction;
import tworzenie_bazy_danych.Pracownicy;
import tworzenie_bazy_danych.Transakcje;

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
public class TabelaPracownicyController implements Initializable {

    @FXML
    private TextField pracownicyIdPracownikaField;
    @FXML
    private TextField pracownicyImieField;
    @FXML
    private TextField pracownicyNazwiskoField;
    @FXML
    private TextField pracownicyDataZatrudnieniaField;
    @FXML
    private TextField pracownicyZarobkiField;
    @FXML
    private TextField pracownicyNumerTelefonuField;
    @FXML
    private TableView<Pracownicy> pracownicyTv;
    @FXML
    private TableColumn<Pracownicy, Long> pracownicyColIdPracownika;
    @FXML
    private TableColumn<Pracownicy, String> pracownicyColDataZatrudnienia;
    @FXML
    private TableColumn<Pracownicy, String> pracownicyColImie;
    @FXML
    private TableColumn<Pracownicy, String> pracownicyColNazwisko;
    @FXML
    private TableColumn<Pracownicy, Long> pracownicyColNumerTelefonu;
    @FXML
    private TableColumn<Pracownicy, Long> pracownicyColZarobki;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showPracownicy();
    }    
    
    
    
    public ObservableList<Pracownicy> getPracownicyList() {
    	Configuration configuration =
            new Configuration().configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Pracownicy.class)
            .addAnnotatedClass(Transakcje.class);
   			
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
   		.applySettings(configuration.getProperties()).build();
                SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
                Session session = factory.openSession();
                Transaction transaction = session.beginTransaction();
                
                Query query = session.createQuery("FROM pracownicy");
                ObservableList<Pracownicy> listaPracownikow;
                listaPracownikow = FXCollections.observableArrayList(query.list());

                System.out.println("TO JEST LISTA Pracownikow: " + listaPracownikow);
                transaction.commit();
                session.close();
                factory.close();
                
                return listaPracownikow;
    }
    
    public void showPracownicy() {
        ObservableList<Pracownicy> list = getPracownicyList();
    	
    	pracownicyColIdPracownika.setCellValueFactory(new PropertyValueFactory<>("id_pracownika"));
        pracownicyColImie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        pracownicyColNazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
    	pracownicyColDataZatrudnienia.setCellValueFactory(new PropertyValueFactory<>("data_zatrudnienia"));
    	pracownicyColZarobki.setCellValueFactory(new PropertyValueFactory<>("zarobki"));
    	pracownicyColNumerTelefonu.setCellValueFactory(new PropertyValueFactory<>("numer_telefonu"));
        
    	pracownicyTv.setItems(list);
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
