/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataSQL.SQLServerDataProvider;
import POJO.PhongBan;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class PhongBanDAO {
    public static ArrayList<PhongBan> layDSPB(){
        ArrayList<PhongBan> dsPB = new ArrayList<PhongBan>();
        try {
            String sql = "SELECT * FROM PhongBan";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()){
                PhongBan pb = new PhongBan();
                pb.setMaPHG(rs.getInt("MaPHG"));
                pb.setTenPHG(rs.getString("TenPHG"));
                dsPB.add(pb);
            }
            provider.close();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsPB;
    }
}
