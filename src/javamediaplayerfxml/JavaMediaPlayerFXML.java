/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamediaplayerfxml;

import java.awt.Desktop;
import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author dclop
 */
public class JavaMediaPlayerFXML extends Application {
    
    private static Stage stage;
    
    
    private static void setStage(Stage stage){
        JavaMediaPlayerFXML.stage = stage;
    }
    
    public static Stage getStage(){
        return JavaMediaPlayerFXML.stage;
    }
    
    @Override
    public void start(Stage Pstage) throws Exception {
        
        setStage(Pstage);
         
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        String css = this.getClass().getResource("mpStyle.css").toExternalForm();
        scene.getStylesheets().add(css);
        Pstage.setScene(scene);
        Pstage.show();
    }
    
    public Desktop desktop = Desktop.getDesktop();
    
    public static FileChooser fc = new FileChooser();
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
}
