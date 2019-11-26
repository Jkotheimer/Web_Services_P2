package cs333.project_2.Service;

import javax.ws.rs.core.Response;

import cs333.project_2.Service.Respresentation.BuyerRepresentation;
import cs333.project_2.Service.Respresentation.BuyerRequest;

public interface BuyerService {
	
	public Response getBuyers();
	public BuyerRepresentation getBuyer(String buyerId);
	public BuyerRepresentation createBuyer(BuyerRequest buyerRequest);
	
}
