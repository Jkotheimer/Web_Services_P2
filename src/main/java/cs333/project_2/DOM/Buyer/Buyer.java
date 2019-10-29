package cs333.project_2.DOM.Buyer;

import cs333.project_2.DOM.General.Address;
import cs333.project_2.DOM.General.PaymentInfo;
import cs333.project_2.DOM.Order.Order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name="buyer")

public class Buyer implements Serializable  {

	private int serialId;
	

	private String username;
	private String password;
	private int buyerID;
	//private Address address;
	private String address;
	
	private List<Order> orders = new ArrayList<>();
	//Should be the same order ID in order class as a primary key
	
	
	//private List<Address> addresslist = new ArrayList<>();
	//private ArrayList<PaymentInfo> payinfo; // Allow buyers to have multiple payment options

//	public Buyer(String username, String password, int ID, String address, List<Order> order) {
//		this.username = username;
//		this.password = password;
//		this.ID = ID;
//		this.address = address;	
//		//this.orderIDs = new ArrayList<>();
//		this.orderIDs = order;
//		//this.payinfo = new ArrayList<>();
//	}
	
	public Buyer() {
		
	}
	
	//For Buyer Activity Class
	public Buyer(int ID, String username, String address) {
		this.buyerID = ID;
		this.username = username;
		this.address = address;
	}


	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */
	@Id
	@Column(name = "serialID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getSerialId() {
		return serialId;
	}

//	@OneToOne( mappedBy="buyer", targetEntity=Order.class)
    @Column(name = "buyerusername")
	public String getUsername()					{ return this.username;	}

	
	@Column(name = "buyerID")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	public int getBuyerID()						    {  return this.buyerID;		}

	@Column(name="buyeraddress")
	public String getAddress()			{
		return this.address;
	}
	
	
//	public List<Address> getAddress()					{
//		return this.addresslist;
//	}
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="buyer", targetEntity=Order.class)
	//@JoinColumn(name="buyerID", insertable = false,updatable = false)
	public List<Order> getOrderIDs()		{ 		
		return this.orders;	
		}
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
	
	public void setSerialId(int serialId) {
		this.serialId = serialId;
	}
	

	public boolean setUsername(String username) {
		// TODO - possibly add a database check for other profiles with the given username
		this.username = username;
		return true;
	}

	

	public void setbuyerID(int iD) {
		this.buyerID = iD;
	}

	public void setOrderIDs(List<Order> orderIDs) {
		this.orders = orderIDs;
	}

	public boolean setPassword(String password) {
		// If the password has been used before, inform the user and have them change it to something else
		if(this.password == password) return false;
		this.password = password;
		return true;
	}
	

	public void setAddressString(String address)			{
		this.address = address;
	}

	public boolean setAddress(String address) {
		this.address = address;
		return true;
	}
	
	
//	public boolean addOrder(Integer orderID) {
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
//		for(Integer o : this.orderIDs) if(orderID.equals(o)) return false;
//		for(int i = 0; i < this.orderIDs.size() - 1; i++) {
//			if(orderID.compareTo(this.orderIDs.get(i)) > 0 && orderID.compareTo(this.orderIDs.get(i + 1)) < 0) {
//				this.orderIDs.add(i + 1, orderID);
//				return true;
//			}
//		}
//		this.orderIDs.add(orderID);
//		return true;
//	}
//	


	public boolean setID(int ID) {
		// I don't think it would be smart to have dynamic IDs
		return false;
	}


	/**
	 * GENERAL METHODS
	 * ________________________________________________________________________
	 */

	public boolean AuthenticateCred(String username, String password) {
		// TODO possibly add another hash algorithm here for safetyaaaaa
		if(this.username == username && this.password == password) return true;
		else return false;
	}
	
	@Transient
	public String getPassword() {
		return password;
	}
}
	
