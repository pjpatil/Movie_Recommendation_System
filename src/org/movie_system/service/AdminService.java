package org.movie_system.service;

import java.util.List;

import org.movie_system.model.AdminModel;
import org.movie_system.repository.AdminRepository;


public class AdminService {

	AdminRepository adRepo  = new AdminRepository();
	
	// Save admin data
	public boolean isAddAdmin(AdminModel amodel) {
		boolean b= adRepo.isAddNewAdmin(amodel);
		return b;
	}
	
	
	// Display all Admin 
	public List<AdminModel> getAllAdmin(){
//		List<AdminModel>list= adRepo.getAllAdmin();
//		return list;
		return adRepo.getAllAdmin();
	}
	
	
	// it is admin login check 
	public boolean isAdminValid(String mono,String password) {
		boolean b= adRepo.isAdminValid(mono, password);
		return b;
	}


	// it is check id in admin 
	public boolean checkadminid(String temob) {
		boolean b= adRepo.checkadminid(temob);
		return b;
	}

	// change admin password
	public boolean changePassword(String temob, String newpassword) {
		boolean b=adRepo.changePassword(temob,newpassword);
		return b;
	}
	
	
	
}
