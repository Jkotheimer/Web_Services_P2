package cs333.project_2.Service;

import java.util.List;
import javax.jws.WebService;

import cs333.project_2.Service.Respresentation.ProductRepresentation;
import cs333.project_2.Service.Respresentation.ProductRequest;

@WebService
public interface ProductService {

	public List<ProductRepresentation> getProducts();
	public ProductRepresentation getProduct(String ProductId);
	public ProductRepresentation createProduct(ProductRequest productRequest);
	
}
