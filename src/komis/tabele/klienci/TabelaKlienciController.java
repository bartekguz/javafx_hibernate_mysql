/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komis.tabele.klienci;

import BazaDanych.Adresy;
import java.net.URL;

import BazaDanych.Klienci;
import BazaDanychDao.AdresyDao;
import BazaDanychDao.KlienciDao;
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
public class TabelaKlienciController implements Initializable {

    // KLIENCI
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
    private TableColumn<Klienci, String> klienciColIdAdresu;

    KlienciDao klienciDao = new KlienciDao();
    
    @FXML
    private TextArea klienciTextArea;
            
    // ADRESY
    
    @FXML
    private TextField adresIdAdresuField;
    @FXML
    private TextField adresKodPocztowyField;
    @FXML
    private TextField adresNazwaMiejscowosciField;
    @FXML
    private TextField adresNazwaUlicyField;
    @FXML
    private TextField adresNazwaWojewodztwaField;  
    @FXML
    private TextField adresNumerDomuField;
    @FXML
    private TableView<Adresy> adresTv;
    @FXML
    private TableColumn<Adresy, Long> adresColIdAdresu;
    @FXML
    private TableColumn<Adresy, String> adresColKodPocztowy;
    @FXML
    private TableColumn<Adresy, String> adresColNazwaMiejscowosci;
    @FXML
    private TableColumn<Adresy, String> adresColNazwaUlicy;
    @FXML
    private TableColumn<Adresy, String> adresColNazwaWojewodztwa;
    @FXML
    private TableColumn<Adresy, String> adresColNumerDomu;

