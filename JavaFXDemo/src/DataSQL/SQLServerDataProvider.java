 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSQL;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author nguye
 */
public class SQLServerDataProvider {

    private Connection conn;
    
    
    
    public static Connection open(){
        String strServer = "DESKTOP-VFL5C4C\\SANGPLS";
        String strDataBase = "QL_NHANVIEN";
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String conURL = "jdbc:sqlserver://" + strServer 
                    +   ":1433;databaseName=" + strDataBase
                    + ";user=sa; password=sa2012";
            conn = DriverManager.getConnection(conURL);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }
    
    public void close(){
        try {
            this.conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            Statement sm = conn.createStatement();
            rs= sm.executeQuery(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs;
    }

    
    
}
