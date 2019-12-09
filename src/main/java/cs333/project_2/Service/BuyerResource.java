package cs333.project_2.Service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import cs333.project_2.DOM.General.Address;
import cs333.project_2.DOM.General.PaymentInfo;
import cs333.project_2.Service.Representation.BuyerRepresentation;
import cs333.project_2.Service.Workflow.BuyerActivity;

@Path("/buyers")
public class BuyerResource implements BuyerService {
	
	final CORSFilter filter = new CORSFilter();
	final ObjectMapper mapper = new ObjectMapper();
	
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
	@Consumes("text/plain")
	@Path("/{buyerID}")
	public Response update(@PathParam("buyerID") String ID, @QueryParam("action") String action, String req) {
		System.out.println("PUT METHOD Request from Client with ............." + action + " " + ID);
		BuyerActivity buyerActivity = new BuyerActivity();
		if(action.equals("password")) {
			JsonNode request;
			try {
				request = mapper.readTree(req);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				return filter.addCORS(Response.status(400));
			}
			return filter.addCORS(Response.status(buyerActivity.changePassword(ID, request.get("current_password").textValue(), request.get("new_password").textValue())));
		}
		else if(action.equals("username")) {
			BuyerRepresentation b = buyerActivity.changeUsername(ID, req);
			if(b == null) return filter.addCORS(Response.status(404));
			else return filter.addCORS(Response.ok(b));
		}
		else if(action.equals("address")) {
			Address address;
			try {
				address = mapper.readValue(req, Address.class);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				return filter.addCORS(Response.status(400));
			}
			BuyerRepresentation b = buyerActivity.addAddress(ID, address);
			if(b == null) return filter.addCORS(Response.status(404));
			else return filter.addCORS(Response.ok(b));
		}
		else if(action.equals("payment")) {
			PaymentInfo payinfo;
			try {
				payinfo = mapper.readValue(req,  PaymentInfo.class);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				return filter.addCORS(Response.status(400));
			}
			BuyerRepresentation b = buyerActivity.addPaymentInfo(ID, payinfo);
			if(b == null) return filter.addCORS(Response.status(400));
			else return filter.addCORS(Response.ok(b));
		}
		return filter.addCORS(Response.status(400));
	}
	
	@OPTIONS
	@Produces("application/json")
	@Path("/{buyerId}")
	public Response options(@PathParam("buyerId") String ID) {
		System.out.println("OPTIONS METHOD Request from Client with buyerRequest String ............." + ID);
		return filter.addCORS(Response.ok());
	}
	
	
	@DELETE
	@Produces("application/json")
	@Path("/{buyerId}")
	public Response delete(@PathParam("buyerId") String ID) {
		System.out.println("Delete METHOD Request from Client with buyerRequest String ............." + ID);
		BuyerActivity buyerActivity = new BuyerActivity();
		return filter.addCORS(Response.status(buyerActivity.deleteBuyer(ID)));
	}

}
