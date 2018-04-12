/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import APIs.UploadAPI;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import pidev.Zanimaux.Services.PetSitterService;
import pidev.Zanimaux.entities.PetSitter;

/**
 * FXML Controller class
 *
 * @author I eat ass
 */
public class AjouterPetsitterController implements Initializable {

    File x= null;
    String xname= "";
     FileChooser saveFileChooser = new FileChooser();    
    
    @FXML
    private JFXTextField nom_p;
    @FXML
    private JFXTextField adress_p;
    @FXML
    private JFXTextField ville_p;
    @FXML
    private JFXTextField phone_p;
    @FXML
    private JFXTextField mail_p;
    @FXML
    private JFXButton add;
    @FXML
    private JFXButton update;
    @FXML
    private JFXButton delet;
    @FXML
    private JFXButton ajouterphoto;
    @FXML
    private Label Label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        add.setDisable(true);
    }    

    @FXML
    private void ajouter(ActionEvent event) throws SQLException {
         PetSitter s = new PetSitter (nom_p.getText(),adress_p.getText(),ville_p.getText(),phone_p.getText(),mail_p.getText(),xname);
    PetSitterService ps = new PetSitterService();
    ps.AjouterPetSitter(s);
    
    
    //---
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_rp.fxml"));
        try {
            Parent root = loader.load();
            nom_p.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjouterPetsitterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //-------------
    }

    @FXML
    private void modifier(ActionEvent event) {
    }

    @FXML
    private void supprimer(ActionEvent event) {
    }

    @FXML
    private void ajouterPhoto(ActionEvent event) {
        File file = saveFileChooser.showOpenDialog(null);
        String nameF = "";
        try {
            //-------
            nameF = UploadAPI.upload(file);
            xname= nameF;
        } catch (Exception ex) {
            Logger.getLogger(AjouterPetsitterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            //---
            sleep(6000);
            add.setDisable(false);
        } catch (InterruptedException ex) {
            Logger.getLogger(AjouterPetsitterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
