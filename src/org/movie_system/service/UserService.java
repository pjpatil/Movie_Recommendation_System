package org.movie_system.service;

import java.util.List;

import org.movie_system.model.AdminModel;
import org.movie_system.model.UserModel;
import org.movie_system.repository.UserRepository;

public class UserService {

	UserRepository uRepo =new UserRepository();
	
	
	public boolean isAddUser(UserModel umodel) {
		boolean b=uRepo.isAddUser(umodel);
		return b;
	}
	
	
	// Display all Admin 
		public List<UserModel> getAllUser(){

			return uRepo.getAllUser();
		}


		public boolean isUserValid(String mono, String password) {
			boolean b= uRepo.isUserValid(mono, password);
			return b;
		}


		public boolean checkUserId(String temob) {
			boolean b=uRepo.checkUserId(temob);
			return b;
		}


		public boolean changePassword(String temob, String newpassword) {
			boolean b=uRepo.changePassword(temob,newpassword);
			return b;
		}
	
	
	
}
