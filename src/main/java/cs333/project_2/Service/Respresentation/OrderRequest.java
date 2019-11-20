package cs333.project_2.Service.Respresentation;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import cs333.project_2.DOM.Buyer.Buyer;
import cs333.project_2.DOM.Product.Product;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class OrderRequest {
	
	private String orderID;
	private List<Product> OrderedProductIDs;
	private String status;

	public OrderRequest() {}

	public String getStatus() {
		return status;
	}

	public void setStatus(String stat) {
		this.status = stat;
	}
	
	public String getID() {
		return this.orderID;
	}
	
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public List<Product> getProductIds() {
		return OrderedProductIDs;
	}

	public void setProductIds(List<Product> prodId) {
		this.OrderedProductIDs = prodId;
	}

}

