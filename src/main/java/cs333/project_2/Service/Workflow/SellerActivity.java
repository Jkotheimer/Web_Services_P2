package cs333.project_2.Service.Workflow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cs333.project_2.DOM.Seller.Seller;
import cs333.project_2.DOM.Seller.SellerManager;
import cs333.project_2.Service.Respresentation.SellerRepresentation;

public class SellerActivity {
	
	private static SellerManager seller = new SellerManager();
	
	public List<SellerRepresentation> getSellers() {
		
		List<Seller> sellers = new ArrayList<Seller>();
		List<SellerRepresentation> sellerRepresentations = new ArrayList<SellerRepresentation>();
		sellers = seller.getSellers();
		
		Iterator<Seller> it = sellers.iterator();
		while(it.hasNext()) {
          Seller s = (Seller)it.next();
          SellerRepresentation sellerRepresentation = new SellerRepresentation();
          sellerRepresentation.setSellerID(s.getSellerID());
          sellerRepresentation.setUsername(s.getUsername());
          sellerRepresentation.setUrlAddress(s.geturlAddress());
          
          //now add this representation in the list
          sellerRepresentations.add(sellerRepresentation);
        }
		return sellerRepresentations;
	}
	
	public SellerRepresentation getSeller(String id) {
		
		Seller s = seller.readSeller(id);
		
		SellerRepresentation sRep = new SellerRepresentation();
		sRep.setSellerID(s.getSellerID());
		sRep.setUsername(s.getUsername());
		sRep.setUrlAddress(s.geturlAddress());
		
//		sRep.setProductId((int)p.getSelleredProductIDs());
//		sRep.setStatus(p.getStatus());
//		sRep.setId(p.getSellerID());
		
		return sRep;
	}
	
	public SellerRepresentation createSeller(String ID, String username, String urladdress, String address) {
		
		seller.insertSeller(ID, username, address);
		Seller s = new Seller(username,ID, urladdress);
		
		SellerRepresentation sRep = new SellerRepresentation();
		sRep.setSellerID(s.getSellerID());
		sRep.setUsername(s.getUsername());
		sRep.setUrlAddress(s.geturlAddress());
		
		return sRep;
	}
	
	public String deleteSeller(String id) {
		
		//dao.deleteSeller(id);
		seller.deleteSeller(id);
		
		return "OK";
	}

}
