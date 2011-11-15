package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import localData.Config;


/** Klassen som setter opp koblingen til databasen
 *  Bruk getConnection() for å få en kobling til databasen
 */
public class DatabaseConnector{	
	
	public DatabaseConnector(){	}
    private static Connection con = null; // connection object
    private static Statement stmt = null; // statement object
    
    public static void initialize(){
		try {
			con = getConnection();
			stmt = con.createStatement();
			con.setAutoCommit(true);
			System.out.println("Connected to " + Config.DBName);
		}catch(Exception e){
			System.out.println("klarer ikke laste inn databasen");
		}
		Address.setConnection(con);
    }
	public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql:" + Config.DBHost + ":" + Config.DBport + "/" + Config.DBName;
        String user = Config.DBUsername;
        String password = Config.DBPassword;
        
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
    public static User getUser(String phoneNumber) throws Exception{
    	String sql = "SELECT name, phone, address_id, id FROM users WHERE phone='" + phoneNumber + "'";
    	ResultSet getUser_rs = stmt.executeQuery(sql);
    	if (getUser_rs.first() == false) {
    		return null;
    	}
    	String name = getUser_rs.getString(1);
    	String phone = getUser_rs.getString(2);
    	String address_id = getUser_rs.getString(3);
    	String id = getUser_rs.getString(4);
    	getUser_rs.close();
    	
    	ResultSet getAddress_rs = stmt.executeQuery("SELECT street, houseNumber, zipcode, city, id FROM addresses WHERE id='"+address_id+"'");
    	getAddress_rs.first();
    	Address address = new Address(getAddress_rs.getInt(5), getAddress_rs.getString(1), Integer.parseInt(getAddress_rs.getString(2)), getAddress_rs.getString(3), getAddress_rs.getString(4));
    	getAddress_rs.close();
    	User user = new User(name, phone, address);
    	user.setUserId(id);
    	return user;
    }
    /**
     * 
     * @param Userid from database
     * @return user from database
     * @throws Exception
     */
    public static String getUser(int id) throws Exception{
    	ResultSet getUser_rs = stmt.executeQuery("SELECT name FROM users WHERE id='" + id + "'");
    	getUser_rs.first();
    	String s = getUser_rs.getString(1);
    	getUser_rs.close();
    	return s;
    }

