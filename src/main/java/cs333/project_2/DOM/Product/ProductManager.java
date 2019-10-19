package cs333.project_2.DOM.Product;
import cs333.project_2.DAL.Product.ProductDAL;

public class ProductManager {
	
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