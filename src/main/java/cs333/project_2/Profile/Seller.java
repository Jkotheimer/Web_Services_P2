package cs333.project_2.Profile;
import cs333.project_2.Product.Product;
import java.util.ArrayList;

public class Seller implements Profile {

	private String username;
	private String password;
	private String ID;
	private ArrayList<String> orders;
	private Address address;
	private int rating;
	private Product[] products;
	private String urlAddress;

	public Seller(String username, String password, String ID, Address address, String urladdress) {
		this.username = username;
		this.password = password;
		this.ID = ID;
		this.address = address;
		this.urlAddress = urladdress;
		this.rating = -1; //negative 1 represents no ratings yet
	}

	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */

	public String getUsername()				{ return this.username;	}
	public String getID()					{ return this.ID;		}
	public ArrayList<String> getOrders()	{ return this.orders;	}
	public Address getAddress()				{ return this.address;	}
	public String geturlAdress()			{ return this.urlAddress;}
	public int getRating()					{ return this.rating;}
	public Product[] getProducts()			{ return this.products;}

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
			if(orderID.compareToIgnoreCase(this.orders.get(i)) > 0 && orderID.compareToIgnoreCase(this.orders.get(i + 1)) < 0)
				orders.add(i, orderID);
			if(orderID == this.orders.get(i)) {
				System.err.println("This seller already has an order with ID: " + orderID);
				return false;
			}
		}
		return true;
	}
	public boolean seturlAdress(String url)			
	{ 
		this.urlAddress = url;
		return true;
	}
	public boolean setRating(int ratingnum)					
	{
		this.rating = ratingnum;
		return true;
	}
	public boolean setProducts(Product[] productsnew)			
	{
		this.products = productsnew;
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
