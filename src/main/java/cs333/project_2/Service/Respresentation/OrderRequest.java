package cs333.project_2.Service.Respresentation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class OrderRequest {
	
	private int productId;
	private String status;

	public OrderRequest() {}

	public String getStatus() {
		return status;
	}

	public void setStatus(String stat) {
		this.status = stat;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int prodId) {
		this.productId = prodId;
	}

}

