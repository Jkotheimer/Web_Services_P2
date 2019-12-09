package cs333.project_2.DAL.Seller;

import cs333.project_2.DOM.Seller.Seller;
import cs333.project_2.DOM.Product.Product;
import cs333.project_2.DOM.Rating.Rating;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class SellerDAL {
	
	// ProductDAL is here because they wont exist without a Seller attached, but separate DB allows for easier searching
	private static List<Seller> SellerDB = new ArrayList<Seller>(Arrays.asList(new Seller("acc1","gman","password1"),new Seller("acc2","gmon","password2"),new Seller("acc3","gmen","password3")));
	private static List<Product> ProductDB = new ArrayList<Product>(Arrays.asList(
				new Product(UUID.randomUUID().toString(), "acc1", "product 1", 12.99, "A nice fresh new product for you"),
				new Product(UUID.randomUUID().toString(), "acc1", "product 2", 43.95, "Am even better fresh new product for you"),
				new Product(UUID.randomUUID().toString(), "acc2", "new product", 22.45, "A nice mediocre fresh new product for you"),
				new Product(UUID.randomUUID().toString(), "acc2", "new item", 105.00, "A nice expenive new product for you"),
				new Product(UUID.randomUUID().toString(), "acc3", "item 1", 96.12, "A nice slightly less expensive new product for you"),
				new Product(UUID.randomUUID().toString(), "acc3", "item 2", 84.98, "A nice average new product for you")
			));
	
	public static List<Seller> getSellers(){
		return SellerDB;
	}
	
	/**
	 * SELLER SPECIFIC METHODS
	 */
	public static Seller addSeller(String username, String password) {
		String ID = UUID.randomUUID().toString();
		Seller s = new Seller(ID, username,password);
		SellerDB.add(s);
		return s;
	}
	
	public static Seller readSeller(String username, String password) {
		for(Seller s : SellerDB) if(s.AuthenticateCred(username, password)) return s;
		return null;
	}
	
	public static int updateSeller(String ID, String oldPassword, String newPassword) {
		//SerialID is the primary key here which you enter as a parameter for the row you wish to change
		for(Seller s : SellerDB) {
			if(s.getID().equals(ID)) {
				if(s.setPassword(oldPassword, newPassword)) return 200;
				else return 401;
			}
		}
		return 404;
	}
	
	public static Seller updateSeller(String ID, String username) {
		for(Seller s : SellerDB) {
			if(s.getID().equals(ID)) {
				s.setUsername(username);
				return s;
			}
		}
		return null;
	}

	public static int deleteSeller(String ID) {
		for(int i=0;i<SellerDB.size();i++) {
			if(SellerDB.get(i).getID().equals(ID)) {
				SellerDB.remove(i);
				return 200;
			}
		}
		return 400;
	}
	
	/**
	 * PRODUCT SPECIFIC METHODS
	 */
	
	public static List<Product> getProducts(String action, String query) {
		List<Product> products = new ArrayList<Product>();
		for(Product p : ProductDB) {
			if(action.equals("search_by_name") && p.getName().contains(query)) products.add(p);
			else if(action.equals("search_by_price") && p.getPrice() < Double.parseDouble(query)) products.add(p);
			else if(action.equals("sellerID") && p.getSellerID().equals(query)) products.add(p);
		}
		return products;
	}
	
	public static Product getProductById(String ID) {
		for(Product p : ProductDB) if(p.getID().equals(ID)) return p;
		return null;
	}

	public static Product addProduct(String sellerID, String name, double price, String prodDesc) {
		Product p = new Product(UUID.randomUUID().toString(), sellerID, name, price,prodDesc);
		ProductDB.add(p);
		return p;
	}
	
	public static Product updateProduct(String ID, String name, double price, String prodDesc) {
		for(Product p : ProductDB) {
			if(p.getID().equals(ID)) {
				p.setName(name);
				p.setPrice(price);
				p.setDescription(prodDesc);
				return p;
			}
		}
		return null;
	}
			
	public static int deleteProduct(String ID) {
		for(Product p : ProductDB) {
			if(p.getID().equals(ID)) {
				ProductDB.remove(p);
				return 200;
			}
		}
		return 404;
	}
	
	public static void addProductReview(String prodName,String reviewname,int score, String reviewcontent) {
		for(int i=0;i<ProductDB.size();i++) {
			if(ProductDB.get(i).getName().equals(prodName)) {
				Product change = ProductDB.get(i);
				Rating newrat = new Rating(reviewname,score,reviewcontent);
				change.addRating(newrat);
			}
		}		
	}

}

	



