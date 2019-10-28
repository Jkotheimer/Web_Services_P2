package cs333.project_2.Service;

import java.util.Set;

import javax.jws.WebService;

import cs333.project_2.Service.Respresentation.OrderRepresentation;
import cs333.project_2.Service.Respresentation.OrderRequest;

@WebService
public interface OrderService {

	public Set<OrderRepresentation> getOrders();
	public OrderRepresentation getOrder(int OrderId);
	public OrderRepresentation createOrder(OrderRequest productRequest);
	
}