package shopping;

public class Product {

	private String product_name;
	private String category;
	private double price;
	private int stock;
	
	public Product(String product_name, String category, double price, int stock)
	{
		this.product_name = product_name;
		this.category = category;
		this.price = price;
		this.stock = stock;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
}
