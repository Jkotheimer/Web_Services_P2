package cs333.project_2.Service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import cs333.project_2.Service.Representation.SellerRepresentation;
import cs333.project_2.Service.Workflow.SellerActivity;

@Path("/sellers")
public class SellerResource implements SellerService{
	
	final CORSFilter filter = new CORSFilter();
	final ObjectMapper mapper = new ObjectMapper();
	
	@GET
	@Produces("application/json")
	public Response getSellers() {
		System.out.println("GET METHOD Request for all sellers .............");
		SellerActivity sellerActivity = new SellerActivity();
		List<SellerRepresentation> sellers = sellerActivity.getSellers();
		return filter.addCORS(Response.ok(sellers));
	}
	
	@GET
	@Produces("application/json")
	@Path("/{username}")
	public Response login(@PathParam("username") String username, @QueryParam("password") String password) {
		System.out.println("GET METHOD Request from Client with sellerRequest String ............." + username + " " + password);
		SellerActivity sellerActivity = new SellerActivity();
		SellerRepresentation s = sellerActivity.login(username, password);
		if(s == null) return filter.addCORS(Response.status(401));
		else return filter.addCORS(Response.ok(s));
	}
	
	@POST
	@Produces("application/json")
	public Response createSeller(@QueryParam("username") String username, @QueryParam("password") String password) {
		System.out.println("POST METHOD Request from Client with ............." + username + "  " + password);
		SellerActivity sellerActivity = new SellerActivity();
		SellerRepresentation s = sellerActivity.createSeller(username, password);
		if(s == null) return filter.addCORS(Response.status(409));
		return filter.addCORS(Response.status(201).entity(s));
	}
	
	@POST
	@Produces("application/json")
	@Consumes("text/plain")
	@Path("/{sellerID}")
	public Response update(@PathParam("sellerID") String ID, @QueryParam("action") String action, String req) {
		System.out.println("PUT METHOD Request from Client with ............." + action + " " + ID);
		SellerActivity sellerActivity = new SellerActivity();
		if(action.equals("password")) {
			JsonNode request;
			try {
				request = mapper.readTree(req);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				return filter.addCORS(Response.status(400));
			}
			return filter.addCORS(Response.status(sellerActivity.changePassword(ID, request.get("current_password").textValue(), request.get("new_password").textValue())));
		}
		else if(action.equals("username")) {
			SellerRepresentation b = sellerActivity.changeUsername(ID, req);
			if(b == null) return filter.addCORS(Response.status(404));
			else return filter.addCORS(Response.ok(b));
		}
		return filter.addCORS(Response.status(400));
	}
	
	@OPTIONS
	@Produces("application/json")
	@Path("/{sellerId}")
	public Response options(@PathParam("sellerId") String ID) {
		System.out.println("OPTIONS METHOD Request from Client with sellerRequest String ............." + ID);
		return filter.addCORS(Response.ok());
	}
	
	
	@DELETE
	@Produces("application/json")
	@Path("/{sellerId}")
	public Response delete(@PathParam("sellerId") String ID) {
		System.out.println("Delete METHOD Request from Client with sellerRequest String ............." + ID);
		SellerActivity sellerActivity = new SellerActivity();
		return filter.addCORS(Response.status(sellerActivity.deleteSeller(ID)));
	}
}
