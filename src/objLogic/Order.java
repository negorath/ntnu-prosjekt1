package objLogic;
import java.sql.Connection;

class Order {
	
	private int id;
	private int userId;
	private Product[] products;
	private String ordered, due, delivered;
	/**
	 * 
	 * @param id
	 * @param userId
	 * @param ordered
	 * @param due
	 * @param delivered
	 */
	public Order(int userId, String ordered, String due, String delivered){
		this.userId = userId;
		this.ordered = ordered;
		this.due = due;
		this.delivered = delivered;
	}
	
	
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the products
	 */
	public Product[] getProducts() {
		return products;
	}
	/**
	 * @param products the products to set
	 */
	public void setProducts(Product[] products) {
		this.products = products;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	
}