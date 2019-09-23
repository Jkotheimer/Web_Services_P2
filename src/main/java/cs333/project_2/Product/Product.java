package cs333.project_2.Product;

public class Product
{
    String ID;
    int Price;
    String SellerID;
    int Rating;
    String ItemDescrip;

    public boolean setID(String id) {
		this.ID = id;
		return true;
	}
	public boolean setsellerID(String sellerid) {
        this.SellerID = sellerid;
		return true;
	}
	public boolean setPrice(int price) {
        this.Price = price;
		return true;
    }
    public boolean setRating(int rating) {
        this.Rating = rating;
		return true;
    }
    public boolean setItemDescrip(String itemdescrip) {
        this.ItemDescrip = itemdescrip;
		return true;
    }

    public String getID() {
        return this.ID;
	}
	public String getsellerID() {
        return this.SellerID;
	}
	public int getPrice() {
        return this.Price;
    }
    public int getRating() {
        return this.Rating;
    }
    public String getItemDescrip() {
        return this.ItemDescrip;
    }
}