package cs333.project_2.Service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cs333.project_2.Service.Respresentation.ProductRepresentation;
import cs333.project_2.Service.Workflow.ProductActivity;

@Path("/products")
public class ProductResource implements ProductService {

	final CORSFilter filter = new CORSFilter();
	final ObjectMapper mapper = new ObjectMapper();
	
	@GET
	@Produces({"application/xml" , "application/json"})
	public Response getProducts() {
		System.out.println("GET METHOD Request for all products .............");
		ProductActivity empActivity = new ProductActivity();
		return filter.addCORS(Response.ok(empActivity.getProducts()));	
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	public Response getProducts(@QueryParam("sellerID") String sellerID) {
		System.out.println("GET METHOD Request for products by sellerID ............." + sellerID);
		ProductActivity empActivity = new ProductActivity();
		return filter.addCORS(Response.ok(empActivity.getProducts(sellerID)));	
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/{name}")
	public Response getProduct(@PathParam("name") String name) {
		System.out.println("GET METHOD Request from Client with productRequest String ............." + name);
		ProductActivity pActivity = new ProductActivity();
		return filter.addCORS(Response.ok(pActivity.getProduct(name)));
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	public Response createProduct(@QueryParam("product") String product) {
		System.out.println("POST METHOD Request from Client with ............." + product);
		ProductRepresentation p;
		try {
			p = mapper.readValue(product, ProductRepresentation.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return filter.addCORS(Response.status(400));
		}
		ProductActivity activity = new ProductActivity();
		activity.createProduct(p.getSellerID(), p.getName(), p.getPrice(), p.getDescription());
		return filter.addCORS(Response.ok(p));
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/{productID}")
	public Response updateProduct(@PathParam("productID") String ID, @QueryParam("product") String product) {
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
	@Produces({"application/xml" , "application/json"})
	@Path("/{productId}")
	public Response options(@PathParam("productId") String id) {
		System.out.println("OPTIONS METHOD Request from Client with productRequest String ............." + id);
		return filter.addCORS(Response.ok());
	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/{productId}")
	public Response deleteProduct(@PathParam("productId") String id) {
		System.out.println("DELETE METHOD Request from Client with productRequest String ............." + id);
		ProductActivity pActivity = new ProductActivity();
		return filter.addCORS(Response.status(pActivity.deleteProduct(id)));
	}
	
}
