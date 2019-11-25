package cs333.project_2.DOM.Order;

import java.util.List;

import cs333.project_2.DOM.Buyer.Buyer;
import cs333.project_2.DOM.Product.Product;


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
	
	private String orderID;
	private List<Product> OrderedProductIDs;
	private Buyer buyer;
	private String Status;

	public Order(String ID, Buyer purchaser, List<Product> productIDs) {
		this.orderID = ID;
		this.OrderedProductIDs = productIDs;
		this.Status = "Order initiated";
		this.buyer = purchaser;
	}
	
	public Order() {
		
	}

	public String getID() {
		return this.orderID;
	}

	public List<Product> getOrderedProductIDs() {
		return this.OrderedProductIDs;
	}
	
	public Buyer getBuyer() {
		return this.buyer;
	}
	
	public String getStatus() {
		return this.Status;
	}

	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public void setOrderedProductIDs(List<Product> orderedProductIDs) {
		this.OrderedProductIDs = orderedProductIDs;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	
	public boolean updateStatus(String status) {
		this.Status = status;
		return true;
	}

}
