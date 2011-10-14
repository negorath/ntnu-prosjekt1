package database;
public class TemporaryOrder{
	int userId;
	TemporaryProduct[] products;
	
	public TemporaryOrder(int userId, TemporaryProduct[] products){
		this.userId = userId;
		this.products = products;
	}
}
