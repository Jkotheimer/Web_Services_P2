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

import javax.jws.WebService;

import cs333.project_2.Service.Respresentation.SellerRepresentation;
import cs333.project_2.Service.Respresentation.SellerRequest;
import cs333.project_2.Service.Workflow.SellerActivity;

@Path("/users/sellers")
@WebService(endpointInterface = "cs333.project_2.Service.SellerService", targetNamespace = "http://localhost:8080/users/sellers")
public class SellerResource {
	@GET
	@Produces({"application/xml" , "application/json"})
	public List<SellerRepresentation> getSellers() {
		System.out.println("GET METHOD Request for all sellers .............");
		SellerActivity sellerActivity = new SellerActivity();
		return sellerActivity.getSellers();	
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/{sellerID}")
	public SellerRepresentation getSeller(@PathParam("sellerID") String id) {
		System.out.println("GET METHOD Request from Client with sellerRequest String ............." + id);
		SellerActivity sellerActivity = new SellerActivity();
		return sellerActivity.getSeller(id);
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	public SellerRepresentation createSeller(SellerRequest  sellerRequest) {
		System.out.println("POST METHOD Request from Client with ............." + sellerRequest.getSellerID() + "  " + sellerRequest.getUrlAddress());
		SellerActivity sellerActivity = new SellerActivity();
		return sellerActivity.createSeller(sellerRequest.getSellerID(),sellerRequest.getUsername(), sellerRequest.getUrlAddress(), sellerRequest.getAddress());
	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/{sellerId}")
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
