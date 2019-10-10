package cs333.project_2.DOM.Seller;
import cs333.project_2.DOM.General.Address;
import java.util.ArrayList;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
@Table(name="seller")
public class Seller {

	private String username;
	private String password;
	private final int ID;
	private String urlAddress;

	private ArrayList<String> products;
	private ArrayList<String> orders;

	private Address address;

	private float rating;
	private int numRatings;

	public Seller(String username, String password, int ID, Address address, String urladdress) {
		this.username = username;
		this.password = password;
		this.ID = ID;
		this.address = address;
		this.urlAddress = urladdress;
		this.rating = -1; //negative 1 represents no ratings yet
		this.numRatings = 0;
		this.orders = new ArrayList<>();
		this.products = new ArrayList<>();
	}

	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */

	@Column(name="sellerusername")
	public String getUsername()				{ return this.username;	}

	@Id
	@Column(name="sellerID")
	public int getID()						{ return this.ID;		}

	@Column(name="sellerurladdress")
	public String geturlAddress()			{ return this.urlAddress;}

	@Column(name="selleraddress")
	public String getAddressString()		{ return this.address.ConvertAddresstoString();	}
	
	public Address getAddress()				{ return this.address; }

	@Column(name="rating")
	public float getRating()				{ return this.rating;	}

	@Transient
	public ArrayList<String> getOrders()	{ return this.orders;	}

	@Transient
	public ArrayList<String> getProducts()	{ return this.products;	}

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
	public boolean addRating(float ratingnum) {
		if(ratingnum < 0 || ratingnum > 10) return false;
		this.rating = ((numRatings * this.rating) + ratingnum) / ++numRatings;
		return true;
	}
	public boolean addProduct(String productID) {
		// Add the new product ID in the correct alphabetical position
		if(this.products.size() == 0) {
			this.products.add(productID);
			return true;
		} else if(this.products.size() == 1) {
			if(productID.compareTo(this.products.get(0)) > 0) this.products.add(productID);
			else this.products.add(0, productID);
			return true;
		} else if(productID.compareTo(this.products.get(0)) < 0) {
			this.products.add(0, productID);
			return true;
		}
		// If we've passed the first two elements, it's time to start iterating
		for(String p : this.products) if(productID.equals(p)) return false;
		for(int i = 0; i < this.products.size() - 1; i++) {
			if(productID.compareTo(this.products.get(i)) > 0 && productID.compareTo(this.products.get(i + 1)) < 0) {
				this.products.add(i + 1, productID);
				return true;
			}
		}
		this.products.add(productID);
		return true;
	}
	public boolean addOrder(String orderID) {
		// Add the new order ID in the correct alphabetical position
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
		// If we've passed the first two elements, it's time to start iterating
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

	/**
	 * GENERAL METHODS
	 * ________________________________________________________________________
	 */
	
	public boolean cancelOrder(String ID) {
		return this.orders.remove(ID);
	}
	public boolean removeProduct(String ID) {
		return this.products.remove(ID);
	}
	public boolean AuthenticateCred(String username, String password) {
		// TODO possibly add another hash algorithm here for safety
		if(this.username == username && this.password == password) return true;
		else return false;
	}
}
