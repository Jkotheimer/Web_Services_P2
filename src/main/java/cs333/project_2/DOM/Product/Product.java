package cs333.project_2.DOM.Product;

import java.util.ArrayList;
import java.util.List;

import cs333.project_2.DAL.Product.ProductDAL;
import cs333.project_2.DOM.Seller.Seller;
import cs333.project_2.DOM.Rating.Rating;

public class Product {

	private String productID;
	private double Price;
	private Seller seller;
	private String ItemDescrip;
	private float Rating;
	private int totalRating = 0;
	private List<Rating> Ratings = new ArrayList<Rating>();

	public Product() {
	
	}
	
	public Product(String ID, float price, String itemDescrip, Seller producer) {
		this.productID = ID;
		this.Price = price;
		this.ItemDescrip = itemDescrip;
		this.seller = producer;
		this.Rating = -1; // -1 indicates no ratings yet
	}

	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */
	
	public void setproductID(String productId) {
		this.productID = productId;
	}

	public void setPrice(double price) {
		Price = price;
	}
	public void setItemDescrip(String itemdescrip) {
		this.ItemDescrip = itemdescrip;
	}

	public void setRating(float rat) {
		this.Rating = rat;
	}
	
	public void setSeller(Seller seller) {
		this.seller = seller;
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
	
	public String getProductID() {
		return this.productID;
	}

	public double getPrice() {
		return this.Price;
	}

	public float getRating() {
		return this.Rating;
	}

	public String getItemDescrip() {
		return this.ItemDescrip;
	}

	public Seller getSeller() {
		return this.seller;
	}
}
