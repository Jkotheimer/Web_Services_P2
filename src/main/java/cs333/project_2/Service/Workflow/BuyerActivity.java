package cs333.project_2.Service.Workflow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cs333.project_2.DOM.Buyer.BuyerManager;
import cs333.project_2.DOM.General.Address;
import cs333.project_2.DOM.General.PaymentInfo;
import cs333.project_2.DOM.Order.Order;
import cs333.project_2.DOM.Product.Product;
import cs333.project_2.DOM.Buyer.Buyer;
import cs333.project_2.Service.Link;
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
		setLinks(buyerRepresentation);
        
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

	public static void insertOrder(String attachedBuyerID, String ID, List<Product> products) {
		BuyerManager.insertOrder(attachedBuyerID, ID, products);
	}
	
	public static void addOrder(String ID, Order ord) {
		BuyerManager.addOrder(ID, ord);
	}

	public static void addAddress(String ID, Address addr) {
		BuyerManager.addAddress(ID, addr);
	}
	
	public static void addPaymentInfo(String ID, PaymentInfo payinf) {
		BuyerManager.addPaymentInfo(ID, payinf);
	}
	
	private void setLinks(BuyerRepresentation buyer) {
		// Set up the activities that can be performed on orders
		Link buy = new Link("buy", 
			"http://api.mississippi.com:8080/bookstore/books/order?book_id=" + buyer.getBuyerID());	
		buyer.setLinks(buy);
	}
	
}
