package logic;
import java.sql.Connection;

import javax.swing.DefaultListModel;

public class Order {
	
	private String id;
	private String userId;
	private String products;
	private String ordered, due = "", delivered;
	private int[] antall;
	private String[] produkt;
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
	public void setProducts(String[] produkter){
		this.products = "";
		for(int i = 0; i<produkter.length; i++){
			this.products += produkter[i].charAt(0) + ":";
			this.products += produkter[i].charAt(produkter[i].length()-1);
			if(i != produkter.length-1){
				this.products += "-";
			}
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
		teller++;
		antall = new int[teller];
		produkt = new String[teller];
		teller = 0;
		String element = "";
		for(int i = 0; i<s.length(); i++){
			if(s.charAt(i) != ':' && s.charAt(i) != '-'){
				element += s.charAt(i);
			}
			else if(s.charAt(i) == ':'){
				antall[teller] = Integer.parseInt(element);
				element = "";
			}
			else if(s.charAt(i) == '-'){
				produkt[teller] = element;
				element = "";
				teller++;
			}
		}
		produkt[teller] = element;
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
	
	public String getDue(){
		return this.due;
	}
	public void setDue(String s){
		this.due = s;
	}
	public void setDelivered(String s){
		this.delivered = s;
	}
	
	public DefaultListModel getProductsAsDefaultListModel(){
		DefaultListModel dlm = new DefaultListModel();
		for(int i = 0; i<antall.length; i++){
			try{
				String navn = DatabaseConnector.getProduct(produkt[i]).getName();
				dlm.addElement(antall[i] + " x " + navn);							
			}catch(Exception e){
				System.out.println("Klarte ikke lage listmodel av produkter i ordre");
			}
		}		
		return dlm;
	}
}