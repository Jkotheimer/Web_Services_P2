package cs333.project_2;

import cs333.project_2.Order.Product;
import cs333.project_2.Profile.Address;
import cs333.project_2.Profile.Seller;

public class App 
{
    public static void main( String[] args )
    {
    	Product product3 = new Product();
    	
    	Seller seller = new Seller();
    	
    	seller.setID(4567);
    	
    	product3.setID(7654);
    	
    	product3.setProductID(12132);
    	
    	System.out.println(seller.getID());
    	
        System.out.println(product3.getproductID() +" and "+ product3.getID());
        
    }
}
