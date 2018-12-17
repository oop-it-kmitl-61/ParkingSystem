/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author fluke
 */
public class MyConnection {

    static String user = "root";
    static String pass = "1234";
    static String databaseurl = "127.0.0.1/parking";
    static int count = 0;
    public void setUser(String user) {
	this.user = user;
    }

    public void setPass(String pass) {
	this.pass = pass;
    }

    public void setDatabaseurl(String databaseurl) {
	this.databaseurl = databaseurl;
    }
    
    public MyConnection() {
    }
    
    
    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://"+databaseurl, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
	    if(count==0){
		JOptionPane.showMessageDialog(null, "Please check database infomation");
		count = 1;
	    }
        }
        
        return con;
    }
    
}
