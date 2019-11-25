package cs333.project_2.Service;

import javax.xml.ws.Endpoint;

public class ServerImpl {
	
	protected ServerImpl() throws Exception {
		// START SNIPPET: publish
		System.out.println("Starting Server");
		
		Endpoint.publish("http://localhost:8080/users/buyers", new BuyerResource());
		
		Endpoint.publish("http://localhost:8080/users/sellers", new SellerResource());
		
		Endpoint.publish("http://localhost:8080/orders", new OrderResource());
		
		Endpoint.publish("http://localhost:8080/products", new ProductResource());
		
		// END SNIPPET: publish
	}
	
	public static void main(String[] args) throws Exception {
		new ServerImpl();
		System.out.println("Server ready...");
	}
}
