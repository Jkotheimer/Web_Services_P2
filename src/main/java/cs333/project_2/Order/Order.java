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
    private final int ID;
    private final int[] OrderedProductIDs;
    private final int CustomerID;
    private final String date;
    private String Status;

    public Order(int ID, int[] productIDs, int customerID, String date) {
		this.ID = ID;
		this.OrderedProductIDs = productIDs;
		this.CustomerID = customerID;
		this.date = date;
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

	public int getID() 				{ return this.ID; 				}
	public String getStatus()		{ return this.Status; 			}
	public int getBuyerID()			{ return this.CustomerID; 		}
	public String getDate()			{ return this.date;				}
	public int[] getProductIDs()	{ return this.OrderedProductIDs;}

}
