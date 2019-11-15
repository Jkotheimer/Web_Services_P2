package cs333.project_2.DOM.Product;

import java.util.List;

import cs333.project_2.DAL.Seller.SellerDAL;

public class ProductManager {
	
	public List<Product> getProducts() {
		return SellerDAL.getProducts();
	}
	
	public Product getProduct(String ID) {
		return SellerDAL.readProduct(ID);
	}
	
	public void addProduct(String SellerID, String prodName, float price, String prodDesc) {
		SellerDAL.insertProduct(SellerID, prodName, price, prodDesc);
	}

	public void updateProduct(String prodName, float price, String prodDesc) {
		SellerDAL.updateProduct(prodName, price, prodDesc);
	}

	public void deleteProduct(String ID) {
		SellerDAL.deleteProduct(ID);
	}

}