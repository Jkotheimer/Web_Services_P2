package cs333.project_2.Service.Workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import cs333.project_2.DOM.Seller.Seller;
import cs333.project_2.DAL.Seller.SellerManager;
import cs333.project_2.Service.Respresentation.SellerRepresentation;

public class SellerActivity {
	
	private static SellerManager seller = new SellerManager();
	
	public Set<SellerRepresentation> getSellers() {
		
		Set<Seller> sellers = new HashSet<Seller>();
		Set<SellerRepresentation> sellerRepresentations = new HashSet<SellerRepresentation>();
		sellers = seller.getSellers();
		
		Iterator<Seller> it = sellers.iterator();
		while(it.hasNext()) {
          Seller s = (Seller)it.next();
          SellerRepresentation sellerRepresentation = new SellerRepresentation();
          sellerRepresentation.setSellerID(s.getsellerID());
          sellerRepresentation.setUsername(s.getUsername());
          sellerRepresentation.setUrlAddress(s.geturlAddress());
          
          //now add this representation in the list
          sellerRepresentations.add(sellerRepresentation);
        }
		return sellerRepresentations;
	}
	
	public SellerRepresentation getSeller(int id) {
		
		Seller s = seller.readSeller(id);
		
		SellerRepresentation sRep = new SellerRepresentation();
		sRep.setSellerID(s.getsellerID());
		sRep.setUsername(s.getUsername());
		sRep.setUrlAddress(s.geturlAddress());
		
//		sRep.setProductId((int)p.getSelleredProductIDs());
//		sRep.setStatus(p.getStatus());
//		sRep.setId(p.getSellerID());
		
		return sRep;
	}
	
	public SellerRepresentation createSeller(int ID, String username, String urladdress, String address) {
		
		seller.addSeller(ID, username, urladdress, address);
		Seller s = new Seller(username,ID, urladdress);
		
		SellerRepresentation sRep = new SellerRepresentation();
		sRep.setSellerID(s.getsellerID());
		sRep.setUsername(s.getUsername());
		sRep.setUrlAddress(s.geturlAddress());
		
		return sRep;
	}
	
	public String deleteSeller(int id) {
		
		//dao.deleteSeller(id);
		seller.deleteSeller(id);
		
		return "OK";
	}

}
