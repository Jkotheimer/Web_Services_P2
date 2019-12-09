package cs333.project_2.Service;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

@WebService
public interface OrderService {

	public Response getOrders();
	public Response getOrder(String buyerID);
	public Response createOrder(String order);
	public Response updateOrder(String ID, String order);
	public Response deleteOrder(String ID);
}