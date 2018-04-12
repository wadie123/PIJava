/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import org.controlsfx.control.table.TableFilter;
import pidev.Zanimaux.Services.PetSitterService;
import pidev.Zanimaux.entities.PetSitter;

/**
 * FXML Controller class
 *
 * @author I eat ass
 */
public class ListPSController implements Initializable {
    PetSitterService pss= new PetSitterService();
    private ObservableList<PetSitter> masterData = FXCollections.observableArrayList();

    @FXML
    private TableView<PetSitter> userTable;
    @FXML
    private TableColumn<PetSitter, String> nom;
    @FXML
    private TableColumn<PetSitter, String> adr;
    @FXML
    private TableColumn<PetSitter, String> ville;
    @FXML
    private TableColumn<PetSitter, String> tel;
    @FXML
    private TableColumn<PetSitter, String> mail;
    @FXML
    private TableColumn<PetSitter, String> img;
    @FXML
    private TextField filterNom;
    @FXML
    private TextField filterVille;
    @FXML
    private Button home;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableFilter filter = new TableFilter(userTable);
        List<PetSitter> users= null;
        try {
            users = pss.RetournerPetSitters();
        } catch (SQLException ex) {
            Logger.getLogger(ListPSController.class.getName()).log(Level.SEVERE, null, ex);
        }
        masterData.addAll(users);
        nom.setCellValueFactory(new PropertyValueFactory<PetSitter, String>("nom_p"));
        mail.setCellValueFactory(new PropertyValueFactory<PetSitter, String>("mail_p"));
        adr.setCellValueFactory(new PropertyValueFactory<PetSitter, String>("adress_p"));
        ville.setCellValueFactory(new PropertyValueFactory<PetSitter, String>("ville_p"));
        tel.setCellValueFactory(new PropertyValueFactory<PetSitter, String>("phone_p"));

        //userTable.getItems().setAll(masterData);
        
        FilteredList<PetSitter> filteredData = new FilteredList<>(masterData, p -> true);
               
        
        filterNom.textProperty().addListener((obsVal, oldValue, newValue) -> {
            filteredData.setPredicate(ps -> ps.getNom_p().toLowerCase().contains(filterNom.getText().toLowerCase())                
               && ps.getVille_p().toLowerCase().contains(filterVille.getText().toLowerCase())
               //&& user.getGenre().contains(filterGender.getSelectionModel().getSelectedItem().getValue())
            );
        });

        filterVille.textProperty().addListener((obsVal, oldValue, newValue) -> {
            filteredData.setPredicate(ps -> ps.getNom_p().toLowerCase().contains(filterNom.getText().toLowerCase()) 
               //&& user.getGenre().contains(filterGender.getSelectionModel().getSelectedItem().getValue())
               && ps.getVille_p().toLowerCase().contains(filterVille.getText().toLowerCase())
            );
        });
        SortedList<PetSitter> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(userTable.comparatorProperty());
        
        userTable.setItems(sortedData);
    }    

    @FXML
    private void home(ActionEvent event) throws IOException {
        Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("accueil.fxml"));
                            Region root = (Region) loader.load();
                           AccueilController ac1 = loader.<AccueilController>getController();
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            Scene scene = new Scene(root);
                            //st.setMaximized(true);
                            //st.initStyle(StageStyle.UNDECORATED);
                            st.setScene(scene);
                            st.show();
    }
    
}
