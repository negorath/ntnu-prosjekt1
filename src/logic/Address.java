package logic;
import java.sql.Connection;
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
	private char houseLetter;
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
	private String country = "NO";
	
	public static Connection con;
	/**Connect to the given database Connection
	 * 
	 * @param c
	 */
	public static void setConnection(Connection c) {
		con = c;
	}
	
	/**
	 * 
	 * @param street
	 * @param houseNumber
	 * @param zipcode
	 * @param city
	 */
	public Address(String street, int houseNumber, String zipcode,String city) {
		this.street = street;
		this.houseNumber = houseNumber;
		this.zipcode = zipcode;
		this.city = city;
	}
	public Address(int id, String street, int houseNumber, String zipcode,String city) {
		this.id = id;
		this.street = street;
		this.houseNumber = houseNumber;
		this.zipcode = zipcode;
		this.city = city;
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
	public char getHouseLetter() {
		return houseLetter;
	}
	/**
	 * @param houseLetter  the houseLetter to set
	 * @uml.property  name="houseLetter"
	 */
	public void setHouseLetter(char houseLetter) {
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
	 * @param id  to set
	 * @uml.property  name="id"
	 */
	public void setId(int id){
		this.id = id;
	}
	/**
	 * @return true if the address is saved correctly
	 */
	public boolean save(){
		
		try {
			Statement stmt = con.createStatement();
//		If this object already exists in the database, update the values 
			if (this.getId() != -1) {
				String sql = "UPDATE addresses " +
								"SET country='" + this.getCountry() + 
								"', city='" + this.getCity() + 
								"', zipcode='" + this.getZipcode() + 
								"', street='" + this.getStreet() + 
								"', houseNumber='" + this.getHouseNumber() +
								"', houseLetter='" + this.getHouseLetter() + 
								"' WHERE id = " + this.getId()
								;
				stmt.execute(sql);
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

}