/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komis.tabele.pracownicy;

import java.net.URL;

import BazaDanych.Pracownicy;
import BazaDanychDao.PracownicyDao;

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
    
    PracownicyDao pracownicyDao = new PracownicyDao();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showPracownicy();
    }    
    
    public void showPracownicy() {
        
        ObservableList<Pracownicy> list = FXCollections.observableArrayList(pracownicyDao.getPracownicy());
    	
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

    @FXML
    private void handleMouseAction(MouseEvent event) {
        Pracownicy pracownik = pracownicyTv.getSelectionModel().getSelectedItem();
        pracownicyIdPracownikaField.setText("" + pracownik.getId_pracownika());
        pracownicyImieField.setText(pracownik.getImie());
        pracownicyNazwiskoField.setText(pracownik.getNazwisko());
        pracownicyDataZatrudnieniaField.setText(pracownik.getData_zatrudnienia());
        pracownicyZarobkiField.setText("" + pracownik.getZarobki());
        pracownicyNumerTelefonuField.setText("" + pracownik.getNumer_telefonu());
    }
    
}
