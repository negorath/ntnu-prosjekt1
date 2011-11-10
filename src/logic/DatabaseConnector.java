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
        			User user = new User(name, phone, addresses.get(i));
        			users.addElement(user);
        		}
        	}
    	}while(users_rs.next());
    	address_rs.close();

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
    	ResultSet products_rs = stmt.executeQuery("SELECT name, description, price FROM products");
    	products_rs.first();
    	do{
    		String name = products_rs.getString(1);
    		String description = products_rs.getString(2);
    		String price = products_rs.getString(3);
    		products.addElement(new Product(name, description, Double.parseDouble(price)));
    	}while(products_rs.next());
    	products_rs.close();
    	
    	return products;
    }
    
    public static void newUser(User user)throws Exception{
    	ResultSet newUser_rs = stmt.executeQuery("SELECT COUNT(*) FROM addresses");
    	newUser_rs.first();
    	int address_id = Integer.parseInt(newUser_rs.getString(1)) + 1;
    	con.setAutoCommit(false);
    	int houseNumber = user.getAddress().getHouseNumber();
    	String street = user.getAddress().getStreet(), zipcode = user.getAddress().getZipcode(), city = user.getAddress().getCity();
    	stmt.executeUpdate("INSERT into addresses VALUES (" + address_id + ", '" +street +"', '"+ houseNumber +"', 'a', '"+ zipcode +"', '"+ city +"', 'NO')");
       	stmt.executeUpdate("INSERT into users (id, name, phone, address_id) VALUES (" + address_id + ", '" + user.getName() + "', '" + user.getPhone() + "', '"+ address_id + "')");
    	con.commit();
    	con.setAutoCommit(true);
    	newUser_rs.close();
    }
    
    public static DefaultListModel getOrders() throws Exception{
    	ResultSet orders_rs = stmt.executeQuery("SELECT user_id, ordered, due, delivered FROM orders");
    	DefaultListModel orders = new DefaultListModel();
    	do{
    		String user_id = orders_rs.getString(1);
    		String ordered = orders_rs.getString(2);
    		String due = orders_rs.getString(3);
    		String delivered = orders_rs.getString(4);
    		orders.addElement(new Order(Integer.parseInt(user_id), ordered, due, delivered));
    	}while(orders_rs.next());
    	return orders;
    }
    
    public static void newOrder(Order order){
    	try{
    		con.setAutoCommit(true);
    		stmt.executeUpdate("INSERT into orders VALUES(now(), 0, 0)");
    		con.commit();
    		con.setAutoCommit(false);
    	}catch(Exception e){
    		System.out.println("Failed to insert new order into database");
    		e.printStackTrace();
    	}
    }
    
    public static void edit(User oldUser, User newUser){
    	try{
    		String address_id, id;
    		ResultSet edit_rs = stmt.executeQuery("SELECT address_id FROM users WHERE name='" + oldUser.getName() + "' AND phone='" + oldUser.getPhone() + "'");
    		edit_rs.first();
    		address_id = edit_rs.getString(1);
    		edit_rs = stmt.executeQuery("SELECT id FROM users WHERE name='" + oldUser.getName() + "'AND phone ='" + oldUser.getPhone() + "'");
    		edit_rs.first();
    		id = edit_rs.getString(1);
    		edit_rs.close();
    		con.setAutoCommit(true);
    		//oppdaterer addressen til address_id
    		stmt.executeUpdate("UPDATE addresses SET street='" + newUser.getAddress().getStreet() + "', houseNumber='" + newUser.getAddress().getHouseNumber() + "', zipcode='" + newUser.getAddress().getZipcode() + "', city='" + newUser.getAddress().getCity() + "' WHERE id='" + address_id + "'");
    		//Oppdaterer user
    		stmt.executeUpdate("UPDATE users SET name='" + newUser.getName() + "', phone='" + newUser.getPhone() + "' WHERE id='" + id + "'");
    		con.setAutoCommit(false);
    	}catch(Exception e){
    		System.out.println("Failed to edit User");
    		e.printStackTrace();
    	}
    }
    
    public static void edit(Product product){
    	
    }
    
    public static void edit(Address address){
    	
    }
    
    public static void edit(Order order){
    	
    }

}