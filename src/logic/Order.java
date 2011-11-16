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
			boolean bol = true;
			for(int j = 0; j<produkter[i].length(); j++){
				if((int)produkter[i].charAt(j) == 32){
					bol = false;
				}
				if(bol){
					this.products += produkter[i].charAt(j);					
				}
			}
			this.products += ":";
			for(int j = 14; j<produkter[i].length(); j++){
				this.products += produkter[i].charAt(j);
			}
			this.products += "-";
		}
	}
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
				System.out.println("hehe: " + produkt[i]);
				String navn = DatabaseConnector.getProduct(produkt[i]).getName();
				dlm.add(i, antall[i] + " x " + navn);
			}catch(Exception e){
//				System.out.println("Klarte ikke lage listmodel av produkter i ordre");
			}
		}		
		return dlm;
	}
	public String getProductsString(){
		String temp = "\t" + "Gruppe 10"  + "\n" + "\tPizzeria\n" + "***********************************************" + "\n\n";
		double sum = 0;
		for (int i = 0; i < antall.length; i++) {
			try {
				Product p = DatabaseConnector.getProduct(produkt[i]);
				String navn = p.getName();
				String pris = String.valueOf(p.getPrice()*antall[i]);
				temp += String.valueOf(antall[i]) + " x " + navn + "\t\t" + pris + ",-" + "\n";
				sum += Double.parseDouble(pris);
			} catch (Exception e) {
//				System.out.println("Greide ikke lage kvittering String");
//				e.printStackTrace();
			}
		}
		temp += "***********************************************" + "\n" + "Sum:" + "\t\t" + sum + ",-";
		
		return temp;
	}
}