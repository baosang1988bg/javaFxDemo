/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxdemo;

import DataSQL.SQLServerDataProvider;
import POJO.NhanVien;
import POJO.PhongBan;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author nguye
 */
public class DSNhanVienFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TableView<NhanVien> table;
    
    @FXML
    private TableColumn<NhanVien, Integer> maNVien;
    
    @FXML
    private TableColumn<NhanVien, String> hotenNV;
    
    @FXML
    private TableColumn<NhanVien, Float> luongNV;
    
    private ObservableList<NhanVien> NVList = FXCollections.observableArrayList();
    
    
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        try {
//            Connection conn = SQLServerDataProvider.open();
//            ResultSet rs = conn.createStatement().executeQuery("Select * from NhanVien");
//            while(rs.next()){
//                NVList.add(new NhanVien(rs.getInt("maPHG"), rs.getString("tenPHG")));
//            }
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        maPhong.setCellValueFactory(new PropertyValueFactory<PhongBan, Integer>("maPHG"));
//        tenPhong.setCellValueFactory(new PropertyValueFactory<PhongBan, String>("tenPHG"));
//        table.setItems(PBList);
    }    
    
}
