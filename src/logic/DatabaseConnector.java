package logic;

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
    

    /**
     * 
     * @param phoneNumber
     * @return	User fra database med requested phoneNumber
     * @throws Exception
     */
    public static User getUser(int phoneNumber) throws Exception{
    	rs = stmt.executeQuery("SELECT name, phone, address_id FROM users WHERE phone='" + phoneNumber + "'");
    	String name = rs.getString(1);
    	String phone = rs.getString(2);
    	String address_id = rs.getString(3);
    	rs = stmt.executeQuery("SELECT street, houseNumber, zipcode, city FROM addressess WHERE id='"+address_id+"'");
    	Address address = new Address(rs.getString(1), Integer.parseInt(rs.getString(2)), rs.getString(3), rs.getString(4));
    	return new User(name, phone, address);
    }
    public static User getUser(String phoneNumber) throws Exception{
    	return getUser(Integer.parseInt(phoneNumber));
    }
    /**
     * 
     * @return arraylist med alle users fra database
     * @throws Exception
     */
    public static DefaultListModel getUsers() throws Exception{
    	ResultSet address_rs = stmt.executeQuery("SELECT id, street, houseNumber, zipcode, city FROM addresses");
    	address_rs.first();
    	ArrayList<Address> addresses = new ArrayList<Address>();
    	DefaultListModel users = new DefaultListModel();
    	do{
    		String id = address_rs.getString(1);
    		String street = address_rs.getString(2);
    		String houseNumber = address_rs.getString(3);
    		String zipcode = address_rs.getString(4);
    		String city = address_rs.getString(5);
    		Address address = new Address(street, Integer.parseInt(houseNumber), zipcode, city);
    		address.setId(Integer.parseInt(id));
    		addresses.add(address);
    	}while(address_rs.next());
    	address_rs.close();
    	ResultSet users_rs = stmt.executeQuery("SELECT name, phone, address_id FROM users");
    	users_rs.first();
    	do{
        	String name = users_rs.getString(1);
        	String phone = users_rs.getString(2);
        	String address_id = users_rs.getString(3); 
        	//finding address from array with id equal to address_id
        	for(int i = 0; i<addresses.size(); i++){
        		if(addresses.get(i).getId() == Integer.parseInt(address_id)){
//        			users.addElement(new User(name, phone, addresses.get(i)));    
        			users.addElement(name + " " + phone);
        			System.out.println(name + " " + phone);
        		}
        	}
    	}while(users_rs.next());

    	return users;
    }
    /**
     * 
     * @param id
     * @return productet med angitt id i databasen
     * @throws Exception
     */
    public static Product getProduct(String id) throws Exception{
    	rs = stmt.executeQuery("SELECT name, description, price FROM products WHERE name='"+id+"'");
    	String name = rs.getString(1);
    	String description = rs.getString(2);
    	String price = rs.getString(3);
    	System.out.println(name + description + price);
    	return new Product(name, description, Double.parseDouble(price));
    }
    /**
     * 
     * @return alle produkter fra databasen
     * @throws Exception
     */
    public static DefaultListModel getProducts() throws Exception{
    	DefaultListModel products = new DefaultListModel();
    	rs = stmt.executeQuery("SELECT name, description, price FROM products");
    	while(rs.next()){
    		String name = rs.getString(1);
    		String description = rs.getString(2);
    		String price = rs.getString(3);
    		products.addElement(new Product(name, description, Double.parseDouble(price)));
    	}
    	
    	return products;
    }
    public static void newUser(User user)throws Exception{
    	con.setAutoCommit(false);
    	stmt.executeUpdate("INSERT into addresses VALUES(" + user.getAddress().getStreet() + "," + user.getAddress().getHouseNumber() + "," + user.getAddress().getZipcode() + "," + user.getAddress().getCity() + ")");
    	String s = stmt.executeQuery("SELECT LAST_INSERT_ID() FROM addresses").getString(1);
    	stmt.executeUpdate("INSERT into users VALUES(" + user.getName()+ "," + user.getPhone() + ", "+s + ")");
    	System.out.println("INSERT into users VALUES(" + user.getName()+ "," + user.getPhone() + ", s)");
    	con.commit();
    	con.setAutoCommit(true);
    }

}