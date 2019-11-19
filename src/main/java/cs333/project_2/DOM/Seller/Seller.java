package cs333.project_2.DOM.Seller;

import cs333.project_2.DOM.Product.Product;
import cs333.project_2.DOM.Rating.Rating;

import java.util.ArrayList;
import java.util.List;

public class Seller {
	
	private String username;
	private String password;
	private String sellerID;
	private String urlAddress;
	private List<Product> products = new ArrayList<Product>();
	private List<Rating> ratings = new ArrayList<Rating>();
	
	public Seller() {}

	public Seller(String ID, String username, String password) {
		this.username = username;
		this.password = password;
		this.sellerID = ID;
		this.urlAddress = "";
	}
	
	public Seller(String ID, String urlAddress, String username, String password) {
		this.username = username;
		this.password = password;	
		this.sellerID = ID;
		this.urlAddress = urlAddress;
	}

	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */

	public String getUsername()				{ return this.username;		}

	public String getSellerID()				{ return this.sellerID;		}
	
	public String geturlAddress()			{ return this.urlAddress;	}

	public List<Product> getProducts()		{ return this.products;		}
	
	public List<Rating> getRatings()		{ return this.ratings;		}

	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */

	public boolean setUsername(String username) {
		// TODO - possibly add a database check for other profiles with the given username
		this.username = username;
		return true;
	}
	
	public boolean seturlAddress(String urlAddress) {
		this.urlAddress = urlAddress;
		return true;
	}
	
	public boolean setPassword(String password) {
		// If the password has been used before, inform the user and have them change it to something else
		if(this.password == password) return false;
		this.password = password;
		return true;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public void addProduct(Product product) {
		this.products.add(product);	
	}
	
	public void addRating(Rating rating) {
		this.ratings.add(rating);
	}

	/**
	 * GENERAL METHODS
	 * ________________________________________________________________________
	 */
	
	public boolean removeProduct(Product ID) {
		return this.products.remove(ID);
	}
	public boolean AuthenticateCred(String username, String password) {
		// TODO possibly add another hash algorithm here for safety
		if(this.username == username && this.password == password) return true;
		else return false;
	}
}
