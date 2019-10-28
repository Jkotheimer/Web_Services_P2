package cs333.project_2.DOM.General;

import cs333.project_2.DAL.Buyer.BuyerDAL;
import cs333.project_2.DAL.Order.OrderDAL;
import cs333.project_2.DAL.Product.ProductDAL;
import cs333.project_2.DOM.Buyer.Buyer;

import cs333.project_2.DOM.Product.Product;
import cs333.project_2.DOM.Order.*;
import cs333.project_2.DOM.Seller.Seller;

/**
 * The Utility class will act as our persistence layer - all other classes will call their essential getters and setters
 * from here to retrieve objects from ID's. Essentially, we are converting ID's into objects and returning the objects.
 * 
 * There are also general functionality methods.
 */
public class Utility {

	public Utility() {}

	public static int generateID() {
		//TODO make this generate random? string, we might not need this
		return 124632;
	}

	public static Product searchProduct(int productID) {
		Product prod = ProductDAL.readProduct(productID);
		return prod;
	}

	public static boolean checkAvailability(int productID) {
		if(ProductDAL.readProduct(productID)!= null) {
			return true;
		};
		return false;
	}
    
	/**
	 * All of these goodies are going to be for the Data access layer
	 * Requests will be sent via URI and that layer will ask this layer to do stuff for it - REST
	 */
    
	/**
	 * Since these requests are coming from the service layer, we don't want to pass objects, but pass the
	 * parameters and create the objects here to then interact with the persistence layer.
	 * The service layer also does not know how to generate ID's, so they must be generated here.
	 */
	public static void addBuyer(int ID,String username,String address) {
		BuyerDAL buyerDAL = new BuyerDAL();
		buyerDAL.insert(ID,username,address);
		// TODO add the buyer to the database
	}
	/*public void addSeller(String username, String password, String urladdress) {
		int ID = generateID();
		Seller s = new Seller(username, password, ID, urladdress);
		// TODO add the seller to the database
	}
	public void addProduct(int sellerID, float price, String itemDescrip) {
		int ID = generateID();
		Product p = new Product(ID, sellerID, price, itemDescrip);
		// TODO add the product to the database
	}
	*/
	public void addOrder(int ID, int prod) {
		OrderDAL orderdal = new OrderDAL();
		orderdal.insert(ID, prod);
		// TODO add the order to the database
	}
	
	public static void deleteBuyer(int ID) {
		BuyerDAL buyerDAL = new BuyerDAL();
		buyerDAL.deleteCustomer(ID);
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
	public void updateBuyer(int ID,int buyerID, String username, String address) {
		BuyerDAL buyerDAL = new BuyerDAL();
		buyerDAL.update(ID, buyerID,username,address);
	}
	
	public <T> void updateSeller(int ID, String method, T element) {}
	public <T> void updateProduct(int ID, String method, T element) {}
	public void updateOrder(int serialID,int newOrderID, int productID) {
		OrderDAL orderdal = new OrderDAL();
		orderdal.update(serialID,newOrderID, productID);
	}
}
