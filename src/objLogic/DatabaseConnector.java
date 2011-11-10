package objLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import localData.ConfigSample;


/** Klassen som setter opp koblingen til databasen
 *  Bruk getConnection() for å få en kobling til databasen
 */
public class DatabaseConnector{	
	
	public DatabaseConnector(){
		
	}
    private static Connection con = null; // connection object
    private static Statement stmt = null; // statement object
    private static ResultSet rs = null; // result set object
    
    public static void initialize(){
		try {
			con = getConnection();
			stmt = con.createStatement();
			con.setAutoCommit(true);
			System.out.println("Connected to " + ConfigSample.DBName);
		}catch(Exception e){
			System.out.println("klarer ikke laste inn databasen");
		}
    }
	public static Connection getConnection() throws Exception {

        String url = "jdbc:mysql:" + ConfigSample.DBHost + ":" + ConfigSample.DBport + "/" + ConfigSample.DBName;
        String user = ConfigSample.DBUsername;
        String password = ConfigSample.DBPassword;
        
        try{
        	Class.forName("com.mysql.jdbc.Driver");
        	System.out.println("Driver loaded");        	
        }catch(Exception e){
        	System.out.println("Kunne ikke laste inn driver");
        }
	    return DriverManager.getConnection(url, user, password);
	  }
    public void closeConnection() {
    	 try {
             if (con != null) {
                 con.close();
             }
         } catch (SQLException ex) {
             Logger lgr = Logger.getLogger(DatabaseConnector.class.getName());
             lgr.log(Level.WARNING, ex.getMessage(), ex);
         }
    }
    

 
    
    
 
   
    
   
  
  

}