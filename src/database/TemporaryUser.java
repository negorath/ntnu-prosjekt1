package database;

import java.util.ArrayList;

public class TemporaryUser{
	
	TemporaryAddress address;
	String name, phone, kommentar;
	ArrayList<TemporaryAddress> addresses = new ArrayList<TemporaryAddress>();
	
	public TemporaryUser(String name, String phone, TemporaryAddress address){
		this.name = name;
		this.phone = phone;
		this.address = address;
		addresses.add(address);
	}
	public String getKommentar(){
		return kommentar;
	}
	public String getName(){
		return name;
	}
	public String getPhone(){
		return phone;
	}
	public void addAddress(TemporaryAddress address){
		if(!addresses.contains(address))	addresses.add(address);
	}
	public TemporaryAddress getAddress(){
		return address;
	}
	public TemporaryAddress getAddressById(int i){
		if(addresses.size() > i && addresses.get(i) != null)	return addresses.get(i);
		return null;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public void setKommenta(String kom){
		this.kommentar += kom + "\n";
	}
}
