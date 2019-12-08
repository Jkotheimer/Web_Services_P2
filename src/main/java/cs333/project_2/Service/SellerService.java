package cs333.project_2.Service;

import javax.ws.rs.core.Response;

public interface SellerService {
	
	public Response getSellers();
	public Response login(String username, String password);
	public Response createSeller(String username, String password);
	public Response update(String ID, String action, String req);;
	public Response delete(String ID);
}
