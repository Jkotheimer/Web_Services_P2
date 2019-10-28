package cs333.project_2.Service.Respresentation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class OrderRepresentation {
	
	private int productId;
	private String status;
	private int Id;

	public OrderRepresentation() {}

	public String getStatus() {
		return status;
	}

	public void setStatus(String stat) {
		this.status = stat;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int prodId) {
		this.productId = prodId;
	}

}