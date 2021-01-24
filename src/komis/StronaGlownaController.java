/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komis;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bartek
 */
public class StronaGlownaController {
    Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    
    
    @FXML
    private void goKlienci() throws Exception {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("tabele/klienci/TabelaKlienci.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Tabela klienci");
        stage.setScene(scene);
        stage.show();  
        
    }
    
    @FXML
    private void goTransakcje() throws Exception {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("tabele/transakcje/TabelaTransakcje.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Tabela transakcje");
        stage.setScene(scene);
        stage.show();  
        
    }
    
    @FXML
    private void goPracownicy() throws Exception {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("tabele/pracownicy/TabelaPracownicy.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Tabela pracownicy");
        stage.setScene(scene);
        stage.show();  
    }
    
    @FXML
    private void goSamochody() throws Exception {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("tabele/samochody/TabelaSamochody.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Tabela samochody");
        stage.setScene(scene);
        stage.show();  
         
    }

    
}
