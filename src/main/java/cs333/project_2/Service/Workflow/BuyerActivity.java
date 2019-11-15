package cs333.project_2.Service.Workflow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cs333.project_2.DOM.Buyer.BuyerManager;
import cs333.project_2.DOM.Buyer.Buyer;
import cs333.project_2.Service.Respresentation.BuyerRepresentation;

public class BuyerActivity {
	
	public List<BuyerRepresentation> getBuyers() {
		
		List<Buyer> buyers = new ArrayList<Buyer>();
		List<BuyerRepresentation> buyerRepresentations = new ArrayList<BuyerRepresentation>();
		buyers = BuyerManager.getBuyers();
		
		Iterator<Buyer> it = buyers.iterator();
		while(it.hasNext()) {
          Buyer b = (Buyer)it.next();
          BuyerRepresentation buyerRepresentation = new BuyerRepresentation(b.getBuyerID(),b.getUsername(),b.getPassword());
          buyerRepresentation.setOrderIDs(b.getOrders());
          buyerRepresentation.setAdresses(b.getAddress());
          buyerRepresentation.setPaymentInfos(b.getPayInfos());
          //now add this representation in the list
          buyerRepresentations.add(buyerRepresentation);
        }
		return buyerRepresentations;
	}
	
	public BuyerRepresentation getBuyer(String id) {
		
		Buyer b = BuyerManager.getBuyer(id);
		
		BuyerRepresentation buyerRepresentation = new BuyerRepresentation(b.getBuyerID(),b.getUsername(),b.getPassword());
        buyerRepresentation.setOrderIDs(b.getOrders());
        buyerRepresentation.setAdresses(b.getAddress());
        buyerRepresentation.setPaymentInfos(b.getPayInfos());
		
		return buyerRepresentation;
	}
	
	public BuyerRepresentation createBuyer(String ID, String username, String password) {
		
		BuyerManager.addBuyer(ID, username , password);
		Buyer b = new Buyer(ID, username, password);
		
		BuyerRepresentation bRep = new BuyerRepresentation(b.getBuyerID(),b.getUsername(),b.getPassword());
		
		return bRep;
	}
	
	public void updateBuyer(String id,String username, String password) {
		BuyerManager.updateBuyer(id, username, password);
		
	}
	
	public String deleteBuyer(String id) {
		
		//dao.deleteBuyer(id);
		BuyerManager.deleteBuyer(id);
		
		return "OK";
	}

}
