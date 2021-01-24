/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komis.tabele.samochody;

import java.net.URL;

import BazaDanych.Samochody;
import BazaDanych.Silniki;
import BazaDanychDao.SamochodyDao;
import BazaDanychDao.SilnikiDao;
import java.util.List;

import java.util.ResourceBundle;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import komis.HibernateUtil;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author Bartek
 */
public class TabelaSamochodyController implements Initializable {

    // SAMOCHODY
    
    @FXML
    private TextField samochodyNrVinField;
    @FXML
    private TextField samochodyMarkaField;
    @FXML
    private TextField samochodyModelField;
    @FXML
    private TextField samochodyTypField;
    @FXML
    private TextField samochodyRokProdukcjiField;
    @FXML
    private TextField samochodyKolorField;
    @FXML
    private TextField samochodyCenaField;
    @FXML
    private TextField samochodyIdSilnikaField;
    @FXML
    private TableView<Samochody> samochodyTv;
    @FXML
    private TextArea samochodyTextArea;
    @FXML
    private TableColumn<Samochody, String> samochodyColNrVin;
    @FXML
    private TableColumn<Samochody, String> samochodyColMarka;
    @FXML
    private TableColumn<Samochody, String> samochodyColModel;
    @FXML
    private TableColumn<Samochody, String> samochodyColTyp;
    @FXML
    private TableColumn<Samochody, Long> samochodyColRokProdukcji;
    @FXML
    private TableColumn<Samochody, String> samochodyColKolor;
    @FXML
    private TableColumn<Samochody, Long> samochodyColCena;
    @FXML
    private TableColumn<Samochody, String> samochodyColIdSilnika;

    SamochodyDao samochodyDao = new SamochodyDao();
    
    // SILNIKI
    
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

