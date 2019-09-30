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
public class Order
{
<<<<<<< HEAD
    private final int ID;
    private final int[] OrderedProductIDs;
    private final int CustomerID;
    private String Status;

    public Order(int ID, int[] productIDs, int customerID) {
=======
    private int ID;
    private String productID;
   
    private String OrderedProduct; 
    private String CustomerID;
    private String status;
    private String[] OrderedProductIDs;
	
	private static final Utility database = new Utility();

    public Order(int ID, String productID, String OrderedProduct, String customerID, String status) {
>>>>>>> 5702834c98956e625b6dc1671306b5afd4b8d612
		this.ID = ID;
		this.OrderedProduct = OrderedProduct;
		this.productID = productID;
		this.CustomerID = customerID;
		this.status = status;
	}

	@Id
	@Column(name="orderID")
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}

	@Column(name="productID")
	public String getProductID() {
		return productID;
	}
	
	public void setProductID(String productID) {
		this.productID = productID;
	}
	@Column(name="OrderedProduct")
	public String getOrderedProduct() {
		return OrderedProduct;
	}

	public void setOrderedProduct(String orderedProduct) {
		OrderedProduct = orderedProduct;
	}
	@Column(name="customerID")
	public String getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}
	@Column(name="orderstatus")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */
@Transient
	public boolean updateStatus(String status) {
		this.status = status;
		return true;
	}

	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */

<<<<<<< HEAD
	public int getID() 				{ return this.ID; }
	public String getStatus()		{ return this.Status; }
	public int getBuyerID()			{ return this.CustomerID; }
	public int[] getProductIDs()	{ return this.OrderedProductIDs; }
=======


	
	// Special getters that call the persistence layer to grab the actual objects corresponding with each ID
	
	public Buyer getBuyer()			{ return database.getBuyer(CustomerID); }
	public Product[] getProducts()	{
		Product[] products = new Product[this.OrderedProductIDs.length];
		for(int i = 0; i < this.OrderedProductIDs.length; i++) 
			products[i] = database.getProduct(this.OrderedProductIDs[i]);
		return products;
	}
	public Seller[] getSellers()	{
		Seller[] sellers = new Seller[this.OrderedProductIDs.length];
		for(int i = 0; i < this.OrderedProductIDs.length; i++)
			sellers[i] = database.getSeller(this.getProducts()[i].getsellerID()); //TODO Fix this error.
		return sellers;
	}
>>>>>>> 5702834c98956e625b6dc1671306b5afd4b8d612

}
