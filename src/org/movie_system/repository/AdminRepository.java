package org.movie_system.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.movie_system.model.AdminModel;

import mrs.predict.config.DBHelper;



public class AdminRepository extends DBHelper {

//	private List<AdminModel> list = new ArrayList<AdminModel>();
	
//	Store admin data in database
	public boolean isAddNewAdmin(AdminModel amodel) {
		List<AdminModel> list = new ArrayList<AdminModel>();
		try {
			stmt = conn.prepareStatement("insert into Admin values('0',?,?,?)");
			stmt.setString(1, amodel.getAdminname());
			stmt.setString(2, amodel.getAmobileno());
			stmt.setString(3,amodel.getApassword());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return false;
		}

	}


	// show all Admin
	public List<AdminModel> getAllAdmin() {
		List<AdminModel> list = new ArrayList<AdminModel>();
		try {
			stmt = conn.prepareStatement("select *from admin");
			rs = stmt.executeQuery();
			while (rs.next()) {
				AdminModel model = new AdminModel();
				model.setAdminid(rs.getInt(1));
				model.setAdminname(rs.getString(2));
				model.setAmobileno(rs.getString(3));
				model.setApassword(rs.getString(4));
				list.add(model);
			}
			return list.size() > 0 ? list : null;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return null;
		}
	}
	
	
	// it is admin login check 
	public boolean isAdminValid(String mono,String password) {
		try{
			stmt = conn.prepareStatement("select *from Admin where amobileno=? and apassword=?");
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


	public boolean checkadminid(String temob) {
		try{
			stmt = conn.prepareStatement("select *from Admin where amobileno=?");
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
			stmt = conn.prepareStatement("update admin set apassword=? where amobileno=?");
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
