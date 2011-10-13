package logic;

public class Address {
	

	public Address(String street, String houseNumber, String zipcode,String city) {
		super();
		this.street = street;
		this.houseNumber = houseNumber;
		this.zipcode = zipcode;
		this.city = city;
	}

	private int id;
	private String street;
	private String houseNumber;
	private String houseLetter;
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
	public String getHouseNumber() {
		return houseNumber;
	}
	/**
	 * @param houseNumber the houseNumber to set
	 */
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	/**
	 * @return the houseLetter
	 */
	public String getHouseLetter() {
		return houseLetter;
	}
	/**
	 * @param houseLetter the houseLetter to set
	 */
	public void setHouseLetter(String houseLetter) {
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