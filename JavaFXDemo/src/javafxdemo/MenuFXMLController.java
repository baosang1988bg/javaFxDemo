/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxdemo;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nguye
 */
public class MenuFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private BorderPane bp;
    
    @FXML
    private ImageView img;
    
    @FXML
    private MenuBar menuBar;
    
    @FXML
    private Menu mennuFile;
    
    @FXML
    private MenuItem menuClose;
    
    @FXML
    private void center_View(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CenterFXML.fxml"));
        Parent centerView = loader.load();
        Scene scene = new Scene(centerView);
        stage.setScene(scene);
    }
    
    @FXML
    private void close_menu(ActionEvent event){
        System.exit(0);
    }
    
    @FXML
    private void ChooseImageView(ActionEvent event){
        Stage stage = (Stage)bp.getScene().getWindow();
        FileChooser fc = new FileChooser();
        fc.setTitle("Choose a image");
        FileChooser.ExtensionFilter imageFilter = new 
            FileChooser.ExtensionFilter("Image Files", "*.jpg");
        fc.getExtensionFilters().add(imageFilter);
        File file = fc.showOpenDialog(stage);
        if(file!=null){
            Image images = new Image(file.toURI().toString(),550, 350, false, true);
            img.setImage(images);
        }   
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
