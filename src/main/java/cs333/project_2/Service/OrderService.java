package cs333.project_2.Service;

import java.util.List;
import javax.jws.WebService;

import cs333.project_2.Service.Respresentation.OrderRepresentation;
import cs333.project_2.Service.Respresentation.OrderRequest;

@WebService
public interface OrderService {

	public List<OrderRepresentation> getOrders();
	public OrderRepresentation createOrder(OrderRequest productRequest);
	
}