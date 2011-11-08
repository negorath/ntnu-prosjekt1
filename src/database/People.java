package database;

public class People {
		
	public TemporaryUser user(String nrOrName){
			if(nrOrName.equals("47294000") || nrOrName.equals("Magnus Line"))
				return user1();
			else if(nrOrName.equals("9966554488") || nrOrName.equals("Bjarne Pulesmule"))
				return user2();
			else if(nrOrName.equals("90004466") || nrOrName.equals("Terje Berger"))
				return user3();
			return null;
	}			
	
	public TemporaryUser user1(){
		TemporaryUser user = new TemporaryUser("Magnus Line", "47294000", new TemporaryAddress("Harald Bothners veg", "14", "", "7052", "Trondheim", "Norway"));
		return user;
	}
	
	public TemporaryUser user2(){
		TemporaryUser user = new TemporaryUser("Bjarne Pulesmule", "9966554488", new TemporaryAddress("Tullegata", "4", "b", "7014", "Trondheim", "Norway"));
		return user;
	}
	
	public TemporaryUser user3(){
		TemporaryUser user = new TemporaryUser("Terje Berger", "90004466", new TemporaryAddress("Tullegata", "67", "a", "7014", "Trondheim", "Norway"));
		return user;
	}
}
