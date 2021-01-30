/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package komis.tabele.transakcje;

import BazaDanych.Klienci;
import BazaDanych.Pracownicy;
import BazaDanych.Samochody;
import java.net.URL;

import BazaDanych.Transakcje;
import BazaDanychDao.KlienciDao;
import BazaDanychDao.PracownicyDao;
import BazaDanychDao.SamochodyDao;
import BazaDanychDao.TransakcjeDao;
import java.util.List;

import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.transaction.Transactional;
import komis.HibernateUtil;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author Bartek
 */
public class TabelaTransakcjeController implements Initializable {

    //TRANSAKCJE
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
    private TableColumn<Transakcje, String> transakcjeColIdKlienta;
    @FXML
    private TableColumn<Transakcje, String> transakcjeColNrVin;
    @FXML
    private TableColumn<Transakcje, String> transakcjeColIdPracownika;
    @FXML
    private TableColumn<Transakcje, String> transakcjeColDataTransakcji;
    @FXML
    private TableColumn<Transakcje, String> transakcjeColRodzajTransakcji;
   
    TransakcjeDao transakcjeDao = new TransakcjeDao();
    
    //KLIENCI
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
    private TableColumn<Klienci, String> klienciColIdAdresu;

    KlienciDao klienciDao = new KlienciDao();
    
    @FXML
    private TextArea klienciTextArea;
    
    //SAMOCHODY
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
    
    //PRACOWNICY
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
    
