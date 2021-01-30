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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    @FXML
    private TableColumn<Samochody, String> samochodyColSprzedany;

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
    @FXML
    private TableColumn<Pracownicy, String> pracownicyColZatrudniony;
    
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
        try {
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
        } catch (Exception e) {
            System.out.println("Błąd [TabelaTransakcjeController] - showTransakcje() " + e);
        }
    }
    
    private void showKlienci() {
        try {
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
        } catch (Exception e) {
            System.out.println("Błąd [TabelaTransakcjeController] - showKlienci() " + e);
        }
    }
    
    private void showPracownicy() {
        try {
            ObservableList<Pracownicy> list = FXCollections.observableArrayList(pracownicyDao.getPracownicy());
    	
            pracownicyColIdPracownika.setCellValueFactory(new PropertyValueFactory<>("id_pracownika"));
            pracownicyColImie.setCellValueFactory(new PropertyValueFactory<>("imie"));
            pracownicyColNazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
            pracownicyColDataZatrudnienia.setCellValueFactory(new PropertyValueFactory<>("data_zatrudnienia"));
            pracownicyColZarobki.setCellValueFactory(new PropertyValueFactory<>("zarobki"));
            pracownicyColNumerTelefonu.setCellValueFactory(new PropertyValueFactory<>("numer_telefonu"));
            pracownicyColZatrudniony.setCellValueFactory(new PropertyValueFactory<>("zatrudniony"));
        
            pracownicyTv.setItems(list);
        } catch (Exception e) {
            System.out.println("Błąd [TabelaTransakcjeController] - showPracownicy() " + e);
        }
    }
    
    public void showSamochody() {
        try {
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
        } catch (Exception e) {
            System.out.println("Błąd [TabelaTransakcjeController] - showSamochody() " + e);
        }
    }
    
    @FXML
    private void insertButton() {
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

            if (samochodToSet.getSprzedany().equals("nie")) {
                Transakcje transakcja = new Transakcje(
                klientToSet,
                samochodToSet,
                pracownikToSet,
                transakcjeDataTransakcjiField.getText(),
                transakcjeRodzajTransakcjiField.getSelectionModel().getSelectedItem().toString()
                );
                
                samochodToSet.setSprzedany("tak");
                
                transakcjeDao.saveTransakcje(transakcja);
            } else {
                Alert alert = new Alert(AlertType.ERROR, "Ten samochód nie jest dostępny!");
                alert.show();
            }
            
            clearTransakcje();

            session.getTransaction().commit();
            

            showSamochody();
            showTransakcje();
        }  catch (Exception e) {
             Alert alert = new Alert(AlertType.ERROR, "Wpisano nieznane id w polu lub wpisano w pole nieodpowiedni typ!");
                    alert.show();
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
        try {
            Transakcje transakcja = transakcjeTv.getSelectionModel().getSelectedItem();
            transakcjeIdTransakcjiField.setText("" + transakcja.getId_transakcji());
            transakcjeDataTransakcjiField.setText("" + transakcja.getData_transakcji());
            transakcjeRodzajTransakcjiField.getSelectionModel().select(transakcja.getRodzaj_transakcji());
            transakcjeIdKlientaField.setText("" + transakcja.getKlienci());
            transakcjeIdPracownikaField.setText("" + transakcja.getPracownicy());
            transakcjeNrVinField.setText("" + transakcja.getVin());
        } catch (Exception e) {
            System.out.print("");
        }
    }
    
    @FXML
    private void handleMouseActionSamochody(MouseEvent event) { 
        try {
            Samochody samochod = samochodyTv.getSelectionModel().getSelectedItem();
            samochodyTextArea.setText("" + samochod.getSilniki().toString() + "\n\n nr_vin = " + samochod.getNr_vin());
        } catch (Exception e) {
            System.out.print("");
        }
    }

    @FXML
    private void handleMouseActionKlienci(MouseEvent event) {
        try {
            Klienci klient = klienciTv.getSelectionModel().getSelectedItem();
            klienciTextArea.setText("" + klient.getAdresy().toString() + "\n\n id_klienta = " + klient.getId_klienta());
        } catch (Exception e) {
            System.out.print("");
        }
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
