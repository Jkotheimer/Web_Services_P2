package cs333.project_2.General;

import cs333.project_2.Profile.*;
import cs333.project_2.Order.*;

/**
 * The Utility class will act as our persistence layer - all other classes will call their essential getters and setters
 * from here to retrieve objects from ID's. Essentially, we are converting ID's into objects and returning the objects.
 * 
 * There are also general functionality methods.
 */
public class Utility {

	public Utility() {}

	public static int generateID() {
		//TODO make this generate random? string
		return 124632;
	}

	public static String searchProduct(String productname) {
		//TODO search database for product with same name
		return "found";
	}

	public static boolean checkAvailability(String productname) {
		//TODO check that a product is available in database
		return true;
	}
    
	/**
	 * All of these goodies are going to be for the Data access layer
	 * Requests will be sent via URI and that layer will ask this layer to do stuff for it - REST
	 */
    
    public Buyer getBuyer(int ID) {
		// TODO grab the corresponding buyer object from the database
		return new Buyer("testCustomer", "S0M3R@ND0M3H@$3DP@$SW0RD", 1234567890, 
							new Address("123 Main St.", "Chicago", "IL", 66666)                              
						);
	}
	public Seller getSeller(int ID) {
		// TODO grab the corresponding seller object from the database
		return new Seller("testCustomer", "S0M3R@ND0M3H@$3DP@$SW0RD", 1234567890, 
							new Address("123 Main St.", "Chicago", "IL", 66666), "website.com"                         
						);
	}
	public Product getProduct(int ID) {
		// TODO grab the corresponding product object from the database
		return new Product(987654321, 12345678, 44.98f, "a new product");
	}
	public Order getOrder(int ID) {
		// TODO grab the corresponding order object from the database
		return new Order(513437658, null, 98765878);
	}
	
	/**
	 * Since these requests are coming from the service layer, we don't want to pass objects, but pass the
	 * parameters and create the objects here to then interact with the persistence layer.
	 * The service layer also does not know how to generate ID's, so they must be generated here.
	 */
	public void addBuyer(String username, String password, Address address) {
		int ID = generateID();
		Buyer b = new Buyer(username, password, ID, address);
		// TODO add the buyer to the database
	}
	public void addSeller(String username, String password, Address address, String urladdress) {
		int ID = generateID();
		Seller s = new Seller(username, password, ID, address, urladdress);
		// TODO add the seller to the database
	}
	public void addProduct(int sellerID, float price, String itemDescrip) {
		int ID = generateID();
		Product p = new Product(ID, sellerID, price, itemDescrip);
		// TODO add the product to the database
	}
	public void addOrder(int[] productIDs, int customerID) {
		int ID = generateID();
		Order o = new Order(ID, productIDs, customerID);
		// TODO add the order to the database
	}
	
	public void deleteBuyer(int ID) {
		// TODO delete the given buyer
	}
	public void deleteSeller(int ID) {
		// TODO delete the given seller
	}
	public void deleteProduct(int ID) {
		// TODO delete the given product
	}
	public void deleteOrder(int ID) {
		// TODO delete the given order
	}
	
	// TODO figure out how to handle put requests to update each object
	// My guess to eliminate the number of methods we make here is to pass a string that specifies the method 
	// that we want to invoke to set element of type T - we would of course have to do a check to ensure that 
	// type T is the correct type to pass to the method
	public <T> void updateBuyer(int ID, String method, T element) {}
	public <T> void updateSeller(int ID, String method, T element) {}
	public <T> void updateProduct(int ID, String method, T element) {}
	public <T> void updateOrder(int ID, String method, T element) {}
}