    SilnikiDao silnikiDao = new SilnikiDao();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showSamochody();
        showSilniki();
    }    
    
    //Wszystko działa oprócz tego, że jak się usunie adres to usuwa wszystkich użytkowników którzy go mają.
    //Wszystko działa oprócz tego, że jak się usunie adres to usuwa wszystkich użytkowników którzy go mają.
    //Wszystko działa oprócz tego, że jak się usunie adres to usuwa wszystkich użytkowników którzy go mają.
    //Wszystko działa oprócz tego, że jak się usunie adres to usuwa wszystkich użytkowników którzy go mają.
    //Wszystko działa oprócz tego, że jak się usunie adres to usuwa wszystkich użytkowników którzy go mają
    
    public void showSamochody() {
        ObservableList<Samochody> list = FXCollections.observableArrayList(samochodyDao.getSamochody());
        
    	samochodyColNrVin.setCellValueFactory(new PropertyValueFactory<>("nr_vin"));
    	samochodyColCena.setCellValueFactory(new PropertyValueFactory<>("cena"));
    	samochodyColKolor.setCellValueFactory(new PropertyValueFactory<>("kolor"));
    	samochodyColMarka.setCellValueFactory(new PropertyValueFactory<>("marka"));
    	samochodyColModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        samochodyColRokProdukcji.setCellValueFactory(new PropertyValueFactory<>("rok_produkcji"));
        samochodyColTyp.setCellValueFactory(new PropertyValueFactory<>("typ"));
        samochodyColIdSilnika.setCellValueFactory((cell) -> {
            SimpleStringProperty id = new SimpleStringProperty(Long.toString(cell.getValue().getSilniki().getId_silnika()));
            return id;
        });
    	
    	samochodyTv.setItems(list);
    }
    
    public void showSilniki() {
        ObservableList<Silniki> list = FXCollections.observableArrayList(silnikiDao.getSilniki());
    	
    	silnikColIdSilnika.setCellValueFactory(new PropertyValueFactory<>("id_silnika"));
    	silnikColPojemnoscSilnika.setCellValueFactory(new PropertyValueFactory<>("pojemnosc_silnika"));
    	silnikColRodzajPaliwa.setCellValueFactory(new PropertyValueFactory<>("rodzaj_paliwa"));

    	silnikTv.setItems(list);
    }
    
    @FXML
    private void handleMouseActionSamochody(MouseEvent event) { 
            
            Samochody samochod = samochodyTv.getSelectionModel().getSelectedItem();
            samochodyNrVinField.setText(samochod.getNr_vin());
            samochodyCenaField.setText("" + samochod.getCena());
            samochodyKolorField.setText(samochod.getKolor());
            samochodyMarkaField.setText(samochod.getMarka());
            samochodyModelField.setText(samochod.getModel());
            samochodyRokProdukcjiField.setText("" + samochod.getRok_produkcji());
            samochodyTypField.setText(samochod.getTyp());
            samochodyIdSilnikaField.setText("" + samochod.getSilniki().getId_silnika());
        
            samochodyTextArea.setText("" + samochod.getSilniki().toString());
    }
    
    @FXML
    private void handleMouseActionSilniki(MouseEvent event) {
        Silniki silnik = silnikTv.getSelectionModel().getSelectedItem();
        silnikIdSilnikaField.setText("" + silnik.getId_silnika());
        silnikPojemnoscSilnikaField.setText(silnik.getPojemnosc_silnika());
        silnikRodzajPaliwaField.setText(silnik.getRodzaj_paliwa());
    }
    
    @FXML
    private void insertButtonSamochody() throws Exception {
    	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            Samochody samochod = new Samochody(
                samochodyNrVinField.getText(),
                samochodyMarkaField.getText(),
                samochodyModelField.getText(),
                samochodyTypField.getText(),
                Long.parseLong(samochodyRokProdukcjiField.getText()),
                samochodyKolorField.getText(),
                Long.parseLong(samochodyCenaField.getText())
            );  
            
            if (samochodyIdSilnikaField.getText().length() == 0) {
                
                Silniki silnik = new Silniki(
                silnikPojemnoscSilnikaField.getText(), 
                silnikRodzajPaliwaField.getText());
                        
                samochod.setSilniki(silnik);
                samochodyDao.saveSamochody(samochod);
                
            } else {
                List silnik = session.createQuery("FROM Silniki E WHERE E.id_silnika = " + samochodyIdSilnikaField.getText()).list();            
                ObservableList<Silniki> silniki = FXCollections.observableArrayList(silnik);
                
                
                samochod.setSilniki(silniki.get(0));
                session.save(samochod);
            }
            
            session.getTransaction().commit();
            
            showSamochody();
            showSilniki();
        }
    }
    
    
    @FXML 
    private void updateButtonSamochody() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            
            Samochody samochod = session.get(Samochody.class, samochodyNrVinField.getText());
            
            samochod.setCena(Long.parseLong(samochodyCenaField.getText()));
            samochod.setKolor(samochodyKolorField.getText());
            samochod.setMarka(samochodyMarkaField.getText());
            samochod.setModel(samochodyModelField.getText());
            samochod.setRok_produkcji(Long.parseLong(samochodyRokProdukcjiField.getText()));
            
            List silnik = session.createQuery("FROM Silniki E WHERE E.id_silnika = " + samochodyIdSilnikaField.getText()).list();            
            ObservableList<Silniki> silniki = FXCollections.observableArrayList(silnik);
            
            long oldIdSilnika = samochod.getSilniki().getId_silnika();
            samochod.setSilniki(silniki.get(0));
            
            session.save(samochod);
            
            if (oldIdSilnika != silniki.get(0).getId_silnika()) {
                List listSilnik = session.createQuery("FROM Silniki E WHERE E.id_silnika= " + oldIdSilnika).list();
                ObservableList<Silniki> obsSilnik = FXCollections.observableArrayList(listSilnik);
                
                if (obsSilnik.get(0).getSamochody().size() == 1) {
                    obsSilnik.get(0).getSamochody().clear();
                    
                    Silniki silnikToDelete = session.load(Silniki.class, oldIdSilnika);
                    session.delete(silnikToDelete);
                }
            }
            
            session.getTransaction().commit();
            
            showSamochody();
            showSilniki();
        }
    }
    
    @FXML
    private void deleteButtonSamochody() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            
            Samochody samochod = session.get(Samochody.class, Long.parseLong(samochodyNrVinField.getText()));
            session.delete(samochod);
            
            session.getTransaction().commit();
            
            showSamochody();
            showSilniki();
        }
    }
    
    @FXML 
    private void updateButtonSilniki() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            
            Silniki silnik = session.get(Silniki.class, Long.parseLong(silnikIdSilnikaField.getText()));
            
            silnik.setPojemnosc_silnika(silnikPojemnoscSilnikaField.getText());
            silnik.setRodzaj_paliwa(silnikRodzajPaliwaField.getText());
            
            
            session.getTransaction().commit();
            
            showSamochody();
            showSilniki();
        }
    }
    
    @FXML
    private void deleteButtonSilniki() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            
            Silniki silnik = session.get(Silniki.class, Long.parseLong(silnikIdSilnikaField.getText()));
            session.delete(silnik);
            
            session.getTransaction().commit();
            
            showSamochody();
            showSilniki();
        }
    }
    
    @FXML
    private void clearSamochody() {
        samochodyNrVinField.setText("");
        samochodyCenaField.setText("");
        samochodyKolorField.setText("");
        samochodyMarkaField.setText("");
        samochodyModelField.setText("");
        samochodyRokProdukcjiField.setText("");
        samochodyTypField.setText("");
        samochodyIdSilnikaField.setText("");
    }
    
    @FXML
    private void clearSilniki() {
        silnikIdSilnikaField.setText("");
        silnikPojemnoscSilnikaField.setText("");
        silnikRodzajPaliwaField.setText("");
    }
    
}
