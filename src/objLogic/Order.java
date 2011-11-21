package objLogic;
import java.sql.Connection;

class Order {
	
	/**
	 * @uml.property  name="id"
	 */
	private int id;
	/**
	 * @uml.property  name="userId"
	 */
	private int userId;
	/**
	 * @uml.property  name="products"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	private Product[] products;
	/**
	 * @uml.property  name="ordered"
	 */
	private String ordered;
	/**
	 * @uml.property  name="due"
	 */
	private String due;
	/**
	 * @uml.property  name="delivered"
	 */
	private String delivered;
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
	 * @return  the userId
	 * @uml.property  name="userId"
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId  the userId to set
	 * @uml.property  name="userId"
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return  the products
	 * @uml.property  name="products"
	 */
	public Product[] getProducts() {
		return products;
	}
	/**
	 * @param products  the products to set
	 * @uml.property  name="products"
	 */
	public void setProducts(Product[] products) {
		this.products = products;
	}
	/**
	 * @return  the id
	 * @uml.property  name="id"
	 */
	public int getId() {
		return id;
	}
	
	
}