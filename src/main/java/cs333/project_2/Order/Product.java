package cs333.project_2.Order;

import cs333.project_2.General.Utility;
import cs333.project_2.Profile.*;
import cs333.project_2.Order.*;

public class Product {

	private final int ID;
	private final int SellerID;
	private String ItemDescrip;
	private float Rating;
	private int NumRatings;
	private float Price;
	private int Stock;
	
	private static final Utility database = new Utility();

	public Product(int ID, float price, int sellerID, String itemDescrip, int Stock) {
		this.ID = ID;
		this.Price = price;
		this.SellerID = sellerID;
		this.ItemDescrip = itemDescrip;
		this.Rating = -1f; // -1 indicates no ratings yet
		this.NumRatings = 0;
		this.Stock = Stock;
	}

	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */

	public boolean setPrice(float price) {
		this.Price = price;
		return true;
	}
	public float addRating(float rating) {
		if(rating < 0 || rating > 10) return -1f;
		// Update the current average rating of the product
		this.Rating = ((NumRatings * this.Rating) + rating) / ++NumRatings;
		return this.Rating;
	}
	public boolean setItemDescrip(String itemdescrip) {
		this.ItemDescrip = itemdescrip;
		return true;
	}
	public int increaseStock(int numProduct) {
		this.Stock += numProduct;
		return this.Stock;
	}
	public int purchase(int numProduct) {
		if(this.Stock - numProduct < 0) return -1;
		else this.Stock -= numProduct;
		return this.Stock;
	}
	
	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */

	public int getID()				{ return this.ID;			}
	public int getSellerID()		{ return this.SellerID;		}
	public float getPrice()			{ return this.Price;		}
	public float getRating()		{ return this.Rating;		}
	public int getStock()			{ return this.Stock;		}
	public String getItemDescrip()	{ return this.ItemDescrip;	}
}
