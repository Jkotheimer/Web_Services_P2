package cs333.project_2.Service.Representation;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import cs333.project_2.DOM.General.Address;
import cs333.project_2.DOM.General.PaymentInfo;
import cs333.project_2.DOM.Order.Order;
import cs333.project_2.Service.AbstractRepresentation;

@XmlRootElement
public class BuyerRepresentation extends AbstractRepresentation {
	
	private final String accountType = "buyer";
	private String username;
	private String ID;
	private List<Order> orders = new ArrayList<>();
	private List<Address> addresslist = new ArrayList<>();
	private List<PaymentInfo> payinfo = new ArrayList<>();; // Allow buyers to have multiple payment options

	public BuyerRepresentation(String ID,String username) {
		this.username = username;
		this.ID = ID;
	}
	
	public BuyerRepresentation() {}

	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */

	public String getAccountType() {
		return this.accountType;
	}
	
	public String getUsername()	{ 
		return this.username;	
	}

	public String getID() {  
		return this.ID;		
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
		this.username = username;
		return true;
	}

	public void setID(String iD) {
		this.ID = iD;
	}

	public void setOrderIDs(List<Order> orderIDs) {
		this.orders = orderIDs;
	}
	
	public void setAddresses(List<Address> addresses) {
		this.addresslist = addresses;
	}
	
	public void setPaymentInfos(List<PaymentInfo> payInfos) {
		this.payinfo = payInfos;
	}
}
