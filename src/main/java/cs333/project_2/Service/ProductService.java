package cs333.project_2.Service;

import java.util.Set;

import javax.jws.WebService;

import cs333.project_2.DOM.Product.Product;
import cs333.project_2.Service.Respresentation.ProductRepresentation;
import cs333.project_2.Service.Respresentation.ProductRequest;

@WebService
public interface ProductService {

	public Set<ProductRepresentation> getProducts();
	public ProductRepresentation getProduct(int ProductId);
	public ProductRepresentation createProduct(ProductRequest productRequest);
	
}
