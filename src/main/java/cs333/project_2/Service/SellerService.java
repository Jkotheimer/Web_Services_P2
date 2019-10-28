package cs333.project_2.Service;

import java.util.Set;

import cs333.project_2.Service.Respresentation.SellerRepresentation;
import cs333.project_2.Service.Respresentation.SellerRequest;

public interface SellerService {
	
	public Set<SellerRepresentation> getSellers();
	public SellerRepresentation getSeller(int sellerId);
	public SellerRepresentation createSeller(SellerRequest sellerRequest);

}
