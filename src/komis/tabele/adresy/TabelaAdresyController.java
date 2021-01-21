/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komis.tabele.adresy;

import java.net.URL;

import BazaDanych.Adresy;
import BazaDanychDao.AdresyDao;

import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Bartek
 */
public class TabelaAdresyController implements Initializable {

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
        showAdresy();
    }    
    
    public void showAdresy() {
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
    private void insertButton() {

    }
    
    @FXML 
    private void updateButton() {

    }
    
    @FXML
    private void deleteButton() {

    }
}
