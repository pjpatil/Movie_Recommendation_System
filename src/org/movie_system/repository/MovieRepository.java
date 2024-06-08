package org.movie_system.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.movie_system.model.AdminModel;
import org.movie_system.model.MovieMasterModel;
import org.movie_system.model.UserModel;

import com.mysql.cj.jdbc.CallableStatement;

import mrs.predict.config.DBHelper;

public class MovieRepository extends DBHelper {
	private int uid=0;

	public boolean isAddMovie(MovieMasterModel mmodel) {
		try {
			stmt = conn.prepareStatement("insert into moviemaster values('0',?,?,?,?,?,?)");

			stmt.setString(1, mmodel.getMovtitle());
			stmt.setInt(2, mmodel.getMovyear());
			stmt.setInt(3, mmodel.getMovtime());
			stmt.setString(4, mmodel.getMovlang());
			stmt.setString(5, mmodel.getMovdtrel());
			stmt.setString(6, mmodel.getMovrelcountry());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		}

		catch (Exception ex) {
			System.out.println("Error is" + ex);
			return false;
		}
	 }

	public List<MovieMasterModel> getAllMovies() {
		List<MovieMasterModel> list = new ArrayList<MovieMasterModel>();
		try {
			stmt = conn.prepareStatement("select *from moviemaster");
			rs = stmt.executeQuery();
			while (rs.next()) {
				MovieMasterModel model = new MovieMasterModel();
			
				model.setMid(rs.getInt(1));
				model.setMovtitle(rs.getString(2));
				model.setMovyear(rs.getInt(3));
				model.setMovtime(rs.getInt(4));
				model.setMovlang(rs.getString(5));
				model.setMovdtrel(rs.getString(6));
				model.setMovrelcountry(rs.getString(7));
				list.add(model);
			}
			return list.size() > 0 ? list : null;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return null;
		}
	}
	
	
	public int getmovie(String name)
    {
 	   try
 	   {
 		   stmt=conn.prepareStatement("select movid from moviemaster where mov_title=?");
 		   stmt.setString(1, name);
 		   rs=stmt.executeQuery();
 		   if(rs.next())
 		   {
 			   return rs.getInt(1);
 		   }
 		   else
 		   {
 			   return -1;
 		   }
 		   
 	   }
 	   catch(Exception ex)
 	   {
 		   System.out.println("Exception is"+ex);
 		   return -1;
 	   }
    }
//    public int getUserIdAutomatic()
//    {
// 	   try
// 	   {
// 		   stmt=conn.prepareStatement("select max(userid) from user");
// 		   rs=stmt.executeQuery();
// 		   if(rs.next())
// 		   {
// 			   this.uid=rs.getInt(1);
// 		   }
// 		   ++uid;
// 		   return uid;
// 		   
// 	   }
// 	   catch(Exception ex)
// 	   {
// 		   return 0;
// 		   
// 	   }
//    }
//    public boolean isAddUser(UserModel umodel)
//    {
// 	   try
// 	   {
// 		   clst= (CallableStatement) conn.prepareCall("{call saveuser(?,?,?,?,?,?)}");
// 		   clst.setInt(1, umodel.getUid());
// 		   clst.setString(2, umodel.getUname());
// 		  clst.setInt(3, umodel.getUage());
// 		 clst.setString(4, umodel.getUmobileno());
// 		   clst.setString(5, umodel.getUpassword());
// 		  
// 		   clst.setInt(6, umodel.getMid());
// 		   boolean b=clst.execute();
// 		   return !b;
// 		  
// 		   
// 	   }
// 	   catch(Exception ex)
// 	   {
// 		   System.out.println("Exception"+ex);
// 		   return false;
// 	   }
//    }

	public List<MovieMasterModel> getTopTreeMovies() {
		List<MovieMasterModel> list = new ArrayList<MovieMasterModel>();
		try {
			stmt = conn.prepareStatement("select *from moviemaster order by mov_dt_rel desc limit 3");
			rs = stmt.executeQuery();
			while (rs.next()) {
				MovieMasterModel model = new MovieMasterModel();
			
				model.setMid(rs.getInt(1));
				model.setMovtitle(rs.getString(2));
				model.setMovyear(rs.getInt(3));
				model.setMovtime(rs.getInt(4));
				model.setMovlang(rs.getString(5));
				model.setMovdtrel(rs.getString(6));
				model.setMovrelcountry(rs.getString(7));
				list.add(model);
			}
			return list.size() > 0 ? list : null;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return null;
		}
		

	}

	public boolean checkMovId(int tempId) {
		try{
			stmt = conn.prepareStatement("select *from moviemaster where mov_id=?");
			stmt.setInt(1, tempId);
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

	public boolean updateTitle(int tempId, String newTitle) {
		try{
			stmt = conn.prepareStatement("update moviemaster set mov_title =? where mov_id = ?");
			stmt.setString(1, newTitle);
			stmt.setInt(2, tempId);
			int value=stmt.executeUpdate();
			
			return value > 0 ? true : false;
		}
		catch(Exception ex) {
			System.out.println("Error is "+ex);
			return false;
		}
	}

	public boolean deleteMovie(int newId) {
		try{
			stmt = conn.prepareStatement("delete from moviemaster where mov_id =?");
			stmt.setInt(1, newId);
			int value=stmt.executeUpdate();
			
			return value > 0 ? true : false;
		}
		catch(Exception ex) {
			System.out.println("Error is "+ex);
			return false;
		}
	}
    

	
}
