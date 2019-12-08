package cs333.project_2.DOM.Product;

import java.util.List;

import cs333.project_2.DAL.Seller.SellerDAL;

public class ProductManager {
	
	public List<Product> getProducts() {
		return SellerDAL.getProducts();
	}
	
	public List<Product> getProducts(String sellerID) {
		return SellerDAL.getProducts(sellerID);
	}
	
	public Product getProduct(String name) {
		return SellerDAL.readProduct(name);
	}
	
	public Product addProduct(String SellerID, String prodName, double price, String prodDesc) {
		return SellerDAL.addProduct(SellerID, prodName, price, prodDesc);
	}

	public Product updateProduct(String ID, String name, double price, String prodDesc) {
		return SellerDAL.updateProduct(ID, name, price, prodDesc);
	}

	public int deleteProduct(String ID) {
		return SellerDAL.deleteProduct(ID);
	}

}