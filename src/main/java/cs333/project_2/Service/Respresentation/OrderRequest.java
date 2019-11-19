package cs333.project_2.Service.Respresentation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class OrderRequest {
	
	private String ID;
	private String buyerID;
	private List<String> productIds;
	private String status;

	public OrderRequest() {}
	
	public String getID() {
		return ID;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public String getBuyerID() {
		return buyerID;
	}
	
	public void setBuyerID(String ID) {
		this.buyerID = ID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String stat) {
		this.status = stat;
	}

	public List<String> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<String> prodIds) {
		this.productIds = prodIds;
	}

}

