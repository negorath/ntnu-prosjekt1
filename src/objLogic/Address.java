package objLogic;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Address {
	/**
	 * @uml.property  name="id"
	 */
	private int id;
	/**
	 * @uml.property  name="street"
	 */
	private String street;
	/**
	 * @uml.property  name="houseNumber"
	 */
	private int houseNumber;
	/**
	 * @uml.property  name="houseLetter"
	 */
	private String houseLetter;
	/**
	 * @uml.property  name="zipcode"
	 */
	private String zipcode;
	/**
	 * @uml.property  name="city"
	 */
	private String city;
	/**
	 * @uml.property  name="country"
	 */
	private String country;
	
	public static Connection con;
	/**Connect to the given database Connection
	 * 
	 * @param c
	 */
	public static void setConnection(Connection c) {
		con = c;
	}
	public static Connection getConnection() {
		return con;
	}
	
	/**
	 * 
	 * @param street
	 * @param houseNumber
	 * @param zipcode
	 * @param city
	 */
	public Address(String street, int houseNumber, String zipcode,String city) {
		super();
		this.street = street;
		this.houseNumber = houseNumber;
		this.zipcode = zipcode;
		this.city = city;
		this.id = -1;
	}
	public Address() {
		this.street = null;
		this.houseNumber = -1;
		this.zipcode = null;
		this.city = null;
		this.id = -1;
	}
	

	/**
	 * @return  the address
	 * @uml.property  name="street"
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param address  the address to set
	 * @uml.property  name="street"
	 */
	public void setStreet(String address) {
		this.street = address;
	}
	/**
	 * @return  the houseNumber
	 * @uml.property  name="houseNumber"
	 */
	
	public int getHouseNumber() {
		return houseNumber;
	}
	/**
	 * @param houseNumber  the houseNumber to set
	 * @uml.property  name="houseNumber"
	 */
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	/**
	 * @return  the houseLetter
	 * @uml.property  name="houseLetter"
	 */
	public String getHouseLetter() {
		return houseLetter;
	}
	/**
	 * @param houseLetter  the houseLetter to set
	 * @uml.property  name="houseLetter"
	 */
	public void setHouseLetter(String houseLetter) {
		this.houseLetter = houseLetter;
	}
	/**
	 * @return  the zipcode
	 * @uml.property  name="zipcode"
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * @param zipcode  the zipcode to set
	 * @uml.property  name="zipcode"
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * @return  the city
	 * @uml.property  name="city"
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city  the city to set
	 * @uml.property  name="city"
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return  the country
	 * @uml.property  name="country"
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country  the country to set
	 * @uml.property  name="country"
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return  the id
	 * @uml.property  name="id"
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id
	 * @uml.property  name="id"
	 */
	public void setId(int id){
		this.id = id;
	}
	
	/** Returns the address of the given valid id
	 * 
	 * @return Address from database
	 */
	public static Address retrieve(String id) throws SQLException{
		
		Statement stmt = con.createStatement();
		
		ResultSet data = stmt.executeQuery(	"SELECT * FROM addresses " +
											"WHERE id='" + id + "'");
		
		if (data.first()) {
			Address address = new Address();
			address.setStreet(data.getString("street"));
			address.setHouseNumber(data.getInt("houseNumber"));
			address.setHouseLetter(data.getString("houseLetter"));
			address.setZipcode(data.getString("zipcode"));
			address.setCity(data.getString("city"));
			address.setCountry(data.getString("country"));
			return address;
		}
		else return null;
		
		
	}
		
//	/**Takes an address as input, checks if it can find an exact copy of it within the database
//	 * 
//	 * @param address
//	 * @return The same object with the proper addressId, null if it does not exist
//	 * @throws SQLException 
//	 */
//	public static Address retrieve(Address adr) throws SQLException {
//		Statement stmt = con.createStatement();
//		
//		boolean existsInDatabase = stmt.execute("SELECT * FROM addresses" +
//												"WHERE street='" + adr.getStreet() + "' " +
//												"AND houseNumber='" + adr.getHouseNumber() + "' " +
//												"AND houseLetter='" + adr.getHouseLetter() + "' " +
//												"AND zipcode='" + adr.getZipcode() + "' " +
//												"AND city='" + adr.getCity() + "' " +
//												"AND country='" + adr.getCountry() + "' ");
//		
//		if (existsInDatabase) {
//			String addressId = stmt.getResultSet().getString("id");
//			adr.setId(Integer.parseInt(addressId));
//			return adr;
//		}
//		return null;
//		
//	}
	/**Synkroniserer dette objektet med databasen. Hvis det ikke eksisterer fra f�r, s� opprettes det. Hvis det eksisterer fra f�r s� blir alle feltene overskrevet.
	 * 
	 * 
	 * 
	 * @throws SQLException
	 */
	public void sync() throws SQLException{
		
		Statement stmt = con.createStatement();
//		If this object already exists in the database, update the values 
		if (this.getId() != -1) {
			stmt.execute(	"UPDATE addresses " +
							"SET country='" + this.getCountry() + 
							"', city='" + this.getCity() + 
							"', zipcode='" + this.getZipcode() + 
							"', street='" + this.getStreet() + 
							"', houseNumber='" + this.getHouseNumber() +
							"', houseLetter='" + this.getHouseLetter());
		}
		else 	{  // Create the address
			
			stmt.execute(	"INSERT INTO addresses VALUES (" + 
							this.getStreet() + ", " +
							this.getHouseNumber() + ", " + 
							this.getHouseLetter() + ", " + 
							this.getZipcode() + ", " +
							this.getCity() + ", " + 
							this.getCountry() + ", )" );
		}
	
	}
	
	public void delete() throws SQLException{
		this.sync();
		Statement stmt = con.createStatement();
		
		stmt.execute(	"DELETE from addresses " +
						"WHERE id='" + this.getId() + "'");
	}
}