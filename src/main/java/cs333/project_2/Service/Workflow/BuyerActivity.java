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
	
	private static BuyerManager buyer = new BuyerManager();
	
	public List<BuyerRepresentation> getBuyers() {
		
		List<Buyer> buyers = new ArrayList<Buyer>();
		List<BuyerRepresentation> buyerRepresentations = new ArrayList<BuyerRepresentation>();
		buyers = buyer.getBuyers();
		
		Iterator<Buyer> it = buyers.iterator();
		while(it.hasNext()) {
          Buyer b = (Buyer)it.next();
          BuyerRepresentation buyerRepresentation = new BuyerRepresentation();
          buyerRepresentation.setBuyerID(b.getBuyerID());
          buyerRepresentation.setUsername(b.getUsername());
          buyerRepresentation.setPassword(b.getPassword());
          
          //now add this representation in the list
          buyerRepresentations.add(buyerRepresentation);
        }
		return buyerRepresentations;
	}
	
	public BuyerRepresentation getBuyer(String id) {
		
		Buyer b = buyer.getBuyer(id);
		
		BuyerRepresentation bRep = new BuyerRepresentation();
		bRep.setBuyerID(b.getBuyerID());
		bRep.setUsername(b.getUsername());
		bRep.setPassword(b.getPassword());
		
		return bRep;
	}
	
	public BuyerRepresentation createBuyer(String ID, String username, String password) {
		
		buyer.addBuyer(ID, username , password);
		Buyer b = new Buyer(ID, username, password);
		
		BuyerRepresentation bRep = new BuyerRepresentation();
		bRep.setBuyerID(b.getBuyerID());
		bRep.setUsername(b.getUsername());
		bRep.setPassword(b.getPassword());
		
		return bRep;
	}
	
	public String deleteBuyer(String id) {
		
		//dao.deleteBuyer(id);
		buyer.deleteBuyer(id);
		
		return "OK";
	}

}
