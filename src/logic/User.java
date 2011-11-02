package logic;
import java.sql.Connection;

public class User {
	
	public static Connection con;
	
	static public User create(String name, String phone, Address address) {
		
		// TODO: Insert into database
		
		User p = new User();
		p.name = name;
		p.phone = phone;
		p.address = address;
		
		return p;
	}
	/**Connect to the given database Connection
	 * 
	 * @param c
	 */
	public static void setConnection(Connection c) {
		con = c;
	}
	static public User retrieve(int id) {
		int[] l = {id};
		User[] list = retrieve(l);
		return list[0];
	}

	static public User[] retrieve(int[] id) {
		// TODO: Select from database
		
		User[] list = null;
		
		return list;
	}
	


	private int id;
	private String name;
	private String phone;
	private Address address;
	
	public User() { }

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
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	

	
}