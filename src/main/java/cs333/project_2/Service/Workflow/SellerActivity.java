package cs333.project_2.Service.Workflow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cs333.project_2.DOM.Seller.Seller;
import cs333.project_2.DOM.Seller.SellerManager;
import cs333.project_2.Service.Link;
import cs333.project_2.Service.Respresentation.SellerRepresentation;

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
          sellerRepresentation.setProducts(s.getProducts());;
          
          //now add this representation in the list
          sellerRepresentations.add(sellerRepresentation);
        }
		return sellerRepresentations;
	}
	
	public SellerRepresentation getSeller(String id) {
		
		Seller s = SellerManager.readSeller(id);
		
		SellerRepresentation sRep = new SellerRepresentation();
		sRep.setProducts(s.getProducts());
		sRep.setUsername(s.getUsername());
		
		setLinks(sRep);
		
		return sRep;
	}
	
	public SellerRepresentation createSeller(String ID, String username, String password) {
		
		SellerManager.insertSeller(ID, username,password);
		Seller s = new Seller(username,ID, password);
		
		SellerRepresentation sRep = new SellerRepresentation();
		sRep.setUsername(s.getUsername());
		
		return sRep;
	}
	
	public String deleteSeller(String id) {
		
		//dao.deleteSeller(id);
		SellerManager.deleteSeller(id);
		
		return "OK";
	}
	
	private void setLinks(SellerRepresentation seller) {
		// Set up the activities that can be performed on orders
		Link buy = new Link("buy", 
			"http://localhost:8081/productservice/product/" + seller.getsellerID());	
		seller.setLinks(buy);
	}
	
}
