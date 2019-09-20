package cs333.project_2.Profile;

import java.util.ArrayList

public class Seller implements Profile {

	private String username;
	private String password;
	private String ID;
	private ArrayList<String> orders;
	private Address address;

	public Seller(String username, String password, String ID, Address address) {
		this.username = username;
		this.password = password;
		this.ID = ID;
		this.address = address;
	}

	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */

	public String getUsername()				{ return this.username;	}
	public String getID()					{ return this.ID;		}
	public ArrayList<String> getOrders()	{ return this.orders;	}
	public Address getAddress()				{ return this.address;	}

	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */

	public boolean setUsername(String username) {
		// TODO - possibly add a database check for other profiles with the given username
		this.username = username;
		return true;
	}
	public boolean setPassword(String password) {
		// TODO - possibly do a check to see if the password is secure enough or if the password has been used before
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
		}
		// Else, iterate through the orders and add the given ID in numeric order
		for(int i = 0; i < this.orders.size(); i++) {
			if(orderID.compareToIgnoreCase(this.orders.get(i)) > 0 && orderID.compareToIgnoreCase(this.order.get(i + 1)) < 0)
				orders.add(i, orderID);
			if(orderID == this.orders.get(i)) {
				System.err.println("This seller already has an order with ID: " + orderID);
				return false;
			}
		}
		return true;
	}

	/**
	 * GENERAL METHODS
	 * ________________________________________________________________________
	 */

	public boolean AuthenticateCred(String username, String password) {
		if(this.username == username && this.password == password) return true;
		else return false;
	}
}
