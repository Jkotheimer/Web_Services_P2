package cs333.project_2.DOM.Product;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import cs333.project_2.DAL.Product.ProductDAL;
import cs333.project_2.DOM.Seller.Seller;

@Entity
@Table(name = "product")
public class Product {

	private int serialID;
	private int productID;
	private double Price;
	private Seller seller;
	private String ItemDescrip;

	private float Rating;
	private int NumRatings;

	public Product() {
	
	}
	
//	public Product(int ID, int sellerID, float price, String itemDescrip) {
//		this.ID = ID;
//		this.Price = price;
//		this.seller = sellerID;
//		this.ItemDescrip = itemDescrip;
//
//		this.Rating = -1; // -1 indicates no ratings yet
//		this.NumRatings = 0;
//	}

	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */
	
	public void setserialID(int serialId) {
		this.serialID = serialId;
	}
	
	public void setproductID(int productId) {
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
	@Column(name = "serialID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getSerialID() {
		return serialID;
	}
	
	
	@Column(name="productid")
	public int getProductID() {
		return this.productID;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
        @JoinColumn(name="Seller_ID", referencedColumnName="sellerID"),
        @JoinColumn(name="Seller_URL_ADDR", referencedColumnName="sellerurladdress")
    })
	public Seller getSeller() {
		return this.seller;
	}
}
