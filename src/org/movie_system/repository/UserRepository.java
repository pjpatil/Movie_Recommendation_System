package org.movie_system.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.movie_system.model.AdminModel;
import org.movie_system.model.UserModel;

import mrs.predict.config.DBHelper;

public class UserRepository extends DBHelper {

//	private List<UserModel> list = new ArrayList<UserModel>();
	
	public boolean isAddUser(UserModel umodel) {
		List<UserModel> list = new ArrayList<UserModel>();
		try {
			stmt = conn.prepareStatement("insert into user values('0',?,?,?,?)");
			stmt.setString(1,umodel.getUname());
			stmt.setInt(2,umodel.getUage());
			stmt.setString(3, umodel.getUmobileno());
			stmt.setString(4,umodel.getUpassword());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return false;
		}
	}
	
	// show all user
	public List<UserModel> getAllUser() {
		List<UserModel> list = new ArrayList<UserModel>();
		try {
			stmt = conn.prepareStatement("select *from user");
			rs = stmt.executeQuery();
			while (rs.next()) {
				UserModel model = new UserModel();
				model.setUid(rs.getInt(1));
				model.setUname(rs.getString(2));
				model.setUage(rs.getInt(3));
				model.setUmobileno(rs.getString(4));
				model.setUpassword(rs.getString(5));
				list.add(model);
			}
			return list.size() > 0 ? list : null;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return null;
		}
	}

	public boolean isUserValid(String mono, String password) {
		try{
			stmt = conn.prepareStatement("select *from User where umobileno=? and upassword=?");
			stmt.setString(1,mono);
			stmt.setString(2,password);
			
			try(ResultSet rs=stmt.executeQuery()){
				if(rs.next())
					return true;
				else
					return false;
			}
		}
		catch(Exception ex) {
			System.out.println("Error is "+ex);
		}
		return false;
	}

	public boolean checkUserId(String temob) {
		try{
			stmt = conn.prepareStatement("select *from user where umobileno=?");
			stmt.setString(1, temob);
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
				return true;
			else
				return false;
		}
		catch(Exception ex) {
			System.out.println("Error is "+ex);
			return false;
		}
	}

	public boolean changePassword(String temob, String newpassword) {
		try{
			stmt = conn.prepareStatement("update user set upassword=? where umobileno=?");
			stmt.setString(1, newpassword);
			stmt.setString(2,temob);
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		}
		catch(Exception ex) {
			System.out.println("Error is "+ex);
			return false;
		}
	}
	
}
