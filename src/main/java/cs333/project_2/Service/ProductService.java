package cs333.project_2.Service;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

@WebService
public interface ProductService {

	public Response getProducts();
	public Response getProduct(String query, String action);
	public Response createProduct(String product);
	
}
