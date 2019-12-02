package cs333.project_2.Service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
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

@Path("/buyers")
public class BuyerResource implements BuyerService {
	
	final CORSFilter filter = new CORSFilter();
	
	@GET
	@Produces("application/json")
	public Response getBuyers() {
		System.out.println("GET METHOD Request for all buyers .............");
		BuyerActivity buyerActivity = new BuyerActivity();
		List<BuyerRepresentation> buyers = buyerActivity.getBuyers();
		return filter.addCORS(Response.ok(buyers));
	}
	
	@GET
	@Produces("application/json")
	@Path("/{username}")
	public Response login(@PathParam("username") String username, @QueryParam("password") String password) {
		System.out.println("GET METHOD Request from Client with buyerRequest String ............." + username + " " + password);
		BuyerActivity buyerActivity = new BuyerActivity();
		BuyerRepresentation b = buyerActivity.login(username, password);
		if(b == null) return filter.addCORS(Response.status(401));
		else return filter.addCORS(Response.ok(b));
	}
	
	@POST
	@Produces("application/json")
	public Response createBuyer(@QueryParam("username") String username, @QueryParam("password") String password) {
		System.out.println("POST METHOD Request from Client with ............." + username + "  " + password);
		BuyerActivity buyerActivity = new BuyerActivity();
		BuyerRepresentation b = buyerActivity.createBuyer(username, password);
		if(b == null) return filter.addCORS(Response.status(409));
		return filter.addCORS(Response.status(201).entity(b));
	}
	
	@POST
	@Produces("application/json")
	@Path("/{buyerID}")
	public Response changePassword(@PathParam("buyerID") String ID, @QueryParam("current_password") String oldPassword, @QueryParam("new_password") String newPassword) {
		System.out.println("PUT METHOD Request from Client with ............." + ID + "  " + oldPassword + " " + newPassword);
		BuyerActivity buyerActivity = new BuyerActivity();
		return filter.addCORS(Response.status(buyerActivity.changePassword(ID, oldPassword, newPassword)));
	}
	
	@POST
	@Produces("application/json")
	@Path("/{buyerID}")
	public Response changeUsername(@PathParam("buyerID") String ID, @QueryParam("new_username") String newUsername) {
		System.out.println("PUT METHOD Request from Client with .............." + newUsername);
		BuyerActivity buyerActivity = new BuyerActivity();
		BuyerRepresentation b = buyerActivity.changeUsername(ID, newUsername);
		if(b == null) return filter.addCORS(Response.status(404));
		return filter.addCORS(Response.ok(b));
	}
	
	/*
	@PUT
	@Produces({"application/xml" , "application/json"})
	@Path("/{buyerID}/addorder")
	public void UpdateBuyerOrder(BuyerRequest  buyerRequest,OrderRequest ord) {
		System.out.println("POST METHOD Request from Client with ............." + buyerRequest.getID() + "  " + buyerRequest.getPassword());
		Order ordd = new Order(ord.getID(),BuyerManager.getBuyer(buyerRequest.getID()),ord.getOrderedProductIDs());
		BuyerActivity.addOrder(buyerRequest.getID(),ordd);
	}
	
	@PUT
	@Produces({"application/xml" , "application/json"})
	@Path("/{buyerID}/addaddress")
	public void UpdateBuyerOrder(BuyerRequest  buyerRequest,AddressRequest adr) {
		System.out.println("POST METHOD Request from Client with ............." + buyerRequest.getID() + "  " + buyerRequest.getPassword());
		Address addr = new Address(adr.getStreet(),adr.getCity(),adr.getState(),adr.getZipcode());
		BuyerActivity.addAddress(buyerRequest.getID(), addr);
	}
	*/
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/{buyerId}")
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
