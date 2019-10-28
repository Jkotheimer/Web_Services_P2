package cs333.project_2.Service.Workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
	
	public Set<ProductRepresentation> getProducts() {
		
		Set<Product> products = new HashSet<Product>();
		Set<ProductRepresentation> productRepresentations = new HashSet<ProductRepresentation>();
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
	
	public ProductRepresentation getProduct(int id) {
		
		Product p = prod.getProduct(id);
		
		ProductRepresentation pRep = new ProductRepresentation();
		pRep.setPrice((int)p.getPrice());
		pRep.setItemDescrip(p.getItemDescrip());
		pRep.setId(p.getProductID());
		
		return pRep;
	}
	
	public ProductRepresentation createProduct(int ID,int sellerID, float price, String itemDescrip) {
		
		prod.addProduct(ID,sellerID,price,itemDescrip);
		Product p = new Product(ID,price,itemDescrip);
		
		ProductRepresentation pRep = new ProductRepresentation();
		pRep.setId(p.getProductID());
		pRep.setItemDescrip(p.getItemDescrip());
		pRep.setPrice((int)p.getPrice());
		
		return pRep;
	}
	
	public String deleteProduct(int id) {
		
		prod.deleteProduct(id);
		
		return "OK";
	}
	
}
