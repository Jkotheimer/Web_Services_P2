package cs333.project_2.Service.Respresentation;

import cs333.project_2.DOM.Product.Product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import java.util.List;

@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class OrderRepresentation {
	
	private List<String> products;
	private String status;
	private String Id;

	public OrderRepresentation() {}

	public String getStatus() {
		return status;
	}

	public void setStatus(String stat) {
		this.status = stat;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		this.Id = id;
	}

	public List<String> getProducts() {
		return products;
	}

	public void setProducts(List<String> prod) {
		this.products = prod;
	}

}
