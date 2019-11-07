package cs333.project_2.DOM.Rating;

public class Rating {

	private int ID;
	private int Rateval;
	private String Review;

	public Rating() {
	
	}
	
	public Rating(int ID, int rateval, String review) {
		this.ID = ID;
		this.Rateval = rateval;
		this.Review = review;
	}

	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */
	public void setID(int Id) {
		this.ID = Id;
	}
	
	public void setRateval(int rateval) {
		this.Rateval = rateval;
	}

	public void setReview(String review) {
		this.Review = review;
	}

	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */

	public int getID() {
		return this.ID;
	}

	public String getReview() {
		return this.Review;
	}

	public int getRateval() {
		return this.Rateval;
	}

}