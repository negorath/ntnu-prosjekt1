package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import localData.ConfigSample;

public class DatabaseConnector {

	
	private static Connection con;
	
    public static void initialize() {

       con = null;
       
        
        String url = "jdbc:mysql:" + ConfigSample.DBHost + ":" + ConfigSample.DBport + "/" + ConfigSample.DBName;
        String user = ConfigSample.DBUsername;
        String password = ConfigSample.DBPassword;

        try {
            con = DriverManager.getConnection(url, user, password);
//            st = con.createStatement();
//            rs = st.executeQuery("SELECT VERSION()");
//
//            if (rs.next()) {
//                System.out.println(rs.getString(1));
            
        } catch (SQLException ex) {
//            Logger lgr = Logger.getLogger(DatabaseConnector.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
        
    }
    public static void closeConnection() {
    	 try {
             if (con != null) {
                 con.close();
             }
//             if (rs != null) {
//            	 rs.close();
//             }
//             if (st != null) {
//            	 st.close();
//             }

         } catch (SQLException ex) {
             Logger lgr = Logger.getLogger(DatabaseConnector.class.getName());
             lgr.log(Level.WARNING, ex.getMessage(), ex);
         }
    }
    
    public Connection getConnection() {
    	return con;
    }
}