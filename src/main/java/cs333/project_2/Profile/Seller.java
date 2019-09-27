package cs333.project_2.Profile;

import cs333.project_2.Order.*;
import java.util.ArrayList;

public class Seller extends Profile {

	private String username;
	private String password;
	private String ID;
	private String urlAddress;

	private ArrayList<Product> products;
	private ArrayList<String> orders;

	private Address address;

	private float rating;
	private int numRatings;

	public Seller(String username, String password, String ID, Address address, String urladdress) {
		this.username = username;
		this.password = password;
		this.ID = ID;
		this.address = address;
		this.orders = new ArrayList<>();
		this.urlAddress = urladdress;
		this.rating = -1; //negative 1 represents no ratings yet
	}

	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */

	public String getUsername()				{ return this.username;	}
	public String getID()					{ return this.ID;		}
	public String geturlAddress()			{ return this.urlAddress;}
	public Address getAddress()				{ return this.address;	}
	public float getRating()				{ return this.rating;	}
	public ArrayList<String> getOrders()	{ return this.orders;	}
	public ArrayList<Product> getProducts()	{ return this.products;	}
	public Product getProduct(String ID)	{
		// TODO : perform a binary search since the IDs are sorted
		for(Product p : products) if(p.getID() == ID) return p;
		return null;
	}

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
		// TODO - possibly do a check to see if the password is secure enough and add another hashing algorithm for safety

		// If the password has been used before, inform the user and have them change it to something else
		if(this.password == password) return false;
		this.password = password;
		return true;
	}
	public boolean seturlAddress(String url) {
		this.urlAddress = url;
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
			if(orderID.compareTo(this.orders.get(0)) > 0) this.orders.add(orderID);
			else this.orders.add(0, orderID);
			return true;
		} else if(orderID.compareTo(this.orders.get(0)) < 0) {
			this.orders.add(0, orderID);
			return true;
		}
		// Else, iterate through the orders and add the given ID in numeric order
		for(String o : this.orders) if(orderID.equals(o)) return false;
		for(int i = 0; i < this.orders.size() - 1; i++) {
			if(orderID.compareTo(this.orders.get(i)) > 0 && orderID.compareTo(this.orders.get(i + 1)) < 0) {
				this.orders.add(i + 1, orderID);
				return true;
			}
		}
		this.orders.add(orderID);
		return true;
	}
	public boolean addRating(float ratingnum) {
		if(ratingnum < 0 || ratingnum > 10) return false;
		this.rating = ((numRatings * this.rating) + ratingnum) / ++numRatings;
		return true;
	}
	public boolean addProduct(Product product) {
		this.products.add(product);
		return true;
	}

	/**
	 * GENERAL METHODS
	 * ________________________________________________________________________
	 */

	public boolean AuthenticateCred(String username, String password) {
		// TODO possibly add another hash algorithm here for safety
		if(this.username == username && this.password == password) return true;
		else return false;
	}
}
