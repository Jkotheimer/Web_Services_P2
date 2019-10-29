package cs333.project_2.DOM.Buyer;

import java.util.HashSet;
import java.util.Set;

import cs333.project_2.DAL.Buyer.BuyerDAL;
import cs333.project_2.DOM.Seller.Seller;

public class BuyerManager {
	
	
	public static Set<Buyer> getBuyers() {
		// TODO grab the corresponding buyer object from the database
		Set<Buyer> buyers = new HashSet<Buyer>();
		Buyer b = new Buyer(123, "rayyanshaji", "6453 Winthrop Ave");
		buyers.add(b);
		return buyers;
	}
	
    public static Buyer getBuyer(int ID) {
		// TODO grab the corresponding buyer object from the database
    	return BuyerDAL.read(ID);
	}
    
	public static void addBuyer(int ID,String username,String address) {
		BuyerDAL buyerDAL = new BuyerDAL();
		buyerDAL.insert(ID,username,address);
		// TODO add the buyer to the database
	}
	
	public static void deleteBuyer(int ID) {
		BuyerDAL buyerDAL = new BuyerDAL();
		buyerDAL.deleteCustomer(ID);
		// TODO delete the given buyer
	}
	
	public void updateBuyer(int ID,int buyerID, String username, String address) {
		BuyerDAL buyerDAL = new BuyerDAL();
		buyerDAL.update(ID, buyerID,username,address);
	}

}
