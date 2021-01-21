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
    private void goAdresy() throws Exception {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("tabele/adresy/TabelaAdresy.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Tabela adresy");
        stage.setScene(scene);
        stage.show();  
    }
    
    @FXML
    private void goKlienci() throws Exception {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("tabele/klienci/TabelaKlienci.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Tabela klienci");
        stage.setScene(scene);
        stage.show();  
        
//        Parent root1;
//        root1 = FXMLLoader.load(getClass().getResource("tabele/adresy/TabelaAdresy.fxml"));
//        Stage stage1 = new Stage();
//        Scene scene1 = new Scene(root1);
//        stage1.setX(primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() - 1400);
//        stage1.setY(primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() - 400);
//        stage1.setTitle("Tabela adresy");
//        stage1.setScene(scene1);
//        stage1.show();  
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
        
//        Parent root1;
//        root1 = FXMLLoader.load(getClass().getResource("tabele/klienci/TabelaKlienci.fxml"));
//        Stage stage1 = new Stage();
//        Scene scene1 = new Scene(root1);
//        stage1.setX(primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() - 1900);
//        stage1.setY(primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() - 400);
//        stage1.setTitle("Tabela klienci");
//        stage1.setScene(scene1);
//        stage1.show();  
//        
//        Parent root2;
//        root2 = FXMLLoader.load(getClass().getResource("tabele/pracownicy/TabelaPracownicy.fxml"));
//        Stage stage2 = new Stage();
//        Scene scene2 = new Scene(root2);
//        stage2.setX(primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() - 900);
//        stage2.setY(primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() - 400);
//        stage2.setTitle("Tabela pracownicy");
//        stage2.setScene(scene2);
//        stage2.show();  
//        
//        Parent root3;
//        root3 = FXMLLoader.load(getClass().getResource("tabele/samochody/TabelaSamochody.fxml"));
//        Stage stage3 = new Stage();
//        Scene scene3 = new Scene(root3);
//        stage3.setX(primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() - 1200);
//        stage3.setY(primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() - 400);
//        stage3.setTitle("Tabela samochody");
//        stage3.setScene(scene3);
//        stage3.show();
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
        
//        Parent root1;
//        root1 = FXMLLoader.load(getClass().getResource("tabele/silniki/TabelaSilniki.fxml"));
//        Stage stage1 = new Stage();
//        Scene scene1 = new Scene(root1);
//        stage1.setX(primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() - 1400);
//        stage1.setY(primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() - 400);
//        stage1.setTitle("Tabela samochody");
//        stage1.setScene(scene1);
//        stage1.show();  
    }
    
    @FXML
    private void goSilniki() throws Exception {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("tabele/silniki/TabelaSilniki.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Tabela silniki");
        stage.setScene(scene);
        stage.show();  
    }
    
}
