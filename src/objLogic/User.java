package objLogic;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
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
	 * @uml.property  name="con"
	 */
	private Connection con;
	
	
	public User() { 
		
	}
	
	public User(String name, String phone, Address address){
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	//Kode tatt fra DatabaseConnector, her er det den skal være
	public User retrieve(String phoneNumber) throws Exception{
		Statement stmt = con.createStatement();
		
    	ResultSet getUser_rs = stmt.executeQuery("SELECT * FROM users WHERE phone='" + phoneNumber + "'");
    	if (getUser_rs.next()) { //if it is not empty
    		String name = getUser_rs.getString("name");
        	String phone = getUser_rs.getString("phone");
        	String address_id = getUser_rs.getString("address_id");
        	getUser_rs.close();
        	
        	
        	ResultSet adrData = stmt.executeQuery("SELECT * FROM addresses WHERE id='" + address_id + "'");
        	Address adr; //address
        	if (adrData.first()) {
        		adr = new Address();
        		adr.setCountry(adrData.getString("country"));
        		adr.setCity(adrData.getString("city"));
        		adr.setZipcode(adrData.getString("zipcode"));
        		adr.setStreet(adrData.getString("street"));
        		adr.setHouseNumber(adrData.getInt("houseNumber"));
        		adr.setHouseLetter(adrData.getString("houseLetter"));
        	}
        	else {
        		address = null;
        	}
        	return new User(name, phone, address);
        	
    	} else return null;
    	
		
	}


	/**
	 * @return  the name
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name  the name to set
	 * @throws SQLException
	 * @uml.property  name="name"
	 */
	public void setName(String name) throws SQLException {
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
	 * @throws SQLException
	 * @uml.property  name="phone"
	 */
	public void setPhone(String phone) throws SQLException {
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
	 * @param address the address to set
	 * @throws SQLException 
	 */
	public void setAddress(Address address) throws SQLException {
		
		
	}
	
	public String toString(){
		String result;
		result = getPhone() + ": " + getName();
		return result;
	}
	/**Synkroniserer dette objektet med databasen. Hvis det ikke eksisterer fra før, så opprettes det. Hvis det eksisterer fra før så blir alle feltene overskrevet.
	 * 
	 * 
	 * 
	 * @throws SQLException
	 */
	public void sync() throws SQLException{
		
		Statement stmt = con.createStatement();
		boolean existsInDatabase = stmt.execute("SELECT phone WHERE phone='" + this.getPhone() + "'");
		
		//If this person already exist, just update the specific record
		if (!existsInDatabase) {
			
			stmt.execute(	"UPDATE users" +
							"SET address_id='" + address.getId() +"', name='" + this.getName() + "', " +
							"WHERE phone='" + this.getPhone());
		}
		else { //If this person does not exist, create them
			stmt.execute(	"INSERT INTO users VALUES (" + 
							this.getName() + ", " + 
							this.getPhone() + ", " + 
							this.getAddress().getId() + ")");
		}
		address.sync();
	}
	/** Delete any record of this user in the database, along with it's address
	 * 
	 * @throws SQLException
	 */
	public void delete() throws SQLException{
		this.sync();
		Statement stmt = con.createStatement();
		
		stmt.execute(	"DELETE from users " +
						"WHERE phone='" + this.getPhone() + "'");
		
		this.getAddress().delete();
		
	}
}