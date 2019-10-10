package cs333.project_2.DOM.Buyer;
import cs333.project_2.DOM.General.Address;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="buyer")
public class Buyer {

	private String username;
	private String password;
	private final int ID;
	private Address address;
	//private ArrayList<String> orderIDs;
	//private ArrayList<PaymentInfo> payinfo; // Allow buyers to have multiple payment options

	public Buyer(String username, String password, int ID, Address address) {
		this.username = username;
		this.password = password;
		this.ID = ID;
		this.address = address;
		//this.orderIDs = new ArrayList<>();
		//this.payinfo = new ArrayList<>();
	}

	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */
	
    @Column(name = "buyerusername")
	public String getUsername()					{ return this.username;	}

	@Id
	@Column(name = "buyerID")
	public int getID()						    {  return this.ID;		}

	@Column(name= "buyeraddress")
	public String getAddressString()			{
		return this.address.ConvertAddresstoString();
	}
	
	public Address getAddress()					{
		return this.address;
	}
	//public ArrayList<String> getOrderIDs()		{ return this.orderIDs;	}
	//public ArrayList<PaymentInfo> getPayInfos()	{ return this.payinfo;  }

	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */

//    public boolean addPayInfo(PaymentInfo newPayInfo) {
//		// If this method of payment already exists, return false
//		for(PaymentInfo i : this.payinfo) if(i == newPayInfo) return false;
//		return this.payinfo.add(newPayInfo);
//    }
//    public boolean deletePayInfo(PaymentInfo payinfo) {
//		return this.payinfo.remove(payinfo);
//	}
	public boolean setUsername(String username) {
		// TODO - possibly add a database check for other profiles with the given username
		this.username = username;
		return true;
	}

	public boolean setPassword(String password) {
		// If the password has been used before, inform the user and have them change it to something else
		if(this.password == password) return false;
		this.password = password;
		return true;
	}

	public boolean setAddress(Address address) {
		this.address = address;
		return true;
	}

//	public boolean addOrder(String orderID) {
//		// Add the new order ID in the correct alphabetical position
//		if(this.orderIDs.size() == 0) {
//			this.orderIDs.add(orderID);
//			return true;
//		} else if(this.orderIDs.size() == 1) {
//			if(orderID.compareTo(this.orderIDs.get(0)) > 0) this.orderIDs.add(orderID);
//			else this.orderIDs.add(0, orderID);
//			return true;
//		} else if(orderID.compareTo(this.orderIDs.get(0)) < 0) {
//			this.orderIDs.add(0, orderID);
//			return true;
//		}
//		// If we've passed the first two elements, it's time to start iterating
//		for(String o : this.orderIDs) if(orderID.equals(o)) return false;
//		for(int i = 0; i < this.orderIDs.size() - 1; i++) {
//			if(orderID.compareTo(this.orderIDs.get(i)) > 0 && orderID.compareTo(this.orderIDs.get(i + 1)) < 0) {
//				this.orderIDs.add(i + 1, orderID);
//				return true;
//			}
//		}
//		this.orderIDs.add(orderID);
//		return true;
//	}
	



	/**
	 * GENERAL METHODS
	 * ________________________________________________________________________
	 */

//     public boolean cancelOrder(String ID) {
//         return this.orderIDs.remove(ID);
//     }

	public boolean AuthenticateCred(String username, String password) {
		// TODO possibly add another hash algorithm here for safety
		if(this.username == username && this.password == password) return true;
		else return false;
	}
}
