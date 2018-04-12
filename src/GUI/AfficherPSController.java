/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import APIs.UploadAPI;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pidev.Zanimaux.Services.PetSitterService;
import pidev.Zanimaux.entities.PetSitter;

/**
 * FXML Controller class
 *
 * @author I eat ass
 */
public class AfficherPSController implements Initializable {
     PetSitterService pss= new PetSitterService();
     String xname= "";
     FileChooser saveFileChooser = new FileChooser();
     
    @FXML
    private ImageView urlimagesitter;
    @FXML
    private Label Labell;
    @FXML
    private VBox vboxp;
    @FXML
    private ImageView imagep;
    @FXML
    private Label nomp;
    @FXML
    private Label adressp;
    @FXML
    private Label villep;
    @FXML
    private Label phonep;
    @FXML
    private Label mailp;
    @FXML
    private Button suprimer;
    @FXML
    private Button modifier;
    @FXML
    private Button ajouter;
    @FXML
    private Button home;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  List<PetSitter> lp= new ArrayList<>();
        try {
            lp= pss.RetournerPetSitters();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        vboxp.getChildren().clear();
        for (PetSitter p : lp){
            
            vboxp.getChildren().add(petanchor(p));
        }
    }    
      public AnchorPane petanchor (PetSitter p){
        AnchorPane anchor = new AnchorPane();
        anchor.setPrefSize(605.0, 138);
        ImageView img= new ImageView(getClass().getResource("../Images/"+p.getUrlimagesitter()).toExternalForm());
           img.setFitWidth(108.0);
           img.setFitHeight(105.0);
           img.setLayoutX(14);
           img.setLayoutY(14);
           img.setPickOnBounds(true);
           img.setPreserveRatio(true);
       
          
           Label nom= new Label(p.getNom_p());
           nom.setLayoutX(153);
           nom.setLayoutY(39);
           
            Label adr= new Label(p.getAdress_p());
           adr.setLayoutX(153);
           adr.setLayoutY(67);
           
            Label vill= new Label(p.getVille_p());
           vill.setLayoutX(289);
           vill.setLayoutY(39);
           
            Label phone= new Label(p.getPhone_p());
           phone.setLayoutX(289);
           phone.setLayoutY(67);
           
            Label mail= new Label(p.getMail_p());
           mail.setLayoutX(387);
           mail.setLayoutY(39);
           
           Button up= new Button("Modifier");
           up.setLayoutX(517);
           up.setLayoutY(27);
           up.setMnemonicParsing(false);
           String x= Integer.toString(p.getId());
           up.setId(x);
           up.setOnAction(this::updateAction);
           
           Button del= new Button("Supprimer");
           del.setLayoutX(517);
           del.setLayoutY(72);
           del.setMnemonicParsing(false);
           String y= Integer.toString(p.getId());
           System.out.println(y);
           del.setId(y);
           del.setOnAction(this::deleteAction);
           
           
           anchor.getChildren().addAll(img,nom,adr,vill,phone,mail,up,del);
           
        return anchor;
       
    }

    @FXML
    private void deleteAction(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppression");
        //alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText("Voulez vous supprimer ce pet sitter ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Button x = (Button) event.getSource();
        PetSitter a = new PetSitter();
        a.setId(Integer.parseInt(x.getId()));
        
            try {
                pss.SupprimerPetSitter(a);
            } catch (SQLException ex) {
                Logger.getLogger(AfficherPSController.class.getName()).log(Level.SEVERE, null, ex);
            }

        //---
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_rp.fxml"));
        try {
            Parent root = loader.load();
            vboxp.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjouterPetsitterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        } else {
            // ... user chose CANCEL or closed the dialog
        }
        //-------------
    }

    @FXML
    private void updateAction(ActionEvent event) {
        Button x = (Button) event.getSource();
        PetSitter s = new PetSitter();
        PetSitter p = new PetSitter();
        p.setId(Integer.parseInt(x.getId()));
         try {                
             s = pss.getPSById(Integer.parseInt(x.getId()));
         } catch (SQLException ex) {
             Logger.getLogger(AfficherPSController.class.getName()).log(Level.SEVERE, null, ex);
         }
        //------------------
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Modifier Petsitter");
        //dialog.setContentText("Please enter your name:");
        dialog.setHeaderText(null);
        dialog.setGraphic(null);
        
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField nm = new TextField(s.getNom_p());
        TextField am = new TextField(s.getAdress_p());
        TextField vm = new TextField(s.getVille_p());
        TextField pm = new TextField(s.getPhone_p());
        TextField mm = new TextField(s.getMail_p());



        grid.add(new Label("Nom: "), 0, 0);
        grid.add(nm, 1, 0);
        
        grid.add(new Label("Adresse: "), 0, 1);
        grid.add(am, 1, 1);
        
        grid.add(new Label("Ville: "), 0, 2);
        grid.add(vm, 1, 2);
        
        grid.add(new Label("Phone: "), 0, 3);
        grid.add(pm, 1, 3);
        
        grid.add(new Label("Mail: "), 0, 4);
        grid.add(mm, 1, 4);


        dialog.getDialogPane().setContent(grid);
        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){       
            s.setNom_p(nm.getText());
            s.setAdress_p(am.getText());
            s.setVille_p(vm.getText());
            s.setPhone_p(pm.getText());
            s.setMail_p(mm.getText());
            //------

            //------
            try {
                pss.ModifierPetSitter(p,s);
            } catch (SQLException ex) {
                Logger.getLogger(AfficherPSController.class.getName()).log(Level.SEVERE, null, ex);
            }
            //----
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_rp.fxml"));
            try {
                Parent root = loader.load();
                vboxp.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AfficherPSController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void ajouterAction(ActionEvent event) {
        //---
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
        try {
            Parent root = loader.load();
            vboxp.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjouterPetsitterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //-------------
    }

    @FXML
    private void homeAction(ActionEvent event) throws IOException {
        Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("accueilAdmin.fxml"));
                            Region root = (Region) loader.load();
                           AccueilAdminController ac1 = loader.<AccueilAdminController>getController();
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            Scene scene = new Scene(root);
                            //st.setMaximized(true);
                            //st.initStyle(StageStyle.UNDECORATED);
                            st.setScene(scene);
                            st.show();
    }
}
