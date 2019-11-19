package cs333.project_2.Service;

import javax.xml.ws.Endpoint;

public class Server {
	
	protected Server() throws Exception {
		// START SNIPPET: publish
		System.out.println("Starting Server");
		BuyerResource buyers = new BuyerResource();
		SellerResource sellers = new SellerResource();
		OrderResource orders = new OrderResource();
		ProductResource products = new ProductResource();
		
		String address = "http://localhost:8080/buyers";
		Endpoint.publish(address, buyers);
		
		address = "http://localhost:8080/sellers";
		Endpoint.publish(address, sellers);
		
		address = "http://localhost:8080/orders";
		Endpoint.publish(address, orders);
		
		address = "http://localhost:8080/products";
		Endpoint.publish(address, products);
		
		// END SNIPPET: publish
	}
	
	public static void main(String[] args) throws Exception {
		new Server();
		System.out.println("Server ready...");
	}
}
