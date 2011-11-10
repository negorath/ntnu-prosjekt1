package objLogic;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import logic.Address;



import com.mysql.jdbc.ResultSet;


public class User{
	
	private String name;
	private String phone;
	private Address address;
	private java.sql.Connection con;
	public User(String name, String phone, Address address){
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	public void add(User user) throws SQLException{
		
		    	
		
	}
	
	//Kode tatt fra DatabaseConnector, her er det den skal være
	public User retrieve(String phoneNumber) throws Exception{
		Statement stmt = con.createStatement();
		
    	ResultSet getUser_rs = stmt.executeQuery("SELECT name, phone, address_id FROM users WHERE phone='" + phoneNumber + "'");
    	getUser_rs.first();
    	String name = getUser_rs.getString(1);
    	String phone = getUser_rs.getString(2);
    	String address_id = getUser_rs.getString(3);
    	getUser_rs.close();
    	
    	ResultSet getAddress_rs = stmt.executeQuery("SELECT street, houseNumber, zipcode, city FROM addresses WHERE id='"+address_id+"'");
    	getAddress_rs.first();
    	Address address = new Address(getAddress_rs.getString(1), Integer.parseInt(getAddress_rs.getString(2)), getAddress_rs.getString(3), getAddress_rs.getString(4));
    	getAddress_rs.close();
    	return new User(name, phone, address);
		
		
	}
//	public User retrive(int phoneNumber) throws Exception{
//		
//	}
	
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
	
	public String toString(){
		String result;
		result = getPhone() + ": " + getName();
		return result;
	}
}