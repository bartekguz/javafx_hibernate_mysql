/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komis.tabele.silniki;

import java.net.URL;

import BazaDanych.Silniki;
import BazaDanychDao.SilnikiDao;

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
public class TabelaSilnikiController implements Initializable {

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
        showSilniki();
    }    
    
    public void showSilniki() {
        ObservableList<Silniki> list = FXCollections.observableArrayList(silnikiDao.getSilniki());
    	
    	silnikColIdSilnika.setCellValueFactory(new PropertyValueFactory<>("id_silnika"));
    	silnikColPojemnoscSilnika.setCellValueFactory(new PropertyValueFactory<>("pojemnosc_silnika"));
    	silnikColRodzajPaliwa.setCellValueFactory(new PropertyValueFactory<>("rodzaj_paliwa"));

    	silnikTv.setItems(list);
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
