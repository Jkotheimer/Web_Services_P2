package cs333.project_2.Service;

import java.util.List;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import cs333.project_2.Service.Respresentation.BuyerRepresentation;
import cs333.project_2.Service.Respresentation.BuyerRequest;
import cs333.project_2.Service.Workflow.BuyerActivity;

public class BuyerResource {
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
