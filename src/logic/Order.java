package logic;
import java.sql.Connection;

public class Order {
	
	private String id;
	private String userId;
	private String products;
	private String ordered, due, delivered;
	/**
	 * 
	 * @param id
	 * @param userId
	 * @param ordered
	 * @param due
	 * @param delivered
	 */
	public Order(String userId){
		this.userId = userId;
	}
	
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;			
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the products
	 */
	public String getProducts() {
		return products;
	}
	public void setProducts(int[] produkter){
		for(int i = 0; i<produkter.length; i++){
			System.out.println(produkter[i]);
		}
	}
	//2:15-3:2-4:7
	public void createFoodList(String s){
		int teller = 0;
		for(int i = 0; i<s.length(); i++){
			if(s.charAt(i) == '-'){
				teller++;
			}
		}
		teller = 0;
		int[][] liste = new int[2][teller];
		String element = "";
		for(int i = 0; i<s.length(); i++){
			if(s.charAt(i) != ':' && s.charAt(i) != '-'){
				element += s.charAt(i);
			}
			else if(s.charAt(i) == ':'){
				liste[0][teller] = Integer.parseInt(element);
				element = "";
			}
			else if(s.charAt(i) == '-'){
				liste[1][teller] = Integer.parseInt(element);
				element = "";
				teller++;
			}
		}
		for (int i = 0; i < liste.length; i++) {
			for (int j = 0; j < liste.length; j++) {
				System.out.println(liste[i][j]);
			}
			System.out.println();
		}
	}
	
	/**
	 * @param products the products to set
	 */
	public void setProducts(String products) {
		this.products = products;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	public void setId(String a){
		this.id = a;
	}
	public String toString(){
		String s = getId() + " ";
		try {
			s += DatabaseConnector.getUser(Integer.parseInt(userId));
		} catch (Exception e) {
			System.out.println("Failed to make toString in class Order");
		}
		return s;
	}
	
}