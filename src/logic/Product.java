package logic;

class Product {

	static public Product create(String name, String description, double price) {
		
		// TODO: Insert into database
		
		Product p = new Product();
		p.name = name;
		p.description = description;
		p.price = price;
		
		return p;
	}
	
	static public Product retrieve(int id) {
		Product[] list = retrieve({id});
		return list[0];
	}

	static public Product[] retrieve(int[] id) {
		// TODO: Select from database
		
		Product[] list;
		
		return list;
	}
	


	private int id;
	private String name;
	private String description;
	private double price;
	
	private Product() { }
	
	public String getName() {
		return name;
	}
	
	/**
	 *  Get description
	 *  
	 *  @return description
	**/
	public String getDescription() {
		return description;
	}
	
	/**
	 *  Get price
	**/
	public double getPrice() {
		return price;
	}
	
	
	public void setName(n) {
		// TODO: Update database
		name = n;
	}
	
	/**
	 *  Set description
	 *  
	 *  @return description
	**/
	public void setDescription(d) {
		// TODO: Update database
		description = d;
	}
	
	/**
	 *  set price
	**/
	public void setPrice(p) {
		// TODO: Update database
		price = p;
	}
	
	
}