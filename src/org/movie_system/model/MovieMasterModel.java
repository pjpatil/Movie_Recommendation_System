package org.movie_system.model;

public class MovieMasterModel {
	private int mid;            // movie id
	private String movtitle;    // movie title 
	private int movyear;       // movie Year
	private int movtime;       // movie duration time
	private String movlang;    // movie language
	private String movdtrel;  // movie rel date
	private String movrelcountry;   // movie rel country
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMovtitle() {
		return movtitle;
	}
	public void setMovtitle(String movtitle) {
		this.movtitle = movtitle;
	}
	public int getMovyear() {
		return movyear;
	}
	public void setMovyear(int movyear) {
		this.movyear = movyear;
	}
	public int getMovtime() {
		return movtime;
	}
	public void setMovtime(int movtime) {
		this.movtime = movtime;
	}
	public String getMovlang() {
		return movlang;
	}
	public void setMovlang(String movlang) {
		this.movlang = movlang;
	}
	public String getMovdtrel() {
		return movdtrel;
	}
	public void setMovdtrel(String movdtrel) {
		this.movdtrel = movdtrel;
	}
	public String getMovrelcountry() {
		return movrelcountry;
	}
	public void setMovrelcountry(String movrelcountry) {
		this.movrelcountry = movrelcountry;
	}
}
