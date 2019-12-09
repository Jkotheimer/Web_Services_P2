package cs333.project_2.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import cs333.project_2.Service.Representation.OrderRepresentation;
import cs333.project_2.Service.Workflow.OrderActivity;

@Path("/orders")
public class OrderResource implements OrderService {
	
	final CORSFilter filter = new CORSFilter();
	final ObjectMapper mapper = new ObjectMapper();
	
	@GET
	@Produces("application/json")
	public Response getOrders() {
		System.out.println("GET METHOD Request for all orders .............");
		OrderActivity oa = new OrderActivity();
		List<OrderRepresentation> orders = oa.getOrders();
		if(orders == null) return filter.addCORS(Response.status(404));
		return filter.addCORS(Response.ok(orders));
	}
	
	@GET
	@Produces("application/json")
	@Path("/{buyerID}")
	public Response getOrder(@PathParam("buyerID") String buyerID) {
		System.out.println("GET METHOD Request from Client with order Request String ............." + buyerID);
		OrderActivity oa = new OrderActivity();
		List<OrderRepresentation> o = oa.getOrders(buyerID);
		return filter.addCORS(Response.ok(o));
	}

	@POST
	@Produces("application/json")
	@Consumes("text/plain")
	public Response createOrder(String order) {
		System.out.println("POST METHOD Request from Client with ............." + order);
		JsonNode o;
		try {
			o = mapper.readTree(order);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return filter.addCORS(Response.status(400));
		}
		OrderActivity oa = new OrderActivity();
		Iterator<JsonNode> ps = o.get("products").elements();
		List<String> products = new ArrayList<>();
		while(ps.hasNext()) products.add(ps.next().textValue());
		return filter.addCORS(Response.ok(oa.createOrder(o.get("buyerID").textValue(), products)));
	}
	
	@POST
	@Produces("application/json")
	@Path("/{orderID}")
	public Response updateOrder(@PathParam("orderID") String ID, @QueryParam("status") String status) {
		System.out.println("PUT METHOD Request from Client with ............." + ID + " " + status);
		OrderActivity oa = new OrderActivity();
		OrderRepresentation o = oa.updateOrder(ID, status);
		if(o == null) return filter.addCORS(Response.status(404));
		return filter.addCORS(Response.ok(o));
	}
	
	@OPTIONS
	@Produces("application/json")
	@Path("/{orderId}")
	public Response options(@PathParam("OrderId") String id) {
		System.out.println("OPTIONS METHOD Request from Client with order id ............." + id);
		return filter.addCORS(Response.ok());
	}
	
	@DELETE
	@Produces("application/json")
	@Path("/{orderId}")
	public Response deleteOrder(@PathParam("orderId") String id) {
		System.out.println("DELETE METHOD Request from Client with order id ............." + id);
		OrderActivity oa = new OrderActivity();
		return filter.addCORS(Response.status(oa.deleteOrder(id)));
	}
	
}
