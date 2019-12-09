package cs333.project_2.Service.Representation;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import cs333.project_2.DOM.Rating.Rating;
import cs333.project_2.Service.AbstractRepresentation;

@XmlRootElement
public class ProductRepresentation extends AbstractRepresentation{
	
	private String name;
	private double Price;
	private String ID;
	private String sellerID;
	private String description;
	private double Rating;
	private int totalRating = 0;
	private List<Rating> Ratings = new ArrayList<Rating>();

	public ProductRepresentation() {
	
	}
	
	public ProductRepresentation(String ID, String sellerID, String name, double price, String itemDescrip) {
		this.ID = ID;
		this.name = name;
		this.Price = price;
		this.description= itemDescrip;
		this.sellerID = sellerID;
		this.Rating = -1; // -1 indicates no ratings yet
	}

	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */
	
	public void setID(String ID) {
		this.ID = ID;
	}
	public void setName(String Name) {
		this.name = Name;
	}

	public void setPrice(double price) {
		Price = price;
	}
	public void setDescription(String itemdescrip) {
		this.description = itemdescrip;
	}

	public void setRating(double rat) {
		this.Rating = rat;
	}
	
	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}
	
	public boolean addRating(Rating rating) {
		if (rating.getRateval() < 0 || rating.getRateval() > 10) return false;
		// Update the current average rating of the product
		this.totalRating += rating.getRateval();
		this.Ratings.add(rating);
		this.Rating = this.totalRating / this.Ratings.size();
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

	public double getPrice() {
		return this.Price;
	}

	public double getRating() {
		return this.Rating;
	}

	public String getDescription() {
		return this.description;
	}

	public String getSellerID() {
		return this.sellerID;
	}

}
