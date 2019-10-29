package cs333.project_2.Service.Workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import cs333.project_2.DOM.Buyer.BuyerManager;
import cs333.project_2.DOM.Buyer.Buyer;
import cs333.project_2.Service.Respresentation.BuyerRepresentation;

public class BuyerActivity {
	
	private static BuyerManager buyer = new BuyerManager();
	
	public Set<BuyerRepresentation> getBuyers() {
		
		Set<Buyer> buyers = new HashSet<Buyer>();
		Set<BuyerRepresentation> buyerRepresentations = new HashSet<BuyerRepresentation>();
		buyers = buyer.getBuyers();
		
		Iterator<Buyer> it = buyers.iterator();
		while(it.hasNext()) {
          Buyer b = (Buyer)it.next();
          BuyerRepresentation buyerRepresentation = new BuyerRepresentation();
          buyerRepresentation.setBuyerID(b.getBuyerID());
          buyerRepresentation.setUsername(b.getUsername());
          buyerRepresentation.setAddress(b.getAddress());
          
          //now add this representation in the list
          buyerRepresentations.add(buyerRepresentation);
        }
		return buyerRepresentations;
	}
	
	public BuyerRepresentation getBuyer(int id) {
		
		Buyer b = buyer.getBuyer(id);
		
		BuyerRepresentation bRep = new BuyerRepresentation();
		bRep.setBuyerID(b.getBuyerID());
		bRep.setUsername(b.getUsername());
		bRep.setAddress(b.getAddress());
		
//		bRep.setProductId((int)p.getBuyeredProductIDs());
//		bRep.setStatus(p.getStatus());
//		bRep.setId(p.getBuyerID());
		
		return bRep;
	}
	
	public BuyerRepresentation createBuyer(int ID, String username, String address) {
		
		buyer.addBuyer(ID, username , address);
		Buyer b = new Buyer(ID, username, address);
		
		BuyerRepresentation bRep = new BuyerRepresentation();
		bRep.setBuyerID(b.getBuyerID());
		bRep.setUsername(b.getUsername());
		bRep.setAddress(b.getAddress());
		
		return bRep;
	}
	
	public String deleteBuyer(int id) {
		
		//dao.deleteBuyer(id);
		buyer.deleteBuyer(id);
		
		return "OK";
	}

}
