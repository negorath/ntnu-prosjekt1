package logic;
import java.sql.Connection;

import javax.swing.DefaultListModel;

public class Order {
	
	private String id;
	private String userId;
	private String products;
	private String ordered, due = "", delivered;
	private int[] antall;
	private String kommentar;
	private String[] produkt;
	private int levering, kort;
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
	 * sets levering
	 */
	public void setLevering(int i){
		this.levering = i;
	}
	/**
	 * 
	 * @return levering true or false
	 */
	public int getLevering(){
		return levering;
	}
	/**
	 * settter betaling med kort
	 * @param boolean
	 */
	public void setKort(int i){
		this.kort = i;
	}
	/**
	 * 
	 * @return kort
	 */
	public int getKort(){
		return kort;
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
			if((int)produkter[i].charAt(produkter[i].length()-1) > 57){
				this.products +=produkter[i].charAt(produkter[i].length()-3);
			}
			else
				this.products += produkter[i].charAt(produkter[i].length()-1);
			if(i < produkter.length){
				this.products += "-";				
			}
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
	public String getDelivered(){
		return this.delivered;
	}
	
	public DefaultListModel getProductsAsDefaultListModel(){
		DefaultListModel dlm = new DefaultListModel();
		for(int i = 0; i<antall.length; i++){
			try{
				if(!produkt[i].equals("")){
					String navn = DatabaseConnector.getProduct(produkt[i]).getName();
					dlm.add(i, antall[i] + " x " + navn);
				}
			}catch(Exception e){
//				System.out.println("Klarte ikke lage listmodel av produkter i ordre");
				e.printStackTrace();
			}
		}		
		return dlm;
	}
	public String getProductsString(){
		String temp = "<html><center>" + "Gruppe 10"  + "<br>" + "\tPizzeria\n" + "</center>" + "<br>" + "*****************************************" + "<br><br>";
		double sum = 0;
		for (int i = 0; i < antall.length; i++) {
			try {
				if(!produkt[i].equals("")){
					Product p = DatabaseConnector.getProduct(produkt[i]);
					String navn = p.getName();
					String pris = String.valueOf(p.getPrice()*antall[i]);
					temp += "<table width='100%'><tr><td align='left'>" + String.valueOf(antall[i]) + " x " + navn + "</td>" + "<td align='right'>" + pris + ",-" + "</td>" + "</tr></table>" + "<br>";
					sum += Double.parseDouble(pris);					
				}
			} catch (Exception e) {
//				System.out.println("Greide ikke lage kvittering String");
//				e.printStackTrace();
			}
		}
		if(getLevering() == 1 && sum < 500){
			temp += "<table width='100%'><tr><td align='left'>" + "Levering</td>" + "<td align='right'>" + 50.0 + ",-" + "</td>" + "</tr></table>" + "<br>";
			sum += 50;
		}
		temp += "*****************************************" + "<table width='100%'>" + "<tr>" + "<td align='left'>" + "Sum:" + "</td>" + "<td align='right'>" + sum + ",-" + "</td>" + "</tr>" + "</table>" + "</html>";
		
		return temp;
	}
	
	public void setKommentar(String kommentar){
		this.kommentar = kommentar;
	}
	public String getKommentar(){
		return this.kommentar;
	}
}