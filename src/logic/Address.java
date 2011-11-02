package logic;
import java.sql.Connection;

public class Address {
	
	public static Connection con;
	/**Connect to the given database Connection
	 * 
	 * @param c
	 */
	public static void setConnection(Connection c) {
		con = c;
	}
	

	public Address(String street, int houseNumber, String zipcode,String city) {
		super();
		this.street = street;
		this.houseNumber = houseNumber;
		this.zipcode = zipcode;
		this.city = city;
	}

	private int id;
	private String street;
	private int houseNumber;
	private char houseLetter;
	private String zipcode;
	private String city;
	private String country;
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
	
}