package cs333.project_2.DOM.Seller;

import java.util.List;

import cs333.project_2.DAL.Seller.SellerDAL;
import cs333.project_2.DOM.Product.Product;
import cs333.project_2.DOM.Seller.Seller;

public class SellerManager {
	
	private SellerDAL sellerDAL = new SellerDAL();
	
	public List<Seller> getSellers(){
		return sellerDAL.getSellers();
	}
	
	public void insertSeller(String Id, String username, String password) {
		sellerDAL.insertSeller(Id, username, password);
	}
	
	public void insertSeller(String Id, String urlAddress, String username, String password) {
		sellerDAL.insertSeller(Id, urlAddress, username, password);
	}

	public Seller readSeller(String ID) {
		return sellerDAL.readSeller(ID);
	}
	
	public void updateSeller(String ID,String newusername, String newpassword) {
		sellerDAL.updateSeller(ID, newusername, newpassword);
	}
	
	public void updateSeller(String ID, String urlAddress, String username, String password) {
		sellerDAL.updateSeller(ID, urlAddress, username, password);
	}
	
	public void deleteSeller(String ID) {
		sellerDAL.deleteSeller(ID);
	}
}
