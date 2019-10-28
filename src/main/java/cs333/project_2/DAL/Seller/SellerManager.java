package cs333.project_2.DAL.Seller;

import java.util.HashSet;
import java.util.Set;

import cs333.project_2.DAL.Seller.SellerDAL;
import cs333.project_2.DOM.Seller.Seller;

public class SellerManager {
	
	public Set<Seller> getSellers(){
		Set<Seller> sellers = new HashSet<Seller>();
		Seller a = new Seller("AppleCO",123,"applesales.com");
		return sellers;
	}
	
	public void addSeller(int Id, String username, String url, String address) {
		SellerDAL sellerdal = new SellerDAL();
		sellerdal.insert(Id, username, url, address);
		// TODO add the seller to the database
	}
		
	public Seller readSeller(int serialID) {
		return SellerDAL.read(serialID);
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
