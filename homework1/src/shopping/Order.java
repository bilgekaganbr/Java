package shopping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
	
	//private List<Product> products;
	
	private Map<Invoice, List<Product>> products = new HashMap<Invoice, List<Product>>();

	
	public Map<Invoice, List<Product>> getProducts() {
		return products;
	}

	public void setProducts(Map<Invoice, List<Product>> products) {
		this.products = products;
	}

	
	

	
	
	
	
	

	/*public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}*/
	
	
	

}
