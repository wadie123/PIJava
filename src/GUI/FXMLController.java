/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import pidev.Zanimaux.Services.PetSitterService;
import pidev.Zanimaux.entities.PetSitter;

/**
 * FXML Controller class
 *
 * @author I eat ass
 */
public class FXMLController implements Initializable {
   
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
    private ImageView urlimagesitter;
    private VBox vboxp;
    @FXML
    private JFXButton add;
    @FXML
    private JFXButton update;
    @FXML
    private JFXButton delet;
    @FXML
    private JFXButton parcourire;
    @FXML
    private Label Label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
  
    @FXML
    private void ajouter(ActionEvent event) throws SQLException {
    PetSitter s = new PetSitter (nom_p.getText(),adress_p.getText(),ville_p.getText(),phone_p.getText(),mail_p.getText());
    PetSitterService ps = new PetSitterService();
    ps.AjouterPetSitter(s);
    }

    @FXML
    private void modifier(ActionEvent event) {
    }

    @FXML
    private void supprimer(ActionEvent event) {
    }

    @FXML
    private void parcourie(ActionEvent event) {
    }

    
}
