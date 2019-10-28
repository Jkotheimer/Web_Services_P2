package cs333.project_2.Service;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import cs333.project_2.Service.Respresentation.OrderRepresentation;
import cs333.project_2.Service.Respresentation.OrderRequest;
import cs333.project_2.Service.Workflow.OrderActivity;

@Path("/orderservice/")
public class OrderResource implements OrderService {

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/order")
	public Set<OrderRepresentation> getOrders() {
		System.out.println("GET METHOD Request for all orders .............");
		OrderActivity prodActivity = new OrderActivity();
		return prodActivity.getOrders();	
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/order/{orderId}")
	public OrderRepresentation getOrder(@PathParam("orderId") int id) {
		System.out.println("GET METHOD Request from Client with orderRequest String ............." + id);
		OrderActivity prodActivity = new OrderActivity();
		return prodActivity.getOrder(id);
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/order")
	public OrderRepresentation createOrder(OrderRequest  orderRequest) {
		System.out.println("POST METHOD Request from Client with ............." + orderRequest.getStatus() + "  " + orderRequest.getProductId());
		OrderActivity prodActivity = new OrderActivity();
		return prodActivity.createOrder(1234,orderRequest.getProductId());
	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/order/{orderId}")
	public Response deleteOrder(@PathParam("orderId") int id) {
		System.out.println("Delete METHOD Request from Client with orderRequest String ............." + id);
		OrderActivity prodActivity = new OrderActivity();
		String res = prodActivity.deleteOrder(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}
	
}
