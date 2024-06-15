package org.movie_system.model;

public class RatingModel extends  MovieMasterModel{
	private int watchId;
	private float rating_num;
	private String feedback;
	
	public int getWatchId() {
		return watchId;
	}
	public void setWatchId(int watchId) {
		this.watchId = watchId;
	}
	public float getRating_num() {
		return rating_num;
	}
	public void setRating_num(float rating_num) {
		this.rating_num = rating_num;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
}
