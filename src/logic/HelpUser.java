package logic;


public class HelpUser {

	public static User getBob() {
		User bob = new User();
		bob.setName("bob");
		bob.setPhone("81549300");
		bob.setAddress(new Address("Nardoveien", "5", "7046", "Trondheim"));
		return bob;
		
	}
	
	
}
