package logic;
import java.sql.Connection;

public class User{
	
	/**
	 * @uml.property  name="name"
	 */
	private String name;
	/**
	 * @uml.property  name="phone"
	 */
	private String phone;
	/**
	 * @uml.property  name="address"
	 * @uml.associationEnd  
	 */
	private Address address;
	/**
	 * @uml.property  name="userID"
	 */
	private String userID;
	/**
	 * @uml.property  name="con"
	 * @uml.associationEnd  readOnly="true"
	 */
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
	 * @return  the name
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name  the name to set
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return  the phone
	 * @uml.property  name="phone"
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone  the phone to set
	 * @uml.property  name="phone"
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return  the address
	 * @uml.property  name="address"
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address  the address to set
	 * @uml.property  name="address"
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