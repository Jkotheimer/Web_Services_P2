package cs333.project_2.Order;

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
public class Order
{
    private final String ID;
    private final String[] OrderedProductIDs;
    private final String CustomerID;
    private String Status;
	
	private static final Utility database = new Utility();

    public Order(String ID, String[] productIDs, String customerID) {
		this.ID = ID;
		this.OrderedProductIDs = productIDs;
		this.CustomerID = customerID;
		this.Status = "Order Placed";
	}

	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */

	public boolean updateStatus(String status) {
		this.Status = status;
		return true;
	}

	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */

	public String getID() 			{ return this.ID; }
	public String getStatus()		{ return this.Status; }
	public String getBuyerID()		{ return this.CustomerID; }
	public String[] getProductIDs()	{ return this.OrderedProductIDs; }
	
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
			sellers[i] = database.getSeller(this.getProducts()[i].getSellerID());
		return sellers;
	}

}
