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
          BuyerRepresentation buyerRepresentation = new BuyerRepresentation(b.getID(),b.getUsername());
          buyerRepresentation.setOrderIDs(b.getOrders());
          buyerRepresentation.setAddresses(b.getAddressList());
          buyerRepresentation.setPaymentInfos(b.getPayInfos());
          //now add this representation in the list
          buyerRepresentations.add(buyerRepresentation);
        }
		return buyerRepresentations;
	}
	
	public BuyerRepresentation login(String username, String password) {
		Buyer b = BuyerManager.login(username, password);
		if(b == null) return null;
		
		BuyerRepresentation buyerRep = new BuyerRepresentation(b.getID(), b.getUsername());
		buyerRep.setOrderIDs(b.getOrders());
		buyerRep.setAddresses(b.getAddressList());
		buyerRep.setPaymentInfos(b.getPayInfos());
		setLinks(buyerRep);
		
		return buyerRep;
	}
	
	public BuyerRepresentation getBuyer(String id) {
		
		Buyer b = BuyerManager.getBuyer(id);
		
		BuyerRepresentation buyerRepresentation = new BuyerRepresentation(b.getID(),b.getUsername());
        buyerRepresentation.setOrderIDs(b.getOrders());
        buyerRepresentation.setAddresses(b.getAddressList());
        buyerRepresentation.setPaymentInfos(b.getPayInfos());
		setLinks(buyerRepresentation);
        
		return buyerRepresentation;
	}
	
	public BuyerRepresentation createBuyer(String username, String password) {
		
		Buyer b = BuyerManager.addBuyer(username , password);
		if(b == null) return null;
		BuyerRepresentation bRep = new BuyerRepresentation(b.getID(), b.getUsername());
		setLinks(bRep);
		
		return bRep;
	}
	
	public int changePassword(String ID, String oldPassword, String newPassword) {
		return BuyerManager.changePassword(ID, oldPassword, newPassword);
	}
	
	public BuyerRepresentation changeUsername(String ID, String newUsername) {
		Buyer b = BuyerManager.changeUsername(ID, newUsername);
		
		if(b == null) return null;

		BuyerRepresentation buyerRepresentation = new BuyerRepresentation(b.getID(),b.getUsername());
        buyerRepresentation.setOrderIDs(b.getOrders());
        buyerRepresentation.setAddresses(b.getAddressList());
        buyerRepresentation.setPaymentInfos(b.getPayInfos());
		setLinks(buyerRepresentation);
        
		return buyerRepresentation;
	}
	
	public int deleteBuyer(String id) {
		return BuyerManager.deleteBuyer(id);
	}

	public static void insertOrder(String attachedBuyerID, String ID, List<Product> products) {
		BuyerManager.insertOrder(attachedBuyerID, ID, products);
	}
	
	public BuyerRepresentation addOrder(String ID, Order ord) {
		Buyer b = BuyerManager.addOrder(ID, ord);
		
		if(b == null) return null;

		BuyerRepresentation buyerRepresentation = new BuyerRepresentation(b.getID(),b.getUsername());
        buyerRepresentation.setOrderIDs(b.getOrders());
        buyerRepresentation.setAddresses(b.getAddressList());
        buyerRepresentation.setPaymentInfos(b.getPayInfos());
		setLinks(buyerRepresentation);
        
		return buyerRepresentation;
	}

	public BuyerRepresentation addAddress(String ID, Address addr) {
		Buyer b = BuyerManager.addAddress(ID, addr);
		
		if(b == null) return null;

		BuyerRepresentation buyerRepresentation = new BuyerRepresentation(b.getID(),b.getUsername());
        buyerRepresentation.setOrderIDs(b.getOrders());
        buyerRepresentation.setAddresses(b.getAddressList());
        buyerRepresentation.setPaymentInfos(b.getPayInfos());
		setLinks(buyerRepresentation);
        
		return buyerRepresentation;
	}
	
	public BuyerRepresentation addPaymentInfo(String ID, PaymentInfo payinf) {
		Buyer b = BuyerManager.addPaymentInfo(ID, payinf);
		
		if(b == null) return null;

		BuyerRepresentation buyerRepresentation = new BuyerRepresentation(b.getID(),b.getUsername());
        buyerRepresentation.setOrderIDs(b.getOrders());
        buyerRepresentation.setAddresses(b.getAddressList());
        buyerRepresentation.setPaymentInfos(b.getPayInfos());
		setLinks(buyerRepresentation);
        
		return buyerRepresentation;
	}
	
	private void setLinks(BuyerRepresentation buyer) {
		// Set up the activities that can be performed on orders
		Link buy = new Link("ViewOrders", 
			"http://localhost:8081/orderservice/order" + buyer.getID());	
		buyer.setLinks(buy);
	}
	
}