    AdresyDao adresyDao = new AdresyDao();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {   

        showKlienci();
        showAdresy();
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
    
    private void showAdresy() {
        ObservableList<Adresy> list = FXCollections.observableArrayList(adresyDao.getAdresy());
        
    	adresColIdAdresu.setCellValueFactory(new PropertyValueFactory<>("id_adresu"));
        adresColKodPocztowy.setCellValueFactory(new PropertyValueFactory<>("kod_pocztowy"));
    	adresColNazwaMiejscowosci.setCellValueFactory(new PropertyValueFactory<>("nazwa_miejscowosci"));
    	adresColNazwaUlicy.setCellValueFactory(new PropertyValueFactory<>("nazwa_ulicy"));
    	adresColNazwaWojewodztwa.setCellValueFactory(new PropertyValueFactory<>("nazwa_wojewodztwa"));
        adresColNumerDomu.setCellValueFactory(new PropertyValueFactory<>("numer_domu"));
    	
    	adresTv.setItems(list);
    }
    

    @FXML
    private void handleMouseActionKlienci(MouseEvent event) {
        try {
        Klienci klient = klienciTv.getSelectionModel().getSelectedItem();
        klienciIdKlientaField.setText("" + klient.getId_klienta());
        klienciImieField.setText(klient.getImie());
        klienciNazwiskoField.setText(klient.getNazwisko());
        klienciNipField.setText("" + klient.getNip());
        klienciNrTelefonuField.setText("" + klient.getNumer_telefonu());
        klienciPeselField.setText("" + klient.getPesel());
        klienciIdAdresuField.setText("" + klient.getAdresy().getId_adresu());
        
        klienciTextArea.setText("" + klient.getAdresy().toString());
        } catch (Exception e) {
            System.out.print("");
        }
    }
    
    @FXML
    private void handleMouseActionAdresy(MouseEvent event) {
        try {
            Adresy adres = adresTv.getSelectionModel().getSelectedItem();
            adresIdAdresuField.setText("" + adres.getId_adresu());
            adresKodPocztowyField.setText(adres.getKod_pocztowy());
            adresNazwaMiejscowosciField.setText("" + adres.getNazwa_miejscowosci());
            adresNazwaUlicyField.setText(adres.getNazwa_ulicy());
            adresNazwaWojewodztwaField.setText("" + adres.getNazwa_wojewodztwa());
            adresNumerDomuField.setText(adres.getNumer_domu());
        } catch (Exception e) {
            System.out.print("");
        }
    }
    
    
    @FXML
    private void insertButtonKlienci() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
        
            Klienci klient = new Klienci(
                klienciImieField.getText(), 
                klienciNazwiskoField.getText(), 
                Long.parseLong(klienciPeselField.getText()), 
                Long.parseLong(klienciNipField.getText()), 
                Long.parseLong(klienciNrTelefonuField.getText())
            );

            if (klienciIdAdresuField.getText().length() == 0) {
                
                Adresy adres = new Adresy(
                adresNazwaMiejscowosciField.getText(), 
                adresKodPocztowyField.getText(), 
                adresNazwaWojewodztwaField.getText(), 
                adresNazwaUlicyField.getText(), 
                adresNumerDomuField.getText()
                );
                
                klient.setAdresy(adres);
                adresyDao.saveAdresy(adres);
                klienciDao.saveKlienci(klient);
            } else {
                try {
                List adres = session.createQuery("FROM Adresy E WHERE E.id_adresu = " + klienciIdAdresuField.getText()).list();
                ObservableList<Adresy> adresy = FXCollections.observableArrayList(adres);
                
                klient.setAdresy(adresy.get(0));
                session.save(klient);
                } catch (Exception e) {
                    Alert alert = new Alert(AlertType.ERROR, "Wpisano nieznane id_adresu w polu id_adresu!"
                            + "\nJeśli chcesz wpisać użytkownika z nowym adresem, pole id_adresu musi pozostać puste ponieważ uzupełni się automatycznie!");
                    alert.show();
                }
            }
            
            clearKlienci();
            clearAdresy();
            
            session.getTransaction().commit();
            
            showKlienci();
            showAdresy();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR, "Wszystkie pola muszą posiadać odpowiedni typ!");
                    alert.show();
        }
    }
   
    
    @FXML 
    private void updateButtonKlienci() {
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            
            Klienci klient = session.get(Klienci.class, Long.parseLong(klienciIdKlientaField.getText()));
            
            klient.setImie(klienciImieField.getText());
            klient.setNazwisko(klienciNazwiskoField.getText());
            klient.setPesel(Long.parseLong(klienciPeselField.getText()));
            klient.setNip(Long.parseLong(klienciNipField.getText()));
            klient.setNumer_telefonu(Long.parseLong(klienciNrTelefonuField.getText()));
            
            List adres = session.createQuery("FROM Adresy E WHERE E.id_adresu = " + klienciIdAdresuField.getText()).list();
            ObservableList<Adresy> adresy = FXCollections.observableArrayList(adres);
            
            Long oldIdAdress = klient.getAdresy().getId_adresu();
            klient.setAdresy(adresy.get(0));
            
            session.save(klient);
            
            if (oldIdAdress != adresy.get(0).getId_adresu()) {
                List listAdres = session.createQuery("FROM Adresy E WHERE E.id_adresu = " + oldIdAdress).list();
                ObservableList<Adresy> obsAdres = FXCollections.observableArrayList(listAdres);
                
                if (obsAdres.get(0).getKlienci().size() == 1) {
                    obsAdres.get(0).getKlienci().clear();
                    
                    Adresy adresToDelete = session.load(Adresy.class, oldIdAdress);  
                    session.delete(adresToDelete);
                }
            }
            
            clearKlienci();
            session.getTransaction().commit();
            
            showKlienci();
            showAdresy();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR, "Wpisano nieznane id_adresu w polu id_adresu lub pola nie posiadają odpowiedniego typu!");
                    alert.show();
        }
    }
    
    @FXML
    private void deleteButtonKlienci() {
    	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            
            Klienci klient = session.load(Klienci.class, Long.parseLong(klienciIdKlientaField.getText()));
            Adresy adres = session.load(Adresy.class, klient.getAdresy().getId_adresu());
            
            
            
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Potwierdzenie");
            alert.setHeaderText("Potwierdź usunięcie klienta");
            alert.setContentText("Czy na pewno chcesz usunąć klienta?");
            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                if (klient.getTransakcje().isEmpty()) {
                    adres.removeKlient(klient);
                    session.delete(klient);
                        if (adres.getKlienci().isEmpty()) {
                            session.delete(adres);
                        } 
                } else {
                    Alert alert1 = new Alert(AlertType.ERROR, "Nie można usunąć klienta ponieważ posiada on transakcje!");
                    alert1.show();
                }
            } else {
                
            }
            
            session.getTransaction().commit();
            
            showAdresy();
            showKlienci();
        }
    }
    
    @FXML 
    private void updateButtonAdresy() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            
            Adresy adres = session.get(Adresy.class, Long.parseLong(adresIdAdresuField.getText()));  
            
            adres.setNazwa_miejscowosci(adresNazwaMiejscowosciField.getText());
            adres.setKod_pocztowy(adresKodPocztowyField.getText());
            adres.setNazwa_wojewodztwa(adresNazwaWojewodztwaField.getText());
            adres.setNazwa_ulicy(adresNazwaUlicyField.getText());
            adres.setNumer_domu(adresNumerDomuField.getText());
            
            clearAdresy();
            session.getTransaction().commit();
            
            showAdresy();
            showKlienci();
        }
    }
    
    @FXML
    private void clearKlienci() {
    	klienciIdKlientaField.setText("");
        klienciImieField.setText("");
        klienciNazwiskoField.setText("");
        klienciNipField.setText("");
        klienciNrTelefonuField.setText("");
        klienciPeselField.setText("");
        klienciIdAdresuField.setText("");
    }
    
    @FXML
    private void clearAdresy() { 
        adresIdAdresuField.setText("");
        adresKodPocztowyField.setText("");
        adresNazwaMiejscowosciField.setText("");
        adresNazwaUlicyField.setText("");
        adresNazwaWojewodztwaField.setText("");
        adresNumerDomuField.setText("");
    }
}
