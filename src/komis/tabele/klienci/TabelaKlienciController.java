/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komis.tabele.klienci;

import java.net.URL;

import BazaDanych.Klienci;
import BazaDanychDao.KlienciDao;

import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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

    KlienciDao klienciDao = new KlienciDao();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showKlienci();
    }    
    
    public void showKlienci() {
        ObservableList<Klienci> list = FXCollections.observableArrayList(klienciDao.getKlienci());
    	
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
    	KlienciDao klienciDao = new KlienciDao();
        klienciDao.addKlienci(
                klienciImieField.getText(), 
                klienciNazwiskoField.getText(), 
                Long.parseLong(klienciPeselField.getText()), 
                Long.parseLong(klienciNipField.getText()), 
                Long.parseLong(klienciNrTelefonuField.getText())
        );
        
        
        showKlienci();
    }
    
    
    @FXML 
    private void updateButton() {
        
    }
    
    @FXML
    private void deleteButton() {
    	
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
        Klienci klient = klienciTv.getSelectionModel().getSelectedItem();
        klienciIdKlientaField.setText("" + klient.getId_klienta());
        klienciImieField.setText(klient.getImie());
        klienciNazwiskoField.setText(klient.getNazwisko());
        klienciNipField.setText("" + klient.getNip());
        klienciNrTelefonuField.setText("" + klient.getNumer_telefonu());
        klienciPeselField.setText("" + klient.getPesel());
        klienciIdAdresuField.setText("" + klient.getAdresy());
    }
}
