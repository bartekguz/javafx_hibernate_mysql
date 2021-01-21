/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komis.tabele.silniki;

import java.net.URL;

import org.hibernate.Transaction;
import tworzenie_bazy_danych.Silniki;
import tworzenie_bazy_danych.Samochody;

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
public class TabelaSilnikiController implements Initializable {

    @FXML
    private TextField silnikIdSilnikaField;
    @FXML
    private TextField silnikPojemnoscSilnikaField;
    @FXML
    private TextField silnikRodzajPaliwaField;
    @FXML
    private TableView<Silniki> silnikTv;
    @FXML
    private TableColumn<Silniki, Long> silnikColIdSilnika;
    @FXML
    private TableColumn<Silniki, String> silnikColPojemnoscSilnika;
    @FXML
    private TableColumn<Silniki, String> silnikColRodzajPaliwa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showSilniki();
    }    

    
    public ObservableList<Silniki> getSilnikiList() {
    	Configuration configuration =
            new Configuration().configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Silniki.class)
            .addAnnotatedClass(Samochody.class);
   			
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
   		.applySettings(configuration.getProperties()).build();
                SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
                Session session = factory.openSession();
                Transaction transaction = session.beginTransaction();
                
                Query query = session.createQuery("FROM silniki");
                ObservableList<Silniki> listaSilnikow;
                listaSilnikow = FXCollections.observableArrayList(query.list());

                System.out.println("TO JEST LISTA Silnikow: " + listaSilnikow);
                transaction.commit();
                session.close();
                factory.close();
                
                return listaSilnikow;
    }
    
    public void showSilniki() {
        ObservableList<Silniki> list = getSilnikiList();
    	
    	silnikColIdSilnika.setCellValueFactory(new PropertyValueFactory<>("id_silnika"));
    	silnikColPojemnoscSilnika.setCellValueFactory(new PropertyValueFactory<>("pojemnosc_silnika"));
    	silnikColRodzajPaliwa.setCellValueFactory(new PropertyValueFactory<>("rodzaj_paliwa"));

    	
    	silnikTv.setItems(list);
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
