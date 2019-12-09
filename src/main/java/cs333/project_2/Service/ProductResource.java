package cs333.project_2.Service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cs333.project_2.Service.Representation.ProductRepresentation;
import cs333.project_2.Service.Workflow.ProductActivity;

@Path("/products")
public class ProductResource implements ProductService {

	final CORSFilter filter = new CORSFilter();
	final ObjectMapper mapper = new ObjectMapper();
	
	@GET
	@Produces("application/json")
	@Consumes("text/plain")
	public Response getProducts(@QueryParam("action") String action, @QueryParam("query") String query) {
		System.out.println("GET METHOD Request from Client with productRequest String ............. action=" + action + " query=" + query);
		ProductActivity pActivity = new ProductActivity();
		List<ProductRepresentation> products = pActivity.getProducts(action, query);
		if(products == null) return filter.addCORS(Response.status(404));
		return filter.addCORS(Response.ok(products));
	}
	
	@POST
	@Produces("application/json")
	public Response createProduct(String product) {
		System.out.println("POST METHOD Request from Client with ............." + product);
		ProductRepresentation p;
		try {
			p = mapper.readValue(product, ProductRepresentation.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return filter.addCORS(Response.status(400));
		}
		ProductActivity activity = new ProductActivity();
		p = activity.createProduct(p.getSellerID(), p.getName(), p.getPrice(), p.getDescription());
		return filter.addCORS(Response.ok(p));
	}
	
	@POST
	@Produces("application/json")
	@Path("/{productID}")
	public Response updateProduct(@PathParam("productID") String ID, String product) {
		System.out.println("PUT METHOD Request from Client with ............." + ID + " " + product);
		ProductRepresentation p;
		try {
			p = mapper.readValue(product, ProductRepresentation.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return filter.addCORS(Response.status(400));
		}
		ProductActivity activity = new ProductActivity();
		p = activity.updateProduct(ID, p.getName(), p.getPrice(), p.getDescription());
		return filter.addCORS(Response.ok(p));
	}
	
	@OPTIONS
	@Produces("application/json")
	@Path("/{productId}")
	public Response options(@PathParam("productId") String id) {
		System.out.println("OPTIONS METHOD Request from Client with productRequest String ............." + id);
		return filter.addCORS(Response.ok());
	}
	
	@DELETE
	@Produces("application/json")
	@Path("/{productId}")
	public Response deleteProduct(@PathParam("productId") String id) {
		System.out.println("DELETE METHOD Request from Client with productRequest String ............." + id);
		ProductActivity pActivity = new ProductActivity();
		return filter.addCORS(Response.status(pActivity.deleteProduct(id)));
	}
	
}
