package cs333.project_2.Service;

import javax.ws.rs.core.Response;

public interface BuyerService {
	
	public Response getBuyers();
	public Response login(String username, String password);
	public Response createBuyer(String username, String password);
	public Response update(String ID, String Action, String req);
}
