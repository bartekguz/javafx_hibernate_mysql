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
import java.util.Optional;

import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
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
    private ComboBox samochodySprzedanyField;
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
    @FXML
    private TableColumn<Samochody, String> samochodyColSprzedany;

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
        samochodySprzedanyField.getItems().removeAll(samochodySprzedanyField.getItems());
        samochodySprzedanyField.getItems().addAll("tak");
        samochodySprzedanyField.getItems().addAll("nie");
        samochodySprzedanyField.getSelectionModel().select("nie");
        
        showSamochody();
        showSilniki();
    }    
    
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
        samochodyColSprzedany.setCellValueFactory(new PropertyValueFactory<>("sprzedany"));
    	
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
        try {
            Samochody samochod = samochodyTv.getSelectionModel().getSelectedItem();
            samochodyNrVinField.setText(samochod.getNr_vin());
            samochodyCenaField.setText("" + samochod.getCena());
            samochodyKolorField.setText(samochod.getKolor());
            samochodyMarkaField.setText(samochod.getMarka());
            samochodyModelField.setText(samochod.getModel());
            samochodyRokProdukcjiField.setText("" + samochod.getRok_produkcji());
            samochodyTypField.setText(samochod.getTyp());
            samochodyIdSilnikaField.setText("" + samochod.getSilniki().getId_silnika());
            samochodySprzedanyField.getSelectionModel().getSelectedItem().toString();
        
            samochodyTextArea.setText("" + samochod.getSilniki().toString());
            } catch (Exception e) {
                System.out.print("");
        }
    }
    
    @FXML
    private void handleMouseActionSilniki(MouseEvent event) {
        try {
            Silniki silnik = silnikTv.getSelectionModel().getSelectedItem();
            silnikIdSilnikaField.setText("" + silnik.getId_silnika());
            silnikPojemnoscSilnikaField.setText(silnik.getPojemnosc_silnika());
            silnikRodzajPaliwaField.setText(silnik.getRodzaj_paliwa());
        } catch (Exception e) {
            System.out.print("");
        }
    }
    
    @FXML
    private void insertButtonSamochody(){
    	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            Samochody samochod = new Samochody(
                samochodyNrVinField.getText(),
                samochodyMarkaField.getText(),
                samochodyModelField.getText(),
                samochodyTypField.getText(),
                Long.parseLong(samochodyRokProdukcjiField.getText()),
                samochodyKolorField.getText(),
                Long.parseLong(samochodyCenaField.getText()),
                samochodySprzedanyField.getSelectionModel().getSelectedItem().toString()
            );  
            
            if (samochodyIdSilnikaField.getText().length() == 0) {
                
                Silniki silnik = new Silniki(
                silnikPojemnoscSilnikaField.getText(), 
                silnikRodzajPaliwaField.getText());
                        
                samochod.setSilniki(silnik);
                silnikiDao.saveSilniki(silnik);
                samochodyDao.saveSamochody(samochod);
                
                
            } else {
                try {
                List silnik = session.createQuery("FROM Silniki E WHERE E.id_silnika = " + samochodyIdSilnikaField.getText()).list();            
                ObservableList<Silniki> silniki = FXCollections.observableArrayList(silnik);
                
                
                samochod.setSilniki(silniki.get(0));
                session.save(samochod);
                } catch (Exception e) {
                    Alert alert = new Alert(AlertType.ERROR, "Wpisano nieznane id_silnika w polu id_silnika!"
                            + "\nJeśli chcesz wpisać samochod z nowym typem silnika, pole id_silnika musi pozostać puste ponieważ uzupełni się automatycznie!");
                    alert.show();
                }
            }
            
            clearSamochody();
            clearSilniki();
            
            session.getTransaction().commit();
            
            showSamochody();
            showSilniki();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR, "Wszystkie pola muszą posiadać odpowiedni typ!");
                    alert.show();
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
            samochod.setSprzedany(samochodySprzedanyField.getSelectionModel().getSelectedItem().toString());
            
            List silnik = session.createQuery("FROM Silniki E WHERE E.id_silnika = " + samochodyIdSilnikaField.getText()).list();            
            ObservableList<Silniki> silniki = FXCollections.observableArrayList(silnik);
            
            Long oldIdSilnika = samochod.getSilniki().getId_silnika();
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
            
            clearSamochody();
            
            session.getTransaction().commit();
            
            showSamochody();
            showSilniki();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR, "Wpisano nieznane id_silnika w polu id_silnika lub pola nie posiadają odpowiedniego typu!");
                    alert.show();
        }
    }
    
    @FXML
    private void deleteButtonSamochody() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            
            Samochody samochod = session.load(Samochody.class, samochodyNrVinField.getText());
            Silniki silnik = session.load(Silniki.class, samochod.getSilniki().getId_silnika());
            
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Potwierdzenie");
            alert.setHeaderText("Potwierdź usunięcie samochodu");
            alert.setContentText("Czy na pewno chcesz usunąć samochód?");
            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                if (samochod.getSprzedany().equals("nie")) {
                    silnik.removeSamochod(samochod);
                    session.delete(samochod);
            
                    if (silnik.getSamochody().isEmpty()) {
                        session.delete(silnik);
                    }
                } else {
                    Alert alert1 = new Alert(AlertType.ERROR, "Nie można usunąć samochodu ponieważ został sprzedany!");
                    alert1.show();
                }
            } else {
         
            }
            
            session.getTransaction().commit();
            
            showSamochody();
            showSilniki();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR, "Samochód który chcesz usunąć nie istnieje!");   
                    alert.show();
        }
    }
    
    @FXML 
    private void updateButtonSilniki() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            
            Silniki silnik = session.get(Silniki.class, Long.parseLong(silnikIdSilnikaField.getText()));
            
            silnik.setPojemnosc_silnika(silnikPojemnoscSilnikaField.getText());
            silnik.setRodzaj_paliwa(silnikRodzajPaliwaField.getText());
            
            clearSilniki();
            
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
        samochodySprzedanyField.getSelectionModel().select("nie");
    }
    
    @FXML
    private void clearSilniki() {
        silnikIdSilnikaField.setText("");
        silnikPojemnoscSilnikaField.setText("");
        silnikRodzajPaliwaField.setText("");
    }
    
}
