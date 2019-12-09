package cs333.project_2.Service.Representation;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import cs333.project_2.Service.AbstractRepresentation;

@XmlRootElement
public class OrderRepresentation extends AbstractRepresentation {
	
	private String orderID;
	private List<ProductRepresentation> products;
	private String buyerID;
	private String status;
	private double totalPrice;

	public OrderRepresentation(String ID, String buyerID, List<ProductRepresentation> products) {
		this.orderID = ID;
		this.products = products;
		this.status = "Order initiated";
		this.buyerID = buyerID;
		this.totalPrice = 0;
		for(ProductRepresentation p : products) this.totalPrice += p.getPrice();
	}
	
	public OrderRepresentation() {}

	public String getID() {
		return this.orderID;
	}

	public List<ProductRepresentation> getProducts() {
		return this.products;
	}
	
	public String getBuyerID() {
		return this.buyerID;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public double getTotalPrice() {
		return this.totalPrice;
	}

	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public void setProductIDs(List<ProductRepresentation> products) {
		this.products = products;
	}

	public void setBuyerID(String buyerID) {
		this.buyerID = buyerID;
	}
	
	public void updateStatus(String status) {
		this.status = status;
	}

}