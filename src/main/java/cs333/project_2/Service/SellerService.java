package cs333.project_2.Service;

import java.util.List;

import cs333.project_2.Service.Respresentation.SellerRepresentation;
import cs333.project_2.Service.Respresentation.SellerRequest;

public interface SellerService {
	
	public List<SellerRepresentation> getSellers();
	public SellerRepresentation getSeller(String sellerId);
	public SellerRepresentation createSeller(SellerRequest sellerRequest);

}
