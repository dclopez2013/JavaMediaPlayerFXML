/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamediaplayerfxml;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javamediaplayerfxml.JavaMediaPlayerFXML;
import sun.management.FileSystem;
/**
 *
 * @author dclop
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button playButton;
       
    @FXML
    private Button pauseButton;
    
       
    @FXML
    private Button stopButton;
    
    @FXML
    private Button fileButton;
    
    @FXML
    private Label songName;
    
    @FXML
    private Label playStatus;
    
    public String mediaString;
    
    @FXML 
    private AnchorPane ap;
    
    public MediaPlayer mp;
  
    public Media filemedia;
    
    @FXML
    private MediaView mediaView;
    
    public static File mediaF;
    
    Path mPath;
    
    public void openFile(){
      Alert alert = new Alert(AlertType.CONFIRMATION, "Opeing file explorer to select a file");
      mediaF = JavaMediaPlayerFXML.fc.showOpenDialog(JavaMediaPlayerFXML.getStage());
     // Path Tstring = mediaF.toPath();
      
      alert.setContentText("You selected: "+ mediaF);
      alert.showAndWait();
      this.setTitle();
            // public static Media fileMedia = new Media(‪);         
            
      URI f = mediaF.toURI();
      
        try {
            filemedia = new Media(f.toURL().toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
         mp = new MediaPlayer(filemedia);         
          mediaView.setMediaPlayer(mp);
    }
    
     public void pauseMedia(){
         this.setPlayStatus("Paused");
         mp.pause();
     }
     
    
     public void stopMedia(){
         this.setPlayStatus("Stopped");
         mp.stop();
     }
     
     
     
     public void playMedia(){
      
      this.setPlayStatus("Playing");
     mp.play();
     }
    
    
     public void setTitle(){
         this.songName.setText(mediaString);
     }
     
     public void setPlayStatus(String s){
         this.playStatus.setText(s);
     }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
