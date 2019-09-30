package cs333.project_2.Order;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import cs333.project_2.General.Utility;
import cs333.project_2.Profile.*;

@Entity
@Table(name = "product")
public class Product {

	private int productID;

	private int sellerID;
	private String ItemDescrip;
	private float Rating;
	private int NumRatings;
	private double Price;

	private static final Utility database = new Utility();

	public Product() {

	}

	
	 public Product(int productID, int sellerID, double Price,float rating,
	  String itemDescrip) 
	 { 
	  this.productID = productID;
	  this.Price = Price;
	  this.sellerID = sellerID;
	  this.Rating = rating; 
	  this.ItemDescrip = itemDescrip; 
	  this.NumRatings = 0; }
	 
	 
	


	


	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */


	public void setProductID(int productID) {
		this.productID = productID;
	}
	public void setPrice(double price) {
		Price = price;
	}

	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}

	public void setRating(float rating) {
		this.Rating = rating;
	}

	public boolean addRating(int rating) {
		if (rating < 0 || rating > 10)
			return false;
		// Update the current average rating of the product
		this.Rating = ((NumRatings * this.Rating) + rating) / ++NumRatings;
		return true;
	}

	public void setItemDescrip(String itemdescrip) {
		this.ItemDescrip = itemdescrip;
	}

	public void setNumRatings(int numRatings) {
		NumRatings = numRatings;
	}

	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */
	@Id
	@Column(name="productid")
	public int getProductID() {
		return productID;
	}
	
	@Column(name = "sellerID")
	public int getsellerID() {
		return sellerID;
	}

	@Column(name = "price")
	public double getPrice() {
		return this.Price;
	}

	@Column(name = "rating")
	public float getRating() {
		return this.Rating;
	}

	@Column(name = "description")
	public String getItemDescrip() {
		return this.ItemDescrip;
	}

	@Transient
	public int getNumRatings() {
		return NumRatings;
	}

	@Transient
	public static Utility getDatabase() {
		return database;
	}
//@Column(name="seller")
//	public Seller getSeller()		{ return database.getSeller(this.ID); }
}
