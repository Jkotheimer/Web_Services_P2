package cs333.project_2.DOM.Buyer;

import cs333.project_2.DOM.General.Address;
import cs333.project_2.DOM.General.PaymentInfo;
import cs333.project_2.DOM.Order.Order;

import java.util.ArrayList;
import java.util.List;

public class Buyer  {

	private String username;
	private String password;
	private String buyerID;
	private List<Order> orders = new ArrayList<>();
	private List<Address> addresslist = new ArrayList<>();
	private List<PaymentInfo> payinfo = new ArrayList<>();; // Allow buyers to have multiple payment options

	public Buyer(String ID,String username, String password) {
		this.username = username;
		this.password = password;
		this.buyerID = ID;
	}
	
	public Buyer() {}


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

	public boolean setPassword(String oldPassword, String newPassword) {
		// If the password has been used before, inform the user and have them change it to something else
		if(this.password.equals(oldPassword)) {
			this.password = newPassword;
			return true;
		}
		return false;
	}

	/**
	 * GENERAL METHODS
	 * ________________________________________________________________________
	 */

	public boolean AuthenticateCred(String username, String password) {
		// TODO possibly add another hash algorithm here for safety
		if(this.username.equals(username) && this.password.equals(password)) return true;
		else return false;
	}
	
	public String getPassword() {
		return password;
	}
}
	
