/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxdemo;

import DAO.PhongBanDAO;
import DataSQL.SQLServerDataProvider;
import POJO.PhongBan;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nguye
 */
public class CenterFXMLController implements Initializable {

    @FXML
    private TableView<PhongBan> table;
    
    @FXML 
    private TableColumn<PhongBan, Integer> maPhong;
    
    @FXML
    private TableColumn<PhongBan, String> tenPhong;
    
    private ObservableList<PhongBan> PBList = FXCollections.observableArrayList();
    
    @FXML
    private TextField txt_maPHG;
    
    @FXML
    private TextField txt_tenPHG;
    
    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void Back_Menu(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader =  new FXMLLoader();
        loader.setLocation(getClass().getResource("MenuFXML.fxml"));
        Parent back_Menu = loader.load();
        Scene scene = new Scene(back_Menu);
        stage.setScene(scene);
        
    }
    
    @FXML
    private void notyetfinised_view(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader =  new FXMLLoader();
        loader.setLocation(getClass().getResource("notYetFinised.fxml"));
        Parent view_notyet = loader.load();
        stage.setResizable(false);
        Scene scene = new Scene(view_notyet);
        stage.setScene(scene);
        
    }
    
    @FXML
    private void View_selected(MouseEvent event){

    }
    
    public void clicked_PB(PhongBan pb){
        
    }
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            Connection conn = SQLServerDataProvider.open();
            ResultSet rs = conn.createStatement().executeQuery("Select * from PhongBan");
            while(rs.next()){
                PBList.add(new PhongBan(rs.getInt("maPHG"), rs.getString("tenPHG")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        maPhong.setCellValueFactory(new PropertyValueFactory<PhongBan, Integer>("maPHG"));
        tenPhong.setCellValueFactory(new PropertyValueFactory<PhongBan, String>("tenPHG"));
        table.setItems(PBList);
    }    
    
}
