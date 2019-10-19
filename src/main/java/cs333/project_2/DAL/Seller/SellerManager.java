package cs333.project_2.DAL.Seller;

import cs333.project_2.DAL.Seller.SellerDAL;

public class SellerManager {
	
	public void addSeller(int Id, String username, String url, String address) {
		SellerDAL sellerdal = new SellerDAL();
		sellerdal.insert(Id, username, url, address);
		// TODO add the seller to the database
	}
	
	
	public void readSeller(int serialID) {
		SellerDAL sellerdal = new SellerDAL();
		sellerdal.read(serialID);
	}
	
	public void updateSeller(int serialID,int newSellerID, String newusername, String newurl, String newaddress) {
		SellerDAL sellerdal = new SellerDAL();
		sellerdal.update(serialID,newSellerID, newusername, newurl, newaddress);
	}
	
	public void deleteSeller(int ID) {
		// TODO delete the given seller
		SellerDAL sellerdal = new SellerDAL();
		sellerdal.deleteSeller(ID);
	}
}
