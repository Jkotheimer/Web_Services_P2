package cs333.project_2.DOM.Order;

import java.util.List;


/**
 * Order class
 * 
 * An order has the following:
 * - A unique ID
 * - A status
 * - A list of products
 * 		+ Each product is linked to a seller, so if we wish to access the seller, we find their ID through the product
 * - A customer who bought them
 */

public class Order {
	
	private String ID;
	private List<String> productIDs;
	private String buyerID;
	private String status;

	public Order(String ID, String buyerID, List<String> productIDs) {
		this.ID = ID;
		this.productIDs = productIDs;
		this.status = "Order initiated";
		this.buyerID = buyerID;
	}
	
	public Order() {}

	public String getID() {
		return this.ID;
	}

	public List<String> getProductIDs() {
		return this.productIDs;
	}
	
	public String getBuyerID() {
		return this.buyerID;
	}
	
	public String getStatus() {
		return this.status;
	}

	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */

	public void setID(String ID) {
		this.ID = ID;
	}

	public void setProductIDs(List<String> productIDs) {
		this.productIDs = productIDs;
	}
	
	public void addProductID(String productID) {
		if(!this.productIDs.contains(productID)) this.productIDs.add(productID);
	}

	public void setBuyerID(String buyerID) {
		this.buyerID = buyerID;
	}
	
	public boolean updateStatus(String status) {
		this.status = status;
		return true;
	}

}
