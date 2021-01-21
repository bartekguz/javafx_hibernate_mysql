/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package komis.tabele.transakcje;

import java.net.URL;

import org.hibernate.Transaction;
import tworzenie_bazy_danych.Klienci;
import tworzenie_bazy_danych.Samochody;
import tworzenie_bazy_danych.Transakcje;
import tworzenie_bazy_danych.Pracownicy;

import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
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
public class TabelaTransakcjeController implements Initializable {

    @FXML
    private TextField transakcjeIdTransakcjiField;
    @FXML
    private TextField transakcjeIdKlientaField;
    @FXML
    private TextField transakcjeNrVinField;
    @FXML
    private TextField transakcjeIdPracownikaField;
    @FXML
    private TextField transakcjeDataTransakcjiField;
    @FXML
    private ComboBox transakcjeRodzajTransakcjiField;
    @FXML
    private TableView<Transakcje> transakcjeTv;
    @FXML
    private TableColumn<Transakcje, Long> transakcjeColIdTransakcji;
    @FXML
    private TableColumn<Transakcje, Long> transakcjeColIdKlienta;
    @FXML
    private TableColumn<Transakcje, String> transakcjeColNrVin;
    @FXML
    private TableColumn<Transakcje, Long> transakcjeColIdPracownika;
    @FXML
    private TableColumn<Transakcje, String> transakcjeColDataTransakcji;
    @FXML
    private TableColumn<Transakcje, String> transakcjeColRodzajTransakcji;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        transakcjeRodzajTransakcjiField.getItems().removeAll(transakcjeRodzajTransakcjiField.getItems());
        transakcjeRodzajTransakcjiField.getItems().addAll("Sprzedaż", "Kupno");
        transakcjeRodzajTransakcjiField.getSelectionModel().select("Sprzedaż");
        showTransakcje();
    }    
    
    
    
    public ObservableList<Transakcje> getTransakcjeList() {
    	Configuration configuration =
            new Configuration().configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Klienci.class)
            .addAnnotatedClass(Samochody.class)
            .addAnnotatedClass(Pracownicy.class)
            .addAnnotatedClass(Transakcje.class);
   			
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
   		.applySettings(configuration.getProperties()).build();
                SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
                Session session = factory.openSession();
                Transaction transaction = session.beginTransaction();
                
                Query query = session.createQuery("FROM transakcje");
                ObservableList<Transakcje> listaTransakcji;
                listaTransakcji = FXCollections.observableArrayList(query.list());

                System.out.println("TO JEST LISTA Transakcji: " + listaTransakcji);
                transaction.commit();
                session.close();
                factory.close();
                
                return listaTransakcji;
    }
    
    public void showTransakcje() {
        ObservableList<Transakcje> list = getTransakcjeList();
    	
    	transakcjeColIdTransakcji.setCellValueFactory(new PropertyValueFactory<>("id_transakcji"));
    	transakcjeColDataTransakcji.setCellValueFactory(new PropertyValueFactory<>("data_transakcji"));
    	transakcjeColRodzajTransakcji.setCellValueFactory(new PropertyValueFactory<>("rodzaj_transakcji"));
    	transakcjeColIdKlienta.setCellValueFactory(new PropertyValueFactory<>("id_klienta"));
    	transakcjeColIdPracownika.setCellValueFactory(new PropertyValueFactory<>("id_pracownika"));
        transakcjeColNrVin.setCellValueFactory(new PropertyValueFactory<>("nr_vin"));
    	
    	transakcjeTv.setItems(list);
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