    /**
     * 
     * @return arraylist med alle users fra database
     * @throws Exception
     */
    public static DefaultListModel getUsers() throws Exception{
    	ResultSet address_rs = stmt.executeQuery("SELECT id, street, houseNumber, zipcode, city FROM addresses");
    	DefaultListModel users = new DefaultListModel();
    	address_rs.first();
    	ArrayList<Address> addresses = new ArrayList<Address>();    	
    	do{
    		int id = address_rs.getInt(1);
    		String street = address_rs.getString(2);
    		String houseNumber = address_rs.getString(3);
    		String zipcode = address_rs.getString(4);
    		String city = address_rs.getString(5);
    		Address address = new Address(id, street, Integer.parseInt(houseNumber), zipcode, city);
    		addresses.add(address);
    	}while(address_rs.next());
    	address_rs.close();
    	ResultSet users_rs = stmt.executeQuery("SELECT name, phone, address_id, id FROM users");
    	users_rs.first();
    	do{
        	String name = users_rs.getString(1);
        	String phone = users_rs.getString(2);
        	String address_id = users_rs.getString(3);
        	String id = users_rs.getString(4);
        	//finding address from array with id equal to address_id
        	for(int i = 0; i<addresses.size(); i++){
        		if(addresses.get(i).getId() == Integer.parseInt(address_id)){
        			User user = new User(name, phone, addresses.get(i));
        			user.setUserId(id);
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
    	ResultSet getP_rs = stmt.executeQuery("SELECT name, description, price FROM products WHERE id='"+id+"'");
    	getP_rs.first();
    	String name = getP_rs.getString(1);
    	String description = getP_rs.getString(2);
    	String price = getP_rs.getString(3);
    	Product p = new Product(name, description, Double.parseDouble(price));
    	return p;
    }
    /**
     * 
     * @return alle produkter fra databasen
     * @throws Exception
     */
    public static DefaultListModel getProducts() throws Exception{
    	DefaultListModel products = new DefaultListModel();
    	ResultSet products_rs = stmt.executeQuery("SELECT name, description, price, id FROM products");
    	products_rs.first();
    	do{
    		String name = products_rs.getString(1);
    		String description = products_rs.getString(2);
    		String price = products_rs.getString(3);
    		String id = products_rs.getString(4);
    		Product p = new Product(name, description, Double.parseDouble(price));
    		p.setId(id);
    		products.addElement(p);
    	}while(products_rs.next());
    	products_rs.close();
    	
    	return products;
    }
    
    public static void newUser(User user)throws Exception{
    	ResultSet newUser_rs = stmt.executeQuery("SELECT COUNT(*) FROM addresses");
    	newUser_rs.first();
    	con.setAutoCommit(true);
    	int address_id = Integer.parseInt(newUser_rs.getString(1)) + 1;
    	int houseNumber = user.getAddress().getHouseNumber();
    	String street = user.getAddress().getStreet(), zipcode = user.getAddress().getZipcode(), city = user.getAddress().getCity();
    	stmt.executeUpdate("INSERT into addresses VALUES (" + address_id + ", '" +street +"', '"+ houseNumber +"', 'a', '"+ zipcode +"', '"+ city +"', 'NO')");
       	stmt.executeUpdate("INSERT into users (id, name, phone, address_id) VALUES (" + address_id + ", '" + user.getName() + "', '" + user.getPhone() + "', '"+ address_id + "')");
    	newUser_rs.close();
    	con.setAutoCommit(false);
    }
    
    public static DefaultListModel getOrders(String action) throws Exception{
    	String sql = "SELECT user_id, ordered, due, delivered, id, products FROM orders WHERE ";
    	if (action.equals("due")) {
    		sql += "due IS NULL ORDER BY ordered";
    	} else if(action.equals("deliver")) {
    		sql += "due IS NOT NULL ORDER BY due";
    	} else if(action.equals("delivered")) {
    		sql += "delivered IS NOT NULL ORDER BY delivered";
    	} else {
    		throw new Exception("Action must be one of due, deliver or delivered.");
    	}
    	
    	ResultSet orders_rs = stmt.executeQuery(sql);
    	DefaultListModel orders = new DefaultListModel();
    	if(orders_rs.first() == false){
    		return orders;
    	}
    	do{
    		String user_id = orders_rs.getString(1);
    		String ordered = orders_rs.getString(2);
    		String due = orders_rs.getString(3);
    		String delivered = orders_rs.getString(4);
    		String id = orders_rs.getString(5);
    		String products = orders_rs.getString(6);
    		Order o =  new Order(user_id);
    		o.createFoodList(products);
    		o.setId(id);
    		o.setDue(due);
    		o.setDelivered(delivered);
    		orders.addElement(o);
    	}while(orders_rs.next());
    	orders_rs.close();
    	return orders;
    }
    
    public static void newOrder(Order order){
    	try{
    		stmt.executeUpdate("INSERT INTO orders SET user_id = '" + order.getUserId() + "', due = NULL, delivered = NULL, products = '" + order.getProducts() + "'");
    		con.setAutoCommit(false);
    	}catch(Exception e){
    		System.out.println("Failed to insert new order into database");
    		e.printStackTrace();
    	}
    }
    
    public static void newProduct(Product product){
    	try{
    		con.setAutoCommit(true);
    		ResultSet newProduct_rs = stmt.executeQuery("SELECT COUNT(*) FROM products");
    		newProduct_rs.first();
    		int id = Integer.parseInt(newProduct_rs.getString(1)) + 1;
    		stmt.executeUpdate("INSERT INTO products VALUES (" + id + ", '" + product.getName() + "', '" + product.getDescription() + "', '" + product.getPrice() + "')");
			con.setAutoCommit(false);
			newProduct_rs.close();
    	}catch(Exception e){
    		System.out.println("Failed to insert new Product into database");
    		e.printStackTrace();
    	}
    }
    
    public static void deleteUser(User user){
    	try{
    		ResultSet deleteUser_rs = stmt.executeQuery("SELECT id, address_id from users WHERE name='" + user.getName() + "' AND phone='" + user.getPhone() + "'");
    		deleteUser_rs.first();
    		String id = deleteUser_rs.getString(1);
    		String address_id = deleteUser_rs.getString(2);
    		con.setAutoCommit(true);
    		stmt.executeUpdate("DELETE from users WHERE id='" + id + "'");
    		stmt.executeUpdate("DELETE from addresses WHERE id='" + address_id + "'");
    		con.setAutoCommit(false);
    		deleteUser_rs.close();
    	}catch(Exception e){
    		System.out.println("Failed to delete User from database");
    		e.printStackTrace();
    	}
    }
    
    public static void deleteProduct(Product product){
    	try{
    		ResultSet deleteProduct_rs = stmt.executeQuery("SELECT id from products WHERE name='" + product.getName() + "' AND description='" + product.getDescription() + "' AND price='" + product.getPrice() + "'");
    		deleteProduct_rs.first();
    		int id = Integer.parseInt(deleteProduct_rs.getString(1));
    		con.setAutoCommit(true);
    		stmt.executeUpdate("DELETE from products WHERE id='" + id + "'");
    		con.setAutoCommit(false);
    		deleteProduct_rs.close();
    	}catch(Exception e){
    		System.out.println("Failed to delete Product from database");
    		e.printStackTrace();
    	}
    }
    
    public static void deleteOrder(Order order){
    	try{
    		con.setAutoCommit(true);
    		stmt.executeUpdate("DELETE from orders WHERE id='" + order.getId() + "'");
    		con.setAutoCommit(false);
    	}catch(Exception e){
    		System.out.println("Failed to delete Order from database");
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
    
    
    public static void edit(Product oldProduct, Product newProduct){
    	try{
    		ResultSet edit = stmt.executeQuery("SELECT id from products WHERE name='" + oldProduct.getName() + "' AND description='" + oldProduct.getDescription() + "' AND price='" + oldProduct.getPrice() + "'");
    		edit.first();
    		String id = edit.getString(1);
    		edit.close();
    		con.setAutoCommit(true);
    		stmt.executeUpdate("UPDATE products SET name='" + newProduct.getName() + "', description='" + newProduct.getDescription() + "', price='" + newProduct.getPrice() + "' WHERE id='" + id  + "'");
    		con.setAutoCommit(false);
    	}catch(Exception e){
    		System.out.println("Failed to edit Product");
    		e.printStackTrace();
    	}
    }
    
    public static void edit(String id){
    	try{
    		con.setAutoCommit(true);
    		stmt.executeUpdate("UPDATE orders SET due=now() WHERE id='" + id + "'");
    		con.setAutoCommit(false);
    	}catch(Exception e){
    		System.out.println("Failed to edit order in database");
    	}
    }
    public static void notFinished(String a){
    	try {
			con.setAutoCommit(true);
			stmt.executeUpdate("UPDATE orders SET due = NULL WHERE id='" + a + "'");
			con.setAutoCommit(false);
		} catch (Exception e) {
			System.out.println("Failed to set the order to 'not finished'");
		}
    }
	public static Address getAddressFromUser(int user_id) {
		try {
			String sql = "SELECT a.id, a.street, a.houseNumber, a.zipcode, a.city FROM users AS u, addresses AS a WHERE u.address_id = a.id AND u.id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, user_id);
			ResultSet rs = st.executeQuery();
			rs.first();
			Address ad = new Address(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
			rs.close();
			return ad;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Order getOrder(String s) throws Exception{
		if(s.length() <= 0){
			throw new Exception("k");
		}
		String stringID = "";
		boolean b = true;
		for(int i = 0; i<s.length(); i++){
			if((int)s.charAt(i) == 32){
				b = false;
			}
			if(b){
				stringID += s.charAt(i);				
			}
		}
		int id = Integer.parseInt(stringID);
		ResultSet getOrderRs = stmt.executeQuery("SELECT id, user_id, ordered, due, delivered, products FROM orders WHERE id ='" + id + "'");
		getOrderRs.first();
		String i = getOrderRs.getString(1);
		String userID = getOrderRs.getString(2);
		String ordered = getOrderRs.getString(3);
		String due = getOrderRs.getString(4);
		String delivered = getOrderRs.getString(5);
		String products = getOrderRs.getString(6);
		Order o = new Order(userID);
		o.setDue(due);
		o.setId(i);
		o.setDelivered(delivered);
		o.createFoodList(products);
		return o;
	}
}