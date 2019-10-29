package cs333.project_2.Service;

import java.util.Set;

import cs333.project_2.Service.Respresentation.BuyerRepresentation;
import cs333.project_2.Service.Respresentation.BuyerRequest;

public interface BuyerService {
	
	public Set<BuyerRepresentation> getBuyers();
	public BuyerRepresentation getBuyer(int buyerId);
	public BuyerRepresentation createBuyer(BuyerRequest buyerRequest);
	
}
