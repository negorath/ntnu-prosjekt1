package objLogic;

import java.util.ArrayList;

import database.TemporaryAddress;
import database.TemporaryUser;

public class TemporaryDatabase {

	ArrayList<TemporaryUser> users = new ArrayList<TemporaryUser>();
	TemporaryUser user;
	TemporaryAddress address;
	public TemporaryDatabase(){
	}
	
	public void addUser(String name, String phone, TemporaryAddress address){
		user = new TemporaryUser(name, phone, address);
		users.add(user);
	}
	public TemporaryAddress addAddress(String street, String houseNumber, String houseLetter, String zipcode, String city, String country){
		return address = new TemporaryAddress(street, houseNumber, houseLetter, zipcode, city, country);
	}
	/**
	 * 
	 * @param Phone number or Name
	 * @return User
	 */
	public TemporaryUser getUser(String phoneOrName){
		for(int i = 0; i<users.size(); i++){
			if(users.get(i).getPhone().equals(phoneOrName)) return users.get(i);
			else if(users.get(i).getName().equals(phoneOrName)) return users.get(i);
		}return null;
	}
}
