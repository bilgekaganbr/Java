package shopping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class shopping {

	public static void main(String[] args) {
		
		
		List<Customer> customerList = new ArrayList<>();
		
		Customer customer1 = new Customer("Bilge", 27);
		Customer customer2 = new Customer("Cem", 23);
		Customer customer3 = new Customer("Cem", 28);
		
		customerList.add(customer1);
		customerList.add(customer2);
		customerList.add(customer3);
		
		Product customer1order1product1 = new Product("iphone 13", "Smart phone", 13999, 5);
		Product customer1order1product2 = new Product("Mouse", "Bilgisayar", 300, 10);
		Product customer1order2product1 = new Product("Kralın Dönüşü", "Kitap", 50, 25);
		Product customer1order2product2 = new Product("Kattle", "Mutfak", 300, 17);
		
		List<Product> customer1order1products = new ArrayList<>();
		List<Product> customer1order2products = new ArrayList<>();
		
		customer1order1products.add(customer1order1product1);
		customer1order1products.add(customer1order1product2);
		
		Invoice customer1order1invoice = new Invoice(12345);
		
		Map<Invoice, List<Product>> customer1invoice1products = new HashMap<>();
		customer1invoice1products.put(customer1order1invoice, customer1order1products);		
		
		Order customer1order1 = new Order();
		customer1order1.setProducts(customer1invoice1products);
		
		customer1order2products.add(customer1order2product1);
		customer1order2products.add(customer1order2product2);
		
		Invoice customer1order2invoice = new Invoice(32451);
		
		Map<Invoice, List<Product>> customer1invoice2products = new HashMap<>();
		customer1invoice2products.put(customer1order2invoice, customer1order2products);
		
		Order customer1order2 = new Order();
		customer1order2.setProducts(customer1invoice2products);
		
		List<Order> customer1orders = new ArrayList<>();
		customer1orders.add(customer1order1);
		customer1orders.add(customer1order2);
		
		customer1.setOrders(customer1orders);
		
		
		
		
		Product customer2order1product1 = new Product("Samsung Galaxy s21","Smart Phone",10999, 8);
		Product customer2order1product2 = new Product("Klavye", "Bilgisayar", 700, 12);
		Product customer2order2product1 = new Product("Ölüm Yadigarları","Kitap",45,20);
		Product customer2order2product2 = new Product("Kahve Makinesi","Mutfak",400,6);
		
		List<Product> customer2order1products = new ArrayList<>();
		List<Product> customer2order2products = new ArrayList<>();
		
		customer2order1products.add(customer2order1product1);
		customer2order1products.add(customer2order1product2);
		
		Invoice customer2order1invoice = new Invoice(45312);
		
		Map<Invoice, List<Product>> customer2invoice1products = new HashMap<>();
		customer2invoice1products.put(customer2order1invoice, customer2order1products);	
		
		Order customer2order1 = new Order();
		customer2order1.setProducts(customer2invoice1products);
		
		customer2order2products.add(customer2order2product1);
		customer2order2products.add(customer2order2product2);
		
		Invoice customer2order2invoice = new Invoice(53142);
		
		Map<Invoice, List<Product>> customer2invoice2products = new HashMap<>();
		customer2invoice2products.put(customer2order2invoice, customer2order2products);
		
		Order customer2order2 = new Order();
		customer2order2.setProducts(customer2invoice2products);
		
		List<Order> customer2orders = new ArrayList<>();
		customer2orders.add(customer2order1);
		customer2orders.add(customer2order2);
		
		customer2.setOrders(customer2orders);
		
		
		
		Product customer3order1product1 = new Product("Huawei p50 pro","Smart phone",11999,9);
		Product customer3order1product2 = new Product("Mousepad","Bilgisayar",250,30);
		Product customer3order2product1 = new Product("Ejderhaların Dansı 1","Kitap",70,15);
		Product customer3order2product2 = new Product("Fritöz","Mutfak",500,10);
		
		List<Product> customer3order1products = new ArrayList<>();
		List<Product> customer3order2products = new ArrayList<>();
		
		customer3order1products.add(customer3order1product1);
		customer3order1products.add(customer3order1product2);
		
		Invoice customer3order1invoice = new Invoice(24513);
		
		Map<Invoice, List<Product>> customer3invoice1products = new HashMap<>();
		customer3invoice1products.put(customer3order1invoice, customer3order1products);
		
		Order customer3order1 = new Order();
		customer3order1.setProducts(customer3invoice1products);
		
		customer3order2products.add(customer3order2product1);
		customer3order2products.add(customer3order2product2);
		
		Invoice customer3order2invoice = new Invoice(14523);
		
		Map<Invoice, List<Product>> customer3invoice2products = new HashMap<>();
		customer3invoice2products.put(customer3order2invoice, customer3order2products);
		
		Order customer3order2 = new Order();
		customer3order2.setProducts(customer3invoice2products);
		
		List<Order> customer3orders = new ArrayList<>();
		customer3orders.add(customer3order1);
		customer3orders.add(customer3order2);
		
		customer3.setOrders(customer3orders);
		
		//System.out.println(customerList.size());
		
		
		
		/*int number = 0;
		
		for (Customer customer : customerList)
		{
			if (customer.getName().equals("Cem"))
			{
				for (Order order : customer.getOrders())
				{
					for (List<Product> products : order.getProducts().values())
					{
						for (Product product : products)
						{
							number++;
						}
					}
				}
			}
		}
		System.out.println(number);*/
		
		/*double total = 0;
		
		for (Customer customer : customerList)
		{
			if (customer.getName().equals("Cem") && (customer.getAge() > 25 && customer.getAge() < 30))
			{
				for (Order order : customer.getOrders())
				{
					for (List<Product> products : order.getProducts().values())
					{
						for (Product product : products)
						{
							total += product.getPrice();
						}
					}
				}
			}
		}
		System.out.println(total);*/
		
		
		/*for (Customer customer : customerList)
		{
			for (Order order : customer.getOrders())
			{
				for (List<Product> products : order.getProducts().values())
				{
					double total = 0;
					
					for (Product product : products)
					{
						total += product.getPrice();
					}	
					for (Invoice invoices : order.getProducts().keySet())
					{
						if (total > 1500)
						{
								System.out.println(invoices.getInvoice_id());
						}
					}
					
					
				}
			}
		}*/
		
		
		
		
		
		

	}

}
