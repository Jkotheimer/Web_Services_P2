package cs333.project_2.DOM.Buyer;

import cs333.project_2.DOM.General.Address;
import cs333.project_2.DOM.General.PaymentInfo;

import java.util.ArrayList;
import java.util.List;

public class Buyer  {

	private String username;
	private String password;
	private String ID;
	private List<Address> addressList = new ArrayList<>();
	private List<PaymentInfo> payInfos = new ArrayList<>();; // Allow buyers to have multiple payment options

	public Buyer(String ID, String username, String password) {
		this.username = username;
		this.password = password;
		this.ID = ID;
	}
	
	public Buyer() {}


	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */

	public String getUsername()	{ 
		return this.username;	
	}

	public String getID() {  
		return this.ID;		
	}
	
	public List<Address> getAddressList() {
		return this.addressList;
	}
	
	public List<PaymentInfo> getPayInfos()	{ 
		return this.payInfos;  
	}


	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */
	
	public boolean addAddress(Address addr) {
		// Add the new order in the correct position
		this.addressList.add(addr);
		return true;
	}

	public boolean addPayInfo(PaymentInfo newPayInfo) {//		// If this method of payment already exists, return false
		for(PaymentInfo i : this.payInfos) {
			if(i == newPayInfo) return false;
		}
		return this.payInfos.add(newPayInfo);
	}
	
	public boolean deletePayInfo(PaymentInfo payinfo) {
		return this.payInfos.remove(payinfo);
	}

	public boolean setUsername(String username) {
		this.username = username;
		return true;
	}

	public void setID(String iD) {
		this.ID = iD;
	}
	
	public void setAdresses(List<Address> addresses) {
		this.addressList = addresses;
	}
	
	public void setPaymentInfos(List<PaymentInfo> payInfos) {
		this.payInfos = payInfos;
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
		if(this.username.equals(username) && this.password.equals(password)) return true;
		else return false;
	}
	
	public String getPassword() {
		return password;
	}
}
	
