package cs333.project_2.DOM.Seller;

import java.util.List;

import cs333.project_2.DAL.Seller.SellerDAL;
import cs333.project_2.DOM.Seller.Seller;

public class SellerManager {
	
	public static List<Seller> getSellers(){
		return SellerDAL.getSellers();
	}
	
	public static Seller insertSeller(String username, String password) {
		return SellerDAL.addSeller(username, password);
	}

	public static Seller login(String username, String password) {
		return SellerDAL.readSeller(username, password);
	}
	
	public static int changePassword(String ID, String current_password, String new_password) {
		return SellerDAL.updateSeller(ID, current_password, new_password);
	}
	
	public static Seller changeUsername(String ID, String username) {
		return SellerDAL.updateSeller(ID, username);
	}
	
	public static int deleteSeller(String ID) {
		return SellerDAL.deleteSeller(ID);
	}
}
