package cs333.project_2.Service;

import java.util.List;

import cs333.project_2.Service.Respresentation.BuyerRepresentation;
import cs333.project_2.Service.Respresentation.BuyerRequest;

public interface BuyerService {
	
	public List<BuyerRepresentation> getBuyers();
	public BuyerRepresentation getBuyer(String buyerId);
	public BuyerRepresentation createBuyer(BuyerRequest buyerRequest);
	
}
