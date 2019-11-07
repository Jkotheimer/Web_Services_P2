package cs333.project_2.DOM.Buyer;

import java.util.List;

import cs333.project_2.DAL.Buyer.BuyerDAL;

public class BuyerManager {
	
	public static List<Buyer> getBuyers() {
		List<Buyer> buyers = BuyerDAL.getBuyers();
		return buyers;
	}
	
    public static Buyer getBuyer(String ID) {
    	return BuyerDAL.read(ID);
	}
    
	public static void addBuyer(String ID,String username,String password) {
		BuyerDAL.insertBuyer(ID,username,password);
		// TODO add the buyer to the database
	}
	
	public static void deleteBuyer(String ID) {
		BuyerDAL.deleteBuyer(ID);
	}
	
	public void updateBuyer(String ID, String username, String password) {
		BuyerDAL.update(ID,username,password);
	}

}
