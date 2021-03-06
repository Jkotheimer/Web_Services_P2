package cs333.project_2.Service.Workflow;

import java.util.ArrayList;

import java.util.List;

import cs333.project_2.DOM.Product.Product;
import cs333.project_2.DOM.Product.ProductManager;
import cs333.project_2.Service.Link;
import cs333.project_2.Service.Representation.ProductRepresentation;;
/**
 * This class' responsibility is to manage the workflow of accessing/creating/updating/deleting resources
 * using the ProductDAL object.  
 *
 */
public class ProductActivity {

	private static ProductManager prod = new ProductManager();

	public List<ProductRepresentation> getProducts(String action, String query) {
		
		List<Product> products = prod.getProducts(action, query);
		if(products.size() == 0) return null;
		List<ProductRepresentation> productRepresentations = new ArrayList<ProductRepresentation>();
		
		for(Product p : products) {
          ProductRepresentation productRepresentation = new ProductRepresentation();
          productRepresentation.setID(p.getID());
          productRepresentation.setSellerID(p.getSellerID());
          productRepresentation.setName(p.getName());
          productRepresentation.setDescription(p.getDescription());
          productRepresentation.setPrice(p.getPrice());
          productRepresentation.setRating(p.getRating());
          setLinks(productRepresentation);
          //now add this representation in the list
          productRepresentations.add(productRepresentation);
        }
		return productRepresentations;
	}
	
	public ProductRepresentation getProductById(String ID) {
		
		Product p = prod.getProductById(ID);
		if(p == null) return null;
		ProductRepresentation pRep = new ProductRepresentation(p.getID(), p.getSellerID(), p.getName(), p.getPrice(), p.getDescription());
		pRep.setRating(p.getRating());
		setLinks(pRep);
		
		return pRep;
	}
	
	public ProductRepresentation createProduct(String SellerId, String name, double price, String Description) {
		
		Product p = prod.addProduct(SellerId, name, price, Description);
		if(p ==  null) return null;
		
		ProductRepresentation pr = new ProductRepresentation(p.getID(), SellerId, name, price, Description);
		setLinks(pr);
		
		return pr;
	}
	
	public ProductRepresentation updateProduct(String ID, String name, double price, String Description) {
		
		Product p = prod.updateProduct(ID, name, price, Description);
		if(p == null) return null;
		
		ProductRepresentation pr = new ProductRepresentation(ID, p.getSellerID(), name, price, Description);
		setLinks(pr);
		
		return pr;
	}
	
	public int deleteProduct(String id) {
		return prod.deleteProduct(id);
	}
	
	private void setLinks(ProductRepresentation product) {
		// Set up the activities that can be performed on orders
		Link[] buy = new Link[] {
				new Link("Update", "http://localhost:8081/products/" + product.getID()),
				new Link("Delete", "http://localhost:8081/products/" + product.getID()),
				new Link("Purchase", "http://localhost:8081/orders/")
		};
		product.setLinks(buy);
	}
	
}
