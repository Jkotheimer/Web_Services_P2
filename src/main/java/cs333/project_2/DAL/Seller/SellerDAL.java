package cs333.project_2.DAL.Seller;

import cs333.project_2.DOM.Seller.Seller;
import cs333.project_2.DOM.Product.Product;
import cs333.project_2.DOM.Rating.Rating;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SellerDAL {
	
	// ProductDAL is here because they wont exist without a Seller attached, but separate DB allows for easier searching
	private static List<Seller> SellerDB = new ArrayList<Seller>(Arrays.asList(new Seller("acc1","gman","password1"),new Seller("acc2","gmon","password2"),new Seller("acc3","gmen","password3")));
	private static List<Product> ProductDB = new ArrayList<Product>(Arrays.asList(new Product("Smencil", 2,"A smelly pencil",SellerDB.get(1)),new Product("Smen", 4,"A smelly pen",SellerDB.get(1)),new Product("Keyring", 10,"A Keyring of exceptional quality",SellerDB.get(2))));
	
	public static List<Seller> getSellers(){
		return SellerDB;
	}
	
	public static List<Product> getProducts(){
		return ProductDB;
	}
	
	public static void insertSeller(String Id, String username, String password) {
		Seller toBeInserted = new Seller(Id,username,password);
		SellerDB.add(toBeInserted);
	}

	public static void insertProduct(String SellerID, String prodName, float price, String prodDesc) {
		for(int i=0;i<SellerDB.size();i++) {
			if(SellerDB.get(i).getsellerID() == SellerID) {
				Seller foundSeller = SellerDB.get(i);
				Product newProd = new Product(prodName,price,prodDesc,foundSeller);
				foundSeller.addProduct(newProd);
				ProductDB.add(newProd);
			}
		}
	}
	
	public static Seller readSeller(String ID) {
		for(int i=0;i<SellerDB.size();i++) {
			if(SellerDB.get(i).getsellerID() == ID) {
				Seller foundSeller = SellerDB.get(i);
				return foundSeller;
			}
		}
		return null;
	}
	
	public static Product readProduct(String ID) {
		for(int i=0;i<ProductDB.size();i++) {
			if(ProductDB.get(i).getProductID() == ID) {
				Product foundProduct = ProductDB.get(i);
				return foundProduct;
			}
		}
		return null;
	}

	public static void updateSeller(String ID,String newusername, String newpassword) {
		for(int i=0;i<SellerDB.size();i++) {
			if(SellerDB.get(i).getsellerID() == ID) {
				Seller change = SellerDB.get(i);
				change.setPassword(newpassword);
				change.setUsername(newusername);
			}
		}		
	}
	
	public static void updateProduct(String prodName, float price, String prodDesc) {
		for(int i=0;i<ProductDB.size();i++) {
			if(ProductDB.get(i).getProductID() == prodName) {
				Product change = ProductDB.get(i);
				change.setPrice(price);
				change.setItemDescrip(prodDesc);
			}
		}		
	}

	public static void deleteSeller(String ID) {
		for(int i=0;i<SellerDB.size();i++) {
			if(SellerDB.get(i).getsellerID() == ID) {
				SellerDB.remove(i);
			}
		}	
	}
			
	public static void deleteProduct(String ID) {
		for(int i=0;i<ProductDB.size();i++) {
			if(ProductDB.get(i).getProductID() == ID) {
				ProductDB.remove(i);
			}
		}	
	}
	
	public static void addProductReview(String prodName,String reviewname,int score, String reviewcontent) {
		for(int i=0;i<ProductDB.size();i++) {
			if(ProductDB.get(i).getProductID() == prodName) {
				Product change = ProductDB.get(i);
				Rating newrat = new Rating(reviewname,score,reviewcontent);
				change.addRating(newrat);
			}
		}		
	}

}

	



