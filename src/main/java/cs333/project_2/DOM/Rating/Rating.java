package cs333.project_2.DOM.Rating;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "rating")
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

	@Id
	@Column(name="ratingid")
	public int getID() {
		return this.ID;
	}

	@Column(name = "review")
	public String getReview() {
		return this.Review;
	}

	@Column(name = "rateval")
	public int getRateval() {
		return this.Rateval;
	}

}