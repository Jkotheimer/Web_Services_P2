package cs333.project_2.Service.Respresentation;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import cs333.project_2.DOM.General.Address;
import cs333.project_2.DOM.General.PaymentInfo;
import cs333.project_2.DOM.Order.Order;
import cs333.project_2.Service.AbstractRepresentation;

@XmlRootElement(name = "Buyer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class BuyerRepresentation extends AbstractRepresentation {
	
	private String username;
	private String password;
	private String buyerID;
	private List<Order> orders = new ArrayList<>();
	private List<Address> addresslist = new ArrayList<>();
	private List<PaymentInfo> payinfo = new ArrayList<>();; // Allow buyers to have multiple payment options

	public BuyerRepresentation(String ID,String username, String password) {
		this.username = username;
		this.password = password;
		this.buyerID = ID;
	}

	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */

	public String getUsername()	{ 
		return this.username;	
	}

	public String getBuyerID() {  
		return this.buyerID;		
	}
	
	public List<Address> getAddress() {
		return this.addresslist;
	}
	
	public List<Order> getOrders() { 		
		return this.orders;	
	}
	
	public List<PaymentInfo> getPayInfos()	{ 
		return this.payinfo;  
	}


	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */

	public boolean addOrder(Order orderID) {
		// Add the new order in the correct position
		this.orders.add(orderID);
		return true;
	}
	
	public boolean addAddress(Address addr) {
		// Add the new order in the correct position
		this.addresslist.add(addr);
		return true;
	}

	public boolean addPayInfo(PaymentInfo newPayInfo) {//		// If this method of payment already exists, return false
		for(PaymentInfo i : this.payinfo) {
			if(i == newPayInfo) return false;
		}
		return this.payinfo.add(newPayInfo);
	}
	
	public boolean deletePayInfo(PaymentInfo payinfo) {
		return this.payinfo.remove(payinfo);
	}

	public boolean setUsername(String username) {
		// TODO - possibly add a database check for other profiles with the given username
		this.username = username;
		return true;
	}

	public void setbuyerID(String iD) {
		this.buyerID = iD;
	}

	public void setOrderIDs(List<Order> orderIDs) {
		this.orders = orderIDs;
	}
	
	public void setAdresses(List<Address> addresses) {
		this.addresslist = addresses;
	}
	
	public void setPaymentInfos(List<PaymentInfo> payInfos) {
		this.payinfo = payInfos;
	}

	public boolean setPassword(String password) {
		// If the password has been used before, inform the user and have them change it to something else
		if(this.password == password) return false;
		this.password = password;
		return true;
	}
}
