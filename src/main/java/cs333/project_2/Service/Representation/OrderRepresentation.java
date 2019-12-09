package cs333.project_2.Service.Representation;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import cs333.project_2.DOM.Buyer.Buyer;
import cs333.project_2.DOM.Product.Product;
import cs333.project_2.Service.AbstractRepresentation;

@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class OrderRepresentation extends AbstractRepresentation{
	
	private String orderID;
	private List<Product> OrderedProductIDs;
	private Buyer buyer;
	private String Status;

	public OrderRepresentation(String ID, Buyer purchaser, List<Product> productIDs) {
		this.orderID = ID;
		this.OrderedProductIDs = productIDs;
		this.Status = "Order initiated";
		this.buyer = purchaser;
	}
	
	public OrderRepresentation() {
		
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