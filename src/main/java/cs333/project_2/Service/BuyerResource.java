package cs333.project_2.Service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import cs333.project_2.DOM.Buyer.BuyerManager;
import cs333.project_2.DOM.General.Address;
import cs333.project_2.DOM.Order.Order;
import cs333.project_2.Service.Respresentation.AddressRequest;
import cs333.project_2.Service.Respresentation.BuyerRepresentation;
import cs333.project_2.Service.Respresentation.BuyerRequest;
import cs333.project_2.Service.Respresentation.OrderRequest;
import cs333.project_2.Service.Workflow.BuyerActivity;

public class BuyerResource implements BuyerService {
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/buyer")
	public List<BuyerRepresentation> getBuyers() {
		System.out.println("GET METHOD Request for all buyers .............");
		BuyerActivity buyerActivity = new BuyerActivity();
		return buyerActivity.getBuyers();	
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/buyer/{buyerId}")
	public BuyerRepresentation getBuyer(@PathParam("buyerId") String id) {
		System.out.println("GET METHOD Request from Client with buyerRequest String ............." + id);
		BuyerActivity buyerActivity = new BuyerActivity();
		return buyerActivity.getBuyer(id);
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/buyer")
	public BuyerRepresentation createBuyer(BuyerRequest  buyerRequest) {
		System.out.println("POST METHOD Request from Client with ............." + buyerRequest.getBuyerId() + "  " + buyerRequest.getPassword());
		BuyerActivity buyerActivity = new BuyerActivity();
		return buyerActivity.createBuyer(buyerRequest.getBuyerId(),buyerRequest.getUsername(), buyerRequest.getPassword());
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/buyer/{buyerID}")
	public void UpdateBuyer(BuyerRequest  buyerRequest) {
		System.out.println("POST METHOD Request from Client with ............." + buyerRequest.getBuyerId() + "  " + buyerRequest.getPassword());
		BuyerActivity buyerActivity = new BuyerActivity();
		buyerActivity.updateBuyer(buyerRequest.getBuyerId(),buyerRequest.getUsername(), buyerRequest.getPassword());
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/buyer/{buyerID}/addorder")
	public void UpdateBuyerOrder(BuyerRequest  buyerRequest,OrderRequest ord) {
		System.out.println("POST METHOD Request from Client with ............." + buyerRequest.getBuyerId() + "  " + buyerRequest.getPassword());
		Order ordd = new Order(ord.getID(),BuyerManager.getBuyer(buyerRequest.getBuyerId()),ord.getOrderedProductIDs());
		BuyerActivity.addOrder(buyerRequest.getBuyerId(),ordd);
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/buyer/{buyerID}/addaddress")
	public void UpdateBuyerOrder(BuyerRequest  buyerRequest,AddressRequest adr) {
		System.out.println("POST METHOD Request from Client with ............." + buyerRequest.getBuyerId() + "  " + buyerRequest.getPassword());
		Address addr = new Address(adr.getStreet(),adr.getCity(),adr.getState(),adr.getZipcode());
		BuyerActivity.addAddress(buyerRequest.getBuyerId(), addr);
	}
		
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/buyer/{buyerId}")
	public Response deleteBuyer(@PathParam("buyerId") String id) {
		System.out.println("Delete METHOD Request from Client with buyerRequest String ............." + id);
		BuyerActivity buyerActivity = new BuyerActivity();
		String res = buyerActivity.deleteBuyer(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

}
