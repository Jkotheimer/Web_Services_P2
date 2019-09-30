package cs333.project_2.Order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import cs333.project_2.General.Utility;
import cs333.project_2.Profile.*;
import cs333.project_2.Order.*;


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

@Entity
@Table(name="`order`")
public class Order {

	private final int ID;
	private final int[] OrderedProductIDs;
	private final int CustomerID;
	private String Status;

	public Order(int ID, int[] productIDs, int customerID) {
		this.ID = ID;
		this.OrderedProductIDs = productIDs;
		this.CustomerID = customerID;
		this.Status = "Order initiated";
	}

	@Id
	@Column(name="orderID")
	public int getID() {
		return this.ID;
	}

	@Column(name="productID")
	public int[] getProductID() {
		return this.OrderedProductIDs;
	}

	@Column(name="customerID")
	public int getCustomerID() {
		return this.CustomerID;
	}

	@Column(name="orderstatus")
	public String getStatus() {
		return this.Status;
	}

	

	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */

@Transient
	public boolean updateStatus(String status) {
		this.Status = status;
		return true;
	}
}
