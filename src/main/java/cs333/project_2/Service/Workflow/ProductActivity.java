package cs333.project_2.Service.Workflow;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import cs333.project_2.DOM.Product.Product;
import cs333.project_2.DOM.Product.ProductManager;
import cs333.project_2.DOM.Seller.SellerManager;
import cs333.project_2.Service.Link;
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
          productRepresentation.setproductID(p.getProductID());
          productRepresentation.setItemDescrip(p.getItemDescrip());
          productRepresentation.setPrice(p.getPrice());
          productRepresentation.setRating(p.getRating());
          
          //now add this representation in the list
          productRepresentations.add(productRepresentation);
        }
		return productRepresentations;
	}
	
	public List<ProductRepresentation> getListProducts() {
		
		List<Product> products = new ArrayList<Product>();
		List<ProductRepresentation> productRepresentations = new ArrayList<ProductRepresentation>();
		products = prod.getProducts();
		
		Iterator<Product> it = products.iterator();
		while(it.hasNext()) {
          Product p = (Product)it.next();
          ProductRepresentation productRepresentation = new ProductRepresentation();
          productRepresentation.setproductID(p.getProductID());
          productRepresentation.setPrice(p.getPrice());
          productRepresentation.setRating(p.getRating());
          
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
		pRep.setproductID(p.getProductID());
		setLinks(pRep);
		
		return pRep;
	}
	
	public ProductRepresentation createProduct(String ID,String SellerId, float price, String itemDescrip) {
		
		prod.addProduct(ID,SellerId,price,itemDescrip);
		Product p = new Product(ID,price,itemDescrip,SellerManager.readSeller(SellerId));
		
		ProductRepresentation pRep = new ProductRepresentation();
		pRep.setproductID(p.getProductID());
		pRep.setItemDescrip(p.getItemDescrip());
		pRep.setPrice((int)p.getPrice());
		
		return pRep;
	}
	
	public String deleteProduct(String id) {
		
		prod.deleteProduct(id);
		
		return "OK";
	}
	
	private void setLinks(ProductRepresentation product) {
		// Set up the activities that can be performed on orders
		Link buy = new Link("buy", 
			"http://localhost:8081/orderservice/order/" + product.getProductID());	
		product.setLinks(buy);
	}
	
}
