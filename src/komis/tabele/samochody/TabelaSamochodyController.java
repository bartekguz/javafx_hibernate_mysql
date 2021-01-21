/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komis.tabele.samochody;

import java.net.URL;

import BazaDanych.Samochody;
import BazaDanychDao.SamochodyDao;

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
public class TabelaSamochodyController implements Initializable {

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
    private TableColumn<Samochody, Long> samochodyColIdSilnika;

    SamochodyDao samochodyDao = new SamochodyDao();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showSamochody();
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
        samochodyColIdSilnika.setCellValueFactory(new PropertyValueFactory<>("id_silnika"));
    	
    	samochodyTv.setItems(list);
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
