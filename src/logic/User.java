package logic;
import java.sql.Connection;

public class User{
	
	private String name;
	private String phone;
	private Address address;
	private String userID;
	private DatabaseConnector con;
	public User(String name, String phone, Address address){
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	/**
	 * sets the user
	 * @param id
	 */
	public void setUserId(String id){
		this.userID = id;
	}
	/**
	 * gets the user
	 * @return user
	 */
	public String getId(){
		return this.userID;
	}
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
	 * returns a string representation of the user.
	 */
	public String toString(){
		String result;
		result = getPhone() + ": " + getName();
		return result;
	}
}