package cs333.project_2.DOM.Product;
import cs333.project_2.DAL.Product.ProductDAL;

import java.util.HashSet;
import java.util.Set;

public class ProductManager {
	
	public Set<Product> getProducts() {
		Set<Product> products = new HashSet<Product>();
		Product a = new Product(123,12,"A Great Product");
		Product b = new Product(124,11,"A Great Product to Behold");
		Product c = new Product(125,9,"A Great Product Sometimes");
		products.add(a);
		products.add(b);
		products.add(c);
		return products;
	}
	
	public Product getProduct(int id) {
		return ProductDAL.readProduct(id);
	}
	

	public void addProduct(int ID, int sellerID, float price, String itemDescrip) {
		ProductDAL.createProduct(ID, sellerID, price, itemDescrip);
	}

	public void updateProduct(int ID, int sellerID, float price, String itemDescrip) {
		ProductDAL.updateProduct(ID, sellerID, price, itemDescrip);
	}

	public void deleteProduct(int id) {
		ProductDAL.deleteProduct(id);
	}

}