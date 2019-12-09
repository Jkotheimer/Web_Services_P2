package cs333.project_2.Service.Workflow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cs333.project_2.DOM.Seller.Seller;
import cs333.project_2.DOM.Seller.SellerManager;
import cs333.project_2.Service.Link;
import cs333.project_2.Service.Representation.SellerRepresentation;

public class SellerActivity {
	
	public List<SellerRepresentation> getSellers() {
		
		List<Seller> sellers = new ArrayList<Seller>();
		List<SellerRepresentation> sellerRepresentations = new ArrayList<SellerRepresentation>();
		sellers = SellerManager.getSellers();
		
		Iterator<Seller> it = sellers.iterator();
		while(it.hasNext()) {
          Seller s = (Seller)it.next();
          SellerRepresentation sellerRepresentation = new SellerRepresentation();
          sellerRepresentation.setUsername(s.getUsername());
          setLinks(sellerRepresentation);
          //now add this representation in the list
          sellerRepresentations.add(sellerRepresentation);
        }
		return sellerRepresentations;
	}
	
	public SellerRepresentation login(String username, String password) {
		
		Seller s = SellerManager.login(username, password);
		if(s == null) return null;
		
		SellerRepresentation sRep = new SellerRepresentation();
		sRep.setUsername(s.getUsername());
		
		setLinks(sRep);
		
		return sRep;
	}
	
	public SellerRepresentation createSeller(String username, String password) {

		Seller s = SellerManager.insertSeller(username,password);
		if(s == null) return null;
		SellerRepresentation sRep = new SellerRepresentation(s.getID(), s.getUsername());
		setLinks(sRep);
		
		return sRep;
	}
	
	public int changePassword(String ID, String current_password, String new_password) {
		return SellerManager.changePassword(ID, current_password, new_password);
	}
	
	public SellerRepresentation changeUsername(String ID, String username) {

		Seller s = SellerManager.changeUsername(ID, username);
		if(s == null) return null;
		
		SellerRepresentation sRep = new SellerRepresentation(s.getID(), s.getUsername());
		sRep.setUsername(s.getUsername());
		
		setLinks(sRep);
		
		return sRep;
	}
	
	public int deleteSeller(String id) {
		return SellerManager.deleteSeller(id);
	}
	
	private void setLinks(SellerRepresentation seller) {
		// Set up the activities that can be performed on orders
		Link[] buy = new Link[] {
				new Link("UpdateUsername", "http://localhost:8081/sellers/" + seller.getID() + "?action=username"),
				new Link("UpdatePassword", "http://localhost:8081/sellers/" + seller.getID() + "?action=password"),
				new Link("AddProduct", "http://localhost:8081/products/"),
				new Link("DeleteAccount", "http://localhost:8081/sellers/" + seller.getID()),
				new Link("ViewProducts", "http://localhost:8081/products?action=sellerID&query=" + seller.getID())
				};	
		seller.setLinks(buy);
	}
	
}