    PracownicyDao pracownicyDao = new PracownicyDao();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        transakcjeRodzajTransakcjiField.getItems().removeAll(transakcjeRodzajTransakcjiField.getItems());
        transakcjeRodzajTransakcjiField.getItems().addAll("Sprzedaż");
        transakcjeRodzajTransakcjiField.getSelectionModel().select("Sprzedaż");
        showTransakcje();
        showKlienci();
        showSamochody();
        showPracownicy();
    }    
    
    public void showTransakcje() {
        ObservableList<Transakcje> list = FXCollections.observableArrayList(transakcjeDao.getTransakcje());
    	
    	transakcjeColIdTransakcji.setCellValueFactory(new PropertyValueFactory<>("id_transakcji"));
    	transakcjeColDataTransakcji.setCellValueFactory(new PropertyValueFactory<>("data_transakcji"));
    	transakcjeColRodzajTransakcji.setCellValueFactory(new PropertyValueFactory<>("rodzaj_transakcji"));
    	transakcjeColIdKlienta.setCellValueFactory((cell) -> {
            SimpleStringProperty id = new SimpleStringProperty(Long.toString(cell.getValue().getKlienci().getId_klienta()));
            return id;
        });
    	transakcjeColIdPracownika.setCellValueFactory((cell) -> {
            SimpleStringProperty id = new SimpleStringProperty(Long.toString(cell.getValue().getPracownicy().getId_pracownika()));
            return id;
        });
        transakcjeColNrVin.setCellValueFactory((cell) -> {
            SimpleStringProperty id = new SimpleStringProperty(cell.getValue().getVin().getNr_vin());
            return id;
        });
        
    	
    	transakcjeTv.setItems(list);
    }
    
    private void showKlienci() {
        ObservableList<Klienci> list = FXCollections.observableArrayList(klienciDao.getKlienci());

    	klienciColIdKlienta.setCellValueFactory(new PropertyValueFactory<>("id_klienta"));
    	klienciColImie.setCellValueFactory(new PropertyValueFactory<>("imie"));
    	klienciColNazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
    	klienciColNip.setCellValueFactory(new PropertyValueFactory<>("nip"));
    	klienciColNrTelefonu.setCellValueFactory(new PropertyValueFactory<>("numer_telefonu"));
        klienciColPesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        klienciColIdAdresu.setCellValueFactory((cell) -> {
            SimpleStringProperty id = new SimpleStringProperty(Long.toString(cell.getValue().getAdresy().getId_adresu()));
            return id;
        });
    	
    	klienciTv.setItems(list);
    }
    
    private void showPracownicy() {
        ObservableList<Pracownicy> list = FXCollections.observableArrayList(pracownicyDao.getPracownicy());
    	
    	pracownicyColIdPracownika.setCellValueFactory(new PropertyValueFactory<>("id_pracownika"));
        pracownicyColImie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        pracownicyColNazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
    	pracownicyColDataZatrudnienia.setCellValueFactory(new PropertyValueFactory<>("data_zatrudnienia"));
    	pracownicyColZarobki.setCellValueFactory(new PropertyValueFactory<>("zarobki"));
    	pracownicyColNumerTelefonu.setCellValueFactory(new PropertyValueFactory<>("numer_telefonu"));
        
    	pracownicyTv.setItems(list);
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
    	
    	samochodyTv.setItems(list);
    }
    
    @FXML
    private void insertButton() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            
            List klient = session.createQuery("FROM Klienci E WHERE E.id_klienta = " + transakcjeIdKlientaField.getText()).list();            
            ObservableList<Klienci> klienci = FXCollections.observableArrayList(klient);
            Klienci klientToSet = klienci.get(0);
            
            List samochod = session.createQuery("FROM Samochody E WHERE E.nr_vin = '" + transakcjeNrVinField.getText() + "'").list();            
            ObservableList<Samochody> samochody = FXCollections.observableArrayList(samochod);
            Samochody samochodToSet = samochody.get(0);
            
            List pracownik = session.createQuery("FROM Pracownicy E WHERE E.id_pracownika = " + transakcjeIdPracownikaField.getText()).list();            
            ObservableList<Pracownicy> pracownicy = FXCollections.observableArrayList(pracownik);
            Pracownicy pracownikToSet = pracownicy.get(0);

            Transakcje transakcja = new Transakcje(
                klientToSet,
                samochodToSet,
                pracownikToSet,
                transakcjeDataTransakcjiField.getText(),
                transakcjeRodzajTransakcjiField.getSelectionModel().getSelectedItem().toString()
                );
                
            session.delete(samochodToSet);
            
            transakcjeDao.saveTransakcje(transakcja);
            session.getTransaction().commit();
            

            showSamochody();
            showTransakcje();
            
        }  
    }
    
    @FXML
    private void clearTransakcje() { 
        transakcjeIdTransakcjiField.setText("");
        transakcjeDataTransakcjiField.setText("");
        transakcjeRodzajTransakcjiField.getSelectionModel().select("Sprzedaż");
        transakcjeIdKlientaField.setText("");
        transakcjeIdPracownikaField.setText("");
        transakcjeNrVinField.setText("");
    }
    
    @FXML
    @Transactional
    private void handleMouseAction(MouseEvent event) {
        Transakcje transakcja = transakcjeTv.getSelectionModel().getSelectedItem();
        transakcjeIdTransakcjiField.setText("" + transakcja.getId_transakcji());
        transakcjeDataTransakcjiField.setText("" + transakcja.getData_transakcji());
        transakcjeRodzajTransakcjiField.getSelectionModel().select(transakcja.getRodzaj_transakcji());
        transakcjeIdKlientaField.setText("" + transakcja.getKlienci());
        transakcjeIdPracownikaField.setText("" + transakcja.getPracownicy());
        transakcjeNrVinField.setText("" + transakcja.getVin());
    }
    
    @FXML
    private void handleMouseActionSamochody(MouseEvent event) { 
        Samochody samochod = samochodyTv.getSelectionModel().getSelectedItem();
        samochodyTextArea.setText("" + samochod.getSilniki().toString() + "\n\n nr_vin = " + samochod.getNr_vin());
    }

    @FXML
    private void handleMouseActionKlienci(MouseEvent event) {
        Klienci klient = klienciTv.getSelectionModel().getSelectedItem();
        klienciTextArea.setText("" + klient.getAdresy().toString() + "\n\n id_klienta = " + klient.getId_klienta());
    }
    
    @FXML
    private void odswiezSamochody() {
        showSamochody();
    }
    
    @FXML
    private void odswiezPracownicy() {
        showPracownicy();
    }
    
    @FXML
    private void odswiezKlienci() {
        showKlienci();
    }
}
