package logic;

class Order {
	
	private int id;
	private int userId;
	private Product[] products;
	
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