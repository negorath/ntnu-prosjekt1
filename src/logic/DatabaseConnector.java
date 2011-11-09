package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
	public static Connection getConnection() throws Exception {

        String url = "jdbc:mysql:" + ConfigSample.DBHost + ":" + ConfigSample.DBport + "/" + ConfigSample.DBName;
        String user = ConfigSample.DBUsername;
        String password = ConfigSample.DBPassword;
	    // load the Oracle JDBC Driver
        
        try{
        	Class.forName("com.mysql.jdbc.Driver");
        	System.out.println("Driver loaded");        	
        }catch(Exception e){
        	System.out.println("Kunne ikke laste inn driver");
        }
	    // define database connection parameters
	    System.out.println("Connected to " + ConfigSample.DBName);
	    
		try {
			con.createStatement();
			con.commit();
			con.setAutoCommit(true);
		}catch(Exception e){
			System.out.println("klarer ikke laste inn database");
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
    

    /**
     * 
     * @param phoneNumber
     * @return	User fra database med requested phoneNumber
     * @throws Exception
     */
    public User getUser(int phoneNumber) throws Exception{
    	rs = stmt.executeQuery("SELECT name, phone, address_id FROM users WHERE phone='" + phoneNumber + "'");
    	String name = rs.getString(1);
    	String phone = rs.getString(2);
    	String address_id = rs.getString(3);
    	rs = stmt.executeQuery("SELECT street, houseNumber, zipcode, city FROM addressess WHERE id='"+address_id+"'");
    	Address address = new Address(rs.getString(1), Integer.parseInt(rs.getString(2)), rs.getString(3), rs.getString(4));
    	return new User(name, phone, address);
    }
    public User getUser(String phoneNumber) throws Exception{
    	return getUser(Integer.parseInt(phoneNumber));
    }
    /**
     * 
     * @return arraylist med alle users fra database
     * @throws Exception
     */
    public ArrayList<User> getUsers() throws Exception{
    	ArrayList<User> users = new ArrayList<User>();
    	rs = stmt.executeQuery("SELECT name, phone, address_id FROM users");
    	while(rs.next()){
        	String name = rs.getString(1);
        	String phone = rs.getString(2);
        	String address_id = rs.getString(3);
    		rs = stmt.executeQuery("SELECT street, houseNumber, zipcode, city FROM addressess WHERE id='"+address_id+"'");
        	Address address = new Address(rs.getString(1), Integer.parseInt(rs.getString(2)), rs.getString(3), rs.getString(4));
        	users.add(new User(name, phone, address));
    	}
    	return users;
    }
}