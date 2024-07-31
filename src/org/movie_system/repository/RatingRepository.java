package org.movie_system.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.movie_system.model.MovieMasterModel;
import org.movie_system.model.RatingModel;
import org.movie_system.model.UserModel;

import mrs.predict.config.DBHelper;

public class RatingRepository extends DBHelper{

	public boolean isAddUserWatchHistory(int uid, RatingModel rModel) {
		List<RatingModel> list = new ArrayList<RatingModel>();
		try {
			stmt = conn.prepareStatement("insert into UserWatchHistory values('0',?,?,?,?)");
			stmt.setInt(1, uid);
			stmt.setInt(2, rModel.getMid());
			stmt.setFloat(3,rModel.getRating_num());
			stmt.setString(4,rModel.getFeedback());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return false;
		}

	}

	public List<RatingModel> getUserWatchHistory(int uid) {
		List<RatingModel> list = new ArrayList<RatingModel>();
		try {
			stmt = conn.prepareStatement("select m.mov_id, m.mov_title,m.mov_year,m.mov_time,uwh.rating_num,uwh.feedback from UserWatchHistory uwh inner join moviemaster m on uwh.mov_id=m.mov_id inner join User u on uwh.uid=u.uid  where uwh.uid=?;");
			stmt.setInt(1, uid);
			rs = stmt.executeQuery();
			while (rs.next()) {
				RatingModel model = new RatingModel();
			
				model.setMid(rs.getInt(1));
				model.setMovtitle(rs.getString(2));
				model.setMovyear(rs.getInt(3));
				model.setMovtime(rs.getInt(4));
				model.setRating_num(rs.getFloat(5));
				model.setFeedback(rs.getString(6));
				
				list.add(model);
			}
			return list.size() > 0 ? list : null;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return null;
		}
		
	}

	public int getTotal() {
		try
		{
			stmt=conn.prepareStatement("select count(watchId) from UserWatchHistory;");
			rs=stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}else {
				return 0;
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("Exception is"+ex);
			return 0;
		}
	}
	
	public Map<String, Float> getCummPer(int gid) {
		try
    	{	Map<String, Float> tmap = new LinkedHashMap<String, Float>();
    		stmt=conn.prepareStatement("select (select mov_title from moviemaster where mov_id=mg.mov_id) from movie_genres mg where mg.gen_id IN (select gen_id from genres where gen_id=?)");
    		stmt.setInt(1, gid);
    		rs=stmt.executeQuery();
    		while(rs.next()) {
//    			tmap.put(rs.getString(1), null);
    			//System.out.println(rs.getString(1));
    			PreparedStatement pst=conn.prepareStatement("select avg(rating_num) from UserWatchHistory  where mov_id =(select mov_id from moviemaster where mov_title=?);");
    					
    			pst.setString(1,rs.getString(1));
    			ResultSet rs1=pst.executeQuery();
    			if(rs1.next()){
//    				System.out.println(rs1.getFloat(1)*10);
    				tmap.put(rs.getString(1),rs1.getFloat(1)*10);
    			}
    		}
    		return tmap;
    	}
    	catch(Exception ex)
    	{
    		System.out.println("Exception is "+ex);
    		return null;
    	}
	}
	
	
}
