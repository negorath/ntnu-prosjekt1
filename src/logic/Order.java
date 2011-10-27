package logic;
import java.sql.Connection;

class Order {
	
	private int id;
	private int userId;
	private Product[] products;
	
	public static Connection con;
	
	/**Connect to the given database Connection
	 * 
	 * @param c
	 */
	public static void setConnection(Connection c) {
		con = c;
	}
	
	
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the products
	 */
	public Product[] getProducts() {
		return products;
	}
	/**
	 * @param products the products to set
	 */
	public void setProducts(Product[] products) {
		this.products = products;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	
	
}