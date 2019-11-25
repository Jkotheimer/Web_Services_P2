package cs333.project_2.Service.Respresentation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Buyer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class BuyerRequest {
	
private String buyerId;
private String username;
private String password;

public String getBuyerId() {
	return buyerId;
}
public void setBuyerId(String buyerId) {
	this.buyerId = buyerId;
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
}
