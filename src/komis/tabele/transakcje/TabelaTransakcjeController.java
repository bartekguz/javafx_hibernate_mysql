/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package komis.tabele.transakcje;

import java.net.URL;

import BazaDanych.Transakcje;
import BazaDanychDao.TransakcjeDao;

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
import javafx.scene.input.MouseEvent;

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
   
    TransakcjeDao transakcjeDao = new TransakcjeDao();
    
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
    
    public void showTransakcje() {
        ObservableList<Transakcje> list = FXCollections.observableArrayList(transakcjeDao.getTransakcje());
    	
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
    
    @FXML
    private void handleMouseAction(MouseEvent event) {
        Transakcje transakcja = transakcjeTv.getSelectionModel().getSelectedItem();
        transakcjeIdTransakcjiField.setText("" + transakcja.getId_transakcji());
        transakcjeDataTransakcjiField.setText("" + transakcja.getData_transakcji());
        transakcjeRodzajTransakcjiField.getSelectionModel().select(transakcja.getRodzaj_transakcji());
        transakcjeIdKlientaField.setText("" + transakcja.getKlienci());
        transakcjeIdPracownikaField.setText("" + transakcja.getPracownicy());
        transakcjeNrVinField.setText("" + transakcja.getVin());
    }

}
