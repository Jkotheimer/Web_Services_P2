package cs333.project_2.Profile;

import cs333.project_2.Profile.PaymentInfo;
import java.util.ArrayList;

public class Buyer implements Profile{
   
    private String username;
	private String password;
	private String ID;
	private ArrayList<String> orders;
	private Address address;
	private PaymentInfo payinfo;

	public Buyer(String username, String password, String ID, Address address) {
		this.username = username;
		this.password = password;
		this.ID = ID;
		this.address = address;
		this.orders = new ArrayList<>();
	}

	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */

    public String[] getStatus()             { return new String[] {"all good","not delivered"};}
	public String getUsername()				{ return this.username;	}
	public String getID()					{ return this.ID;		}
	public ArrayList<String> getOrders()	{ return this.orders;	}
    public Address getAddress()				{ return this.address;	}
    public PaymentInfo getPayInfo()         { return this.payinfo;  }

	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */

    public boolean setPayInfo(PaymentInfo pay){
        this.payinfo = pay;
        return true;
    }

	public boolean setUsername(String username) {
		// TODO - possibly add a database check for other profiles with the given username
		this.username = username;
		return true;
	}
	public boolean setPassword(String password) {
		// TODO - possibly do a check to see if the password is secure enough and add another hashing algorithm for safety

		// If the password has been used before, inform the user and have them change it to something else
		if(this.password == password) return false;
		this.password = password;
		return true;
	}
	public boolean setAddress(Address address) {
		// TODO - possibly do some sort of regex check or Google maps check on the Address to see if it's valid
		this.address = address;
		return true;
	}
	public boolean addOrder(String orderID) {
		// If there are no orders in the list, just add the given ID
		if(this.orders.size() == 0) {
			this.orders.add(orderID);
			return true;
		} else if(this.orders.size() == 1) {
			if(orderID.compareToIgnoreCase(this.orders.get(0)) > 0) this.orders.add(orderID);
			else this.orders.add(0, orderID);
			return true;
		}
		// Else, iterate through the orders and add the given ID in numeric order
		for(int i = 0; i < this.orders.size() - 1; i++) {
			if(orderID == this.orders.get(i)) {
				System.err.println("This buyer already has an order with ID: " + orderID);
				return false;
			}
			if(orderID.compareToIgnoreCase(this.orders.get(i)) > 0 && orderID.compareToIgnoreCase(this.orders.get(i + 1)) < 0) {
				if(i == this.orders.size()) this.orders.add(orderID);
				else this.orders.add(i, orderID);
				return true;
			}
		}
		return false;
	}

	/**
	 * GENERAL METHODS
	 * ________________________________________________________________________
	 */

    public boolean placeOrder(){
        return true;
    }

    public boolean cancelOrder(){
        return true;
    }

	public boolean AuthenticateCred(String username, String password) {
		// TODO possibly add another hash algorithm here for safety
		if(this.username == username && this.password == password) return true;
		else return false;
	}
}