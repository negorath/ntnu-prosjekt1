package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import localData.ConfigSample;


/** Klassen som setter opp koblingen til databasen
 *  Bruk getConnection() for å få en kobling til databasen
 */
public class DatabaseConnector {

	
	private static Connection con;
	
	/**
	 * Kall denne metoden for å koble til databasen som definert i localData/ConfigSample.java
	 */
    public static void initialize() {
    	con = null;
       
        
        String url = "jdbc:mysql:" + ConfigSample.DBHost + ":" + ConfigSample.DBport + "/" + ConfigSample.DBName;
        String user = ConfigSample.DBUsername;
        String password = ConfigSample.DBPassword;

        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        try {
        	
            con = DriverManager.getConnection(url, user, password);
//            st = con.createStatement();
//            rs = st.executeQuery("SELECT VERSION()");
//
//            if (rs.next()) {
//                System.out.println(rs.getString(1));
            System.out.println("Connected to " + ConfigSample.DBName);
            
        } catch (SQLException ex) {
//            Logger lgr = Logger.getLogger(DatabaseConnector.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        	ex.printStackTrace();

        }
        giveConnecetion();
        
        
        
    }
    
    public static void giveConnecetion() {
    	Address.setConnection(con);
    	Order.setConnection(con);
    	Product.setConnection(con);
    	User.setConnection(con);
    
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
    
    /**Bruk dette objektet for å endre på databasen
     *
     **/
    
    public Connection getConnection() {
    	return con;
    }
}