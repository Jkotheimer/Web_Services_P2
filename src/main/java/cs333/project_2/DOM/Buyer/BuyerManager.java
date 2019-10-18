package cs333.project_2.DOM.Buyer;

import cs333.project_2.DAL.Buyer.BuyerDAL;

public class BuyerManager {
	
    public static void getBuyer(int ID) {
		// TODO grab the corresponding buyer object from the database
    	BuyerDAL buyerDAL = new BuyerDAL();
		buyerDAL.read(ID);
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
