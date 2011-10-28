package database;
public class TemporaryAddress{
	String street, houseNumber, houseLetter, zipcode, city, country;
	public TemporaryAddress(String street, String houseNumber, String houseLetter, String zipcode, String city, String country){
		this.street = street;
		this.houseNumber = houseNumber;
		this.houseLetter = houseLetter;
		this.zipcode = zipcode;
		this.city = city;
		this.country = country;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getHouseLetter() {
		return houseLetter;
	}
	public void setHouseLetter(String houseLetter) {
		this.houseLetter = houseLetter;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
