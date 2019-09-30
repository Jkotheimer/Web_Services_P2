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

<<<<<<< HEAD
	private final int ID;
	private final int SellerID;
=======
	private int productID;

	private int sellerID;
>>>>>>> 5702834c98956e625b6dc1671306b5afd4b8d612
	private String ItemDescrip;
	private float Rating;
	private int NumRatings;
	private double Price;

	private static final Utility database = new Utility();

<<<<<<< HEAD
	public Product(int ID, float price, int sellerID, String itemDescrip) {
		this.ID = ID;
		this.Price = price;
		this.SellerID = sellerID;
		this.ItemDescrip = itemDescrip;
		this.Rating = -1; // -1 indicates no ratings yet
		this.NumRatings = 0;
=======
	public Product() {

>>>>>>> 5702834c98956e625b6dc1671306b5afd4b8d612
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

<<<<<<< HEAD
	public int getID()				{ return this.ID; }
	public int getSellerID()		{ return this.SellerID; }
	public float getPrice()			{ return this.Price; }
	public float getRating()		{ return this.Rating; }
	public String getItemDescrip()	{ return this.ItemDescrip; }
=======
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
>>>>>>> 5702834c98956e625b6dc1671306b5afd4b8d612
}
