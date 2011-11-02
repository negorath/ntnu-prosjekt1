package logic;
import java.sql.Connection;

public class Product {
	public static Connection con;

	static public Product create(String name, String description, double price) {
		
		// TODO: Insert into database
		
		Product p = new Product();
		p.name = name;
		p.description = description;
		p.price = price;
		
		return p;
	}
	
	public static void setConnection(Connection c) {
		con = c;
	}
	static public Product retrieve(int id) {
		int[] l = {id};
		Product[] list = retrieve(l);
		return list[0];
	}

	static public Product[] retrieve(int[] id) {
		// TODO: Select from database
		
		Product[] list = null;
		
		return list;
	}
	


	private int id;
	private String name;
	private String description;
	private double price;
	
	private Product() { }

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	
	
}