package org.movie_system.model;

public class UserModel extends MovieMasterModel {

	private int uid;
	private String uname;
	private int uage;
	private String umobileno;
	private String upassword;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public String getUmobileno() {
		return umobileno;
	}
	public void setUmobileno(String umobileno) {
		this.umobileno = umobileno;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
}



