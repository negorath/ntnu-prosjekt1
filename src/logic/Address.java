package logic;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Address {
	
	private int id;
	private String street;
	private int houseNumber;
	private char houseLetter;
	private String zipcode;
	private String city;
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
	 * @return the address
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param address the address to set
	 */
	public void setStreet(String address) {
		this.street = address;
	}
	/**
	 * @return the houseNumber
	 */
	public int getHouseNumber() {
		return houseNumber;
	}
	/**
	 * @param houseNumber the houseNumber to set
	 */
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	/**
	 * @return the houseLetter
	 */
	public char getHouseLetter() {
		return houseLetter;
	}
	/**
	 * @param houseLetter the houseLetter to set
	 */
	public void setHouseLetter(char houseLetter) {
		this.houseLetter = houseLetter;
	}
	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	
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