package cs333.project_2.Service;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import cs333.project_2.Service.Respresentation.ProductRepresentation;
import cs333.project_2.Service.Respresentation.ProductRequest;
import cs333.project_2.Service.Workflow.ProductActivity;

@Path("/productservice/")
public class ProductResource implements ProductService {

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/product")
	public Set<ProductRepresentation> getProducts() {
		System.out.println("GET METHOD Request for all products .............");
		ProductActivity empActivity = new ProductActivity();
		return empActivity.getProducts();	
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/product/{productId}")
	public ProductRepresentation getProduct(@PathParam("productId") int id) {
		System.out.println("GET METHOD Request from Client with productRequest String ............." + id);
		ProductActivity empActivity = new ProductActivity();
		return empActivity.getProduct(id);
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/product")
	public ProductRepresentation createProduct(ProductRequest  productRequest) {
		System.out.println("POST METHOD Request from Client with ............." + productRequest.getItemDescrip() + "  " + productRequest.getPrice());
		ProductActivity empActivity = new ProductActivity();
		return empActivity.createProduct(1234,4321,productRequest.getPrice(),productRequest.getItemDescrip());
	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/product/{productId}")
	public Response deleteProduct(@PathParam("productId") int id) {
		System.out.println("Delete METHOD Request from Client with productRequest String ............." + id);
		ProductActivity empActivity = new ProductActivity();
		String res = empActivity.deleteProduct(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}
	
}
