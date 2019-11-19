package cs333.project_2.DAL.Seller;

import cs333.project_2.DOM.Seller.Seller;
import cs333.project_2.DOM.Buyer.Buyer;
import cs333.project_2.DOM.Product.Product;
import cs333.project_2.DOM.Rating.Rating;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SellerDAL {
	
	// ProductDAL is here because they wont exist without a Seller attached, but separate DB allows for easier searching
	private static List<Seller> SellerDB = new ArrayList<Seller>(Arrays.asList(new Seller("acc1","gman","password1"),new Seller("acc2","gmon","password2"),new Seller("acc3","gmen","password3")));
	private static List<Product> ProductDB = new ArrayList<Product>();
	
	public SellerDAL() {}
	
	public static List<Seller> getSellers(){
		return SellerDB;
	}
	
	public static List<Product> getProducts(){
		return ProductDB;
	}
	
	public static void insertSeller(String Id, String username, String password) {
		SellerDB.add(new Seller(Id,username,password));
	}
	
	public static void insertSeller(String Id, String urlAddress, String username, String password) {
		SellerDB.add(new Seller(Id, urlAddress, username, password));
	}

	public static void insertProduct(String SellerID, String prodName, float price, String prodDesc) {
		for(Seller s : SellerDB) {
			if(s.getSellerID() == SellerID) {
				Product p = new Product(prodName, price, prodDesc, SellerID);
				s.addProduct(p);
				ProductDB.add(p);
			}
		}
	}
	
	public static Seller readSeller(String ID) {
		for(Seller s : SellerDB) if(s.getSellerID() == ID) return s;
		return null;
	}
	
	public static Product readProduct(String ID) {
		for(Product p : ProductDB) if(p.getProductID() == ID) return p;
		return null;
	}

	public static void updateSeller(String ID,String newusername, String newpassword) {
		for(Seller s : SellerDB) {
			if(s.getSellerID() == ID) {
				s.setUsername(newusername);
				s.setPassword(newpassword);
			}
		}
	}
	
	public static void updateSeller(String ID, String urlAddress, String username, String password) {
		for(Seller s : SellerDB) {
			if(s.getSellerID() == ID) {
				s.seturlAddress(urlAddress);
				s.setUsername(username);
				s.setPassword(password);
			}
		}
	}
	
	public static void updateProduct(String ID, float price, String prodDesc) {
		for(Product p : ProductDB) {
			if(p.getProductID() == ID) {
				p.setPrice(price);
				p.setItemDescrip(prodDesc);
			}
		}
	}

	public static void deleteSeller(String ID) {
		for(Seller s : SellerDB) if(s.getSellerID() == ID) SellerDB.remove(s);
	}
			
	public static void deleteProduct(String ID) {
		for(Product p : ProductDB) if(p.getProductID() == ID) ProductDB.remove(p);
	}
	
	public static void addProductReview(String prodID,String reviewname,int score, String reviewcontent) {
		for(Product p : ProductDB) if(p.getProductID() == prodID) p.addRating(new Rating(reviewname, score, reviewcontent));
	}

}

	



