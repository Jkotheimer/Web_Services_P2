package cs333.project_2.DOM.Rating;

import cs333.project_2.DAL.Seller.SellerDAL;

public class RatingManager {
	
	public void addRating(String prodName,String reviewname,int score, String reviewcontent) {
		SellerDAL.addProductReview(prodName, reviewname, score, reviewcontent);
	}
	
}