package cs333.project_2.Service.Workflow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cs333.project_2.DOM.Product.Product;
import cs333.project_2.DOM.Product.ProductManager;
import cs333.project_2.Service.Respresentation.ProductRepresentation;;
/**
 * This class' responsibility is to manage the workflow of accessing/creating/updating/deleting resources
 * using the ProductDAL object.  
 *
 */
public class ProductActivity {

	private static ProductManager prod = new ProductManager();
	
	public List<ProductRepresentation> getProducts() {
		
		List<Product> products = new ArrayList<Product>();
		List<ProductRepresentation> productRepresentations = new ArrayList<ProductRepresentation>();
		products = prod.getProducts();
		
		Iterator<Product> it = products.iterator();
		while(it.hasNext()) {
			Product p = (Product)it.next();
			ProductRepresentation productRepresentation = new ProductRepresentation();
			productRepresentation.setId(p.getProductID());
			productRepresentation.setItemDescrip(p.getItemDescrip());
			productRepresentation.setPrice((int)p.getPrice());
			
			//now add this representation in the list
			productRepresentations.add(productRepresentation);
        }
		return productRepresentations;
	}
	
	public ProductRepresentation getProduct(String id) {
		
		Product p = prod.getProduct(id);
		
		ProductRepresentation pRep = new ProductRepresentation();
		pRep.setPrice((int)p.getPrice());
		pRep.setItemDescrip(p.getItemDescrip());
		pRep.setId(p.getProductID());
		
		return pRep;
	}
	
	public ProductRepresentation createProduct(String ID, String sellerID, float price, String itemDescrip) {
		
		prod.addProduct(ID,sellerID,price,itemDescrip);
		Product p = new Product(ID, price,itemDescrip, sellerID);
		
		ProductRepresentation pRep = new ProductRepresentation();
		pRep.setId(p.getProductID());
		pRep.setItemDescrip(p.getItemDescrip());
		pRep.setPrice((int)p.getPrice());
		
		return pRep;
	}
	
	public String deleteProduct(String id) {
		
		prod.deleteProduct(id);
		
		return "OK";
	}
	
}
