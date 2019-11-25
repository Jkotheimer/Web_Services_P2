package cs333.project_2.Service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import javax.jws.WebService;

import cs333.project_2.Service.Respresentation.BuyerRepresentation;
import cs333.project_2.Service.Respresentation.BuyerRequest;
import cs333.project_2.Service.Workflow.BuyerActivity;

@Path("/users/buyers")
@WebService(endpointInterface = "cs333.project_2.Service.BuyerService", targetNamespace = "http://localhost:8080/users/buyers")
public class BuyerResource implements BuyerService {
	
	public BuyerResource() {}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	public List<BuyerRepresentation> getBuyers() {
		System.out.println("GET METHOD Request for all buyers .............");
		BuyerActivity buyerActivity = new BuyerActivity();
		return buyerActivity.getBuyers();
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/{buyerID}")
	public BuyerRepresentation getBuyer(@PathParam("buyerID") String id) {
		System.out.println("GET METHOD Request from Client with buyerRequest String ............." + id);
		BuyerActivity buyerActivity = new BuyerActivity();
		return buyerActivity.getBuyer(id);
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	public BuyerRepresentation createBuyer(BuyerRequest  buyerRequest) {
		System.out.println("POST METHOD Request from Client with ............." + buyerRequest.getBuyerId() + "  " + buyerRequest.getPassword());
		BuyerActivity buyerActivity = new BuyerActivity();
		return buyerActivity.createBuyer(buyerRequest.getBuyerId(),buyerRequest.getUsername(), buyerRequest.getPassword());
	}
	
	@PUT
	@Produces({"application/xml" , "application/json"})
	@Path("/{buyerID}")
	public BuyerRepresentation UpdateBuyer(BuyerRequest  buyerRequest) {
		System.out.println("POST METHOD Request from Client with ............." + buyerRequest.getBuyerId() + "  " + buyerRequest.getPassword());
		BuyerActivity buyerActivity = new BuyerActivity();
		return buyerActivity.createBuyer(buyerRequest.getBuyerId(),buyerRequest.getUsername(), buyerRequest.getPassword());
	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/{buyerID}")
	public Response deleteBuyer(@PathParam("buyerID") String id) {
		System.out.println("Delete METHOD Request from Client with buyerRequest String ............." + id);
		BuyerActivity buyerActivity = new BuyerActivity();
		String res = buyerActivity.deleteBuyer(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

}
