package cs333.project_2.DOM.Product;

import java.util.ArrayList;
import java.util.List;

import cs333.project_2.DOM.Rating.Rating;

public class Product {

	private String ID;
	private String sellerID;
	private String name;
	private double price;
	private String description;
	private double rating;
	private int totalRating = 0;
	private List<Rating> Ratings = new ArrayList<Rating>();

	public Product() {}
	
	public Product(String ID, String sellerID, String name, double price, String Description) {
		this.ID = ID;
		this.sellerID = sellerID;
		this.name = name;
		this.price = price;
		this.description = Description;
		this.rating = -1; // -1 indicates no ratings yet
	}

	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */
	
	public void setID(String ID) {
		this.ID = ID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSellerID(String ID) {
		this.sellerID = ID;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public void setDescription(String Description) {
		this.description = Description;
	}

	public void setRating(double rat) {
		this.rating = rat;
	}
	
	public boolean addRating(Rating rating) {
		if (rating.getRateval() < 0 || rating.getRateval() > 10) return false;
		// Update the current average rating of the product
		this.totalRating += rating.getRateval();
		this.Ratings.add(rating);
		this.rating = this.totalRating / this.Ratings.size();
		return true;
	}

	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */
	
	public String getID() {
		return this.ID;
	}
	public String getName() {
		return this.name;
	}
	public String getSellerID() {
		return this.sellerID;
	}

	public double getPrice() {
		return this.price;
	}

	public double getRating() {
		return this.rating;
	}

	public String getDescription() {
		return this.description;
	}
}
