package cs333.project_2.DOM.Product;

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

import cs333.project_2.DAL.Product.ProductDAL;

@Entity
@Table(name = "product")
public class Product {

	private int ID;
	private double Price;
	private int SellerID;
	private String ItemDescrip;

	private float Rating;
	private int NumRatings;

	public Product() {
	
	}
	
	public Product(int ID, int sellerID, float price, String itemDescrip) {
		this.ID = ID;
		this.Price = price;
		this.SellerID = sellerID;
		this.ItemDescrip = itemDescrip;

		this.Rating = -1; // -1 indicates no ratings yet
		this.NumRatings = 0;
	}

	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */
	public void setID(int Id) {
		this.ID = Id;
	}
	
	public void setSellerID(int Id) {
		this.SellerID = Id;
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
	
	public boolean addRating(int rating) {
		if (rating < 0 || rating > 10) return false;
		// Update the current average rating of the product
		this.Rating = ((NumRatings * this.Rating) + rating) / ++NumRatings;
		return true;
	}

	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */

	@Id
	@Column(name="productid")
	public int getID() {
		return this.ID;
	}

	@Column(name = "sellerID")
	public int getSellerID() {
		return this.SellerID;
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
}
