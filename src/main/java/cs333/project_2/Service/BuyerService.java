package cs333.project_2.Service;

import javax.ws.rs.core.Response;

import cs333.project_2.Service.Respresentation.BuyerRepresentation;
import cs333.project_2.Service.Respresentation.BuyerRequest;

public interface BuyerService {
	
	public Response getBuyers();
	public Response login(String username, String password);
	public Response createBuyer(String username, String password);
	public Response update(String ID, String Action, String req);
}
