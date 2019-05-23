/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxdemo;

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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author nguye
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML 
    private TextField txt_user;
    
    @FXML
    private PasswordField txt_pass;
    
    
    @FXML
    private void Menu_View(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MenuFXML.fxml"));
        Parent centerView = loader.load();
        if(txt_user.getText().equals("admin")){
            if(txt_pass.getText().equals("admin")){
                stage.setResizable(true);
                Scene scene = new Scene(centerView);
                stage.setScene(scene);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Lỗi");
                alert.setContentText("PassWord không chính xác");
                alert.show();
                txt_pass.clear();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Lỗi");
            alert.setContentText("User hoặc PassWord không chính xác");
            alert.show();
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
