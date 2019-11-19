package cs333.project_2.DOM.Order;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	private List<String> OrderedProducts;
	private String buyerID;
	private String Status;

	public Order(String ID, String buyerID, List<String> products) {
		this.orderID = ID;
		this.OrderedProducts = products;
		this.Status = "Order initiated";
		this.buyerID = buyerID;
	}
	
	public Order() {}
	
	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */

	public String getID() {
		return this.orderID;
	}

	public List<String> getOrderedProducts() {
		return this.OrderedProducts;
	}
	
	public String getBuyerID() {
		return this.buyerID;
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

	public void setOrderedProducts(List<String> orderedProducts) {
		this.OrderedProducts = orderedProducts;
	}

	public void setBuyerID(String buyerID) {
		this.buyerID = buyerID;
	}
	
	public boolean updateStatus(String status) {
		this.Status = status;
		return true;
	}

}
