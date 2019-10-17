package cs333.project_2.DOM.Rating;
import cs333.project_2.DAL.Rating.RatingDAL;

public class RatingManager {
	
	public Rating getRating(int id) {
		return RatingDAL.readRating(id);
	}
	

	public void addRating(int ID, int rateval, String review) {
		RatingDAL.createRating(ID, rateval, review);
	}

	public void updateRating(int ID, int rateval, String review) {
		RatingDAL.updateRating(ID, rateval, review);
	}

	public void deleteEmployee(int id) {
		RatingDAL.deleteRating(id);
	}

}