package cs333.project_2.Service.Respresentation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Seller")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class SellerRepresentation {

	private int serialID;
	private String username;
	private String password;
	private int sellerID;
	private String address;
	private String urlAddress;
	
	public int getSerialID() {
		return serialID;
	}
	public void setSerialID(int serialID) {
		this.serialID = serialID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSellerID() {
		return sellerID;
	}
	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUrlAddress() {
		return urlAddress;
	}
	public void setUrlAddress(String urlAddress) {
		this.urlAddress = urlAddress;
	}
	
}
