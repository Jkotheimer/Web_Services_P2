package cs333.project_2.Service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import cs333.project_2.Service.Representation.OrderRepresentation;
import cs333.project_2.Service.Representation.OrderRequest;
import cs333.project_2.Service.Workflow.OrderActivity;

@Path("/orderservice/")
public class OrderResource implements OrderService{

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/order")
	public List<OrderRepresentation> getOrders() {
		System.out.println("GET METHOD Request for all orders .............");
		OrderActivity OrdActivity = new OrderActivity();
		return OrdActivity.getOrders();	
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/order/{OrderId}")
	public OrderRepresentation getOrdersOfCustomer(@PathParam("OrderId") String id) {
		System.out.println("GET METHOD Request from Client with orderRequest String ............." + id);
		OrderActivity OrdActivity = new OrderActivity();
		return OrdActivity.getOrder(id);
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/order")
	public OrderRepresentation createOrder(OrderRequest  orderRequest) {
		System.out.println("POST METHOD Request from Client with ............." + orderRequest.getStatus() + "  " + orderRequest.getOrderedProductIDs());
		OrderActivity OrdActivity = new OrderActivity();
		return OrdActivity.createOrder(orderRequest.getID(),orderRequest.getBuyer().getID(),orderRequest.getOrderedProductIDs());
	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/order/{orderId}")
	public Response deleteOrder(@PathParam("orderId") String id) {
		System.out.println("Delete METHOD Request from Client with orderRequest String ............." + id);
		OrderActivity OrdActivity = new OrderActivity();
		String res = OrdActivity.deleteOrder(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}
	
}
