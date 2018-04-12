/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import pidev.Zanimaux.entities.veterinaires;
import pidev.Zanimaux.Services.CrudVeterinaires;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author ci
 */
public class AjouterVeterinaireController implements Initializable {

    String image_path;
    
     @FXML
    private Button AjouterVet;
    @FXML
    private TextField nom;
    @FXML
    private TextField address;
    @FXML
    private TextField ville;
    @FXML
    private TextField phone;
     @FXML
    private TextField email;
  int idvet;
     private String path="";
    @FXML
    private ImageView imgviewadd;
    @FXML
    private Button retour;
    
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
    } 
   
     public void setIdvet(Integer Vetid) {
        this.idvet= Vetid;
     }
    
    @FXML 
     private void ajouterVet(ActionEvent event) throws IOException  {
       
         veterinaires v=new veterinaires(nom.getText(), address.getText(),ville.getText(),phone.getText(),email.getText());
         v.setNom_image(image_path);
              CrudVeterinaires as= new CrudVeterinaires();
              as.ajouterVeterinaire(v);
           Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListVeterinaire.fxml"));
                            Region root = (Region) loader.load();
                           ListVeterinaireController liste = loader.<ListVeterinaireController>getController();
                           
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            liste.setIdvet(idvet);
                            liste.initialize(null,null);
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();
          
         
          TrayNotification tray = new TrayNotification();
                    tray.setNotificationType(NotificationType.CUSTOM);
                    tray.setTitle("les Veterinaires");
                    tray.setMessage("Vouz avez ajouter un nouveaux veterinaire");
                    tray.setAnimationType(AnimationType.FADE);
                    tray.showAndDismiss(Duration.millis(2500));

                    tray.setRectangleFill(Color.valueOf("#f78c37"));

          
     }
   
     
      @FXML
    private void load(ActionEvent event) throws MalformedURLException {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {
            image_path = selectedFile.toURI().toURL().toString();
            Image image = new Image(image_path);
            imgviewadd.setImage(image);
        } else {
            System.out.println("fichier invalide");
        }
    }

    @FXML
    private void ListeVet(ActionEvent event) throws IOException {
         Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListVeterinaire.fxml"));
                            Region root = (Region) loader.load();
                           ListVeterinaireController liste= loader.<ListVeterinaireController>getController();
                      liste.initialize(null,null);
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();
    }

}
