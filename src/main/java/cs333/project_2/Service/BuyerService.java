package cs333.project_2.Service;

import java.util.List;

import javax.jws.WebService;

import cs333.project_2.Service.Respresentation.BuyerRepresentation;
import cs333.project_2.Service.Respresentation.BuyerRequest;

@WebService
public interface BuyerService {
	
	public List<BuyerRepresentation> getBuyers();
	public BuyerRepresentation getBuyer(String buyerId);
	public BuyerRepresentation createBuyer(BuyerRequest buyerRequest);
	
}
