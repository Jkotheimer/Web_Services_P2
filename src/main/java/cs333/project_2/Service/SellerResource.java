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

import cs333.project_2.Service.Respresentation.SellerRepresentation;
import cs333.project_2.Service.Respresentation.SellerRequest;
import cs333.project_2.Service.Workflow.SellerActivity;

public class SellerResource implements SellerService{
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/seller")
	public List<SellerRepresentation> getSellers() {
		System.out.println("GET METHOD Request for all sellers .............");
		SellerActivity sellerActivity = new SellerActivity();
		return sellerActivity.getSellers();	
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/seller/{sellerId}")
	public SellerRepresentation getSeller(@PathParam("sellerId") String id) {
		System.out.println("GET METHOD Request from Client with sellerRequest String ............." + id);
		SellerActivity sellerActivity = new SellerActivity();
		return sellerActivity.getSeller(id);
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/seller")
	public SellerRepresentation createSeller(SellerRequest  sellerRequest) {
		System.out.println("POST METHOD Request from Client with ............." + sellerRequest.getUsername());
		SellerActivity sellerActivity = new SellerActivity();
		return sellerActivity.createSeller(sellerRequest.getsellerID(),sellerRequest.getUsername(),sellerRequest.getPassword());
	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/seller/{sellerId}")
	public Response deleteSeller(@PathParam("sellerId") String id) {
		System.out.println("Delete METHOD Request from Client with sellerRequest String ............." + id);
		SellerActivity sellerActivity = new SellerActivity();
		String res = sellerActivity.deleteSeller(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}
	
}
