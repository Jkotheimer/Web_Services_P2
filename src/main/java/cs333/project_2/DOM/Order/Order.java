package cs333.project_2.DOM.Order;

import java.util.ArrayList;
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
@Table(name= "orders")
public class Order {
	
	private int serialID;
	private int orderID;
	private int OrderedProductIDs;
	private Buyer buyer;
	private String Status;

//	public Order(int ID, int productIDs, Buyer customerID) {
//		this.orderID = ID;
//		this.OrderedProductIDs = productIDs;
//		this.CustomerID=customerID; 
//		this.Status = "Order initiated";
//	}
//	
	
	public Order() {
		
	}

	
//	public int getID() {
//		return this.orderID;
//	}
	@Id
	@Column(name = "serialID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getSerialID() {
		return serialID;
	}
	
	
	@Column(name="OrderID")
		public int getOrderID() {
			return orderID;
		}

	@Column(name="productID")
	public int getOrderedProductIDs() {
		return this.OrderedProductIDs;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
        @JoinColumn(name="Buyer_ID", referencedColumnName="buyerID"),
        @JoinColumn(name="Buyer_UserName", referencedColumnName="buyerusername")
    })
	public Buyer getBuyer() {
		return this.buyer;
	}



	



	


	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */
	
	public void setSerialID(int serialID) {
		this.serialID = serialID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}


	public void setOrderedProductIDs(int orderedProductIDs) {
		this.OrderedProductIDs = orderedProductIDs;
	}


	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	
@Transient
	public boolean updateStatus(String status) {
		this.Status = status;
		return true;
	}
@Transient
public String getStatus() {
	return this.Status;
}

}
