package cs333.project_2.DOM.Seller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cs333.project_2.DAL.Seller.SellerDAL;
import cs333.project_2.DOM.Product.Product;
import cs333.project_2.DOM.Seller.Seller;

public class SellerManager {
	
	public List<Seller> getSellers(){
		return SellerDAL.getSellers();
	}
	
	public static void insertSeller(String Id, String username, String password) {
		SellerDAL.insertSeller(Id, username, password);
	}

	public static Seller readSeller(String ID) {
		return SellerDAL.readSeller(ID);
	}
	
	public static void updateSeller(String ID,String newusername, String newpassword) {
		SellerDAL.updateSeller(ID, newusername, newpassword);
	}
	
	public static void deleteSeller(String ID) {
		SellerDAL.deleteSeller(ID);
	}
}
