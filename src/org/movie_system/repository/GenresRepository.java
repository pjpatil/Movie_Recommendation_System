package org.movie_system.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.movie_system.model.GenresModel;

import mrs.predict.config.DBHelper;
import mrs.predict.config.PathHelper;

public class GenresRepository extends DBHelper {

	
	
	
	// add bulk File 
	public boolean isBulkAddGenres() {
		try {
			FileReader fr=new FileReader(PathHelper.path+"genres.csv");
			BufferedReader br=new BufferedReader(fr);
			int value =0;
			String line=null;
			
			while((line=br.readLine())!=null) {
				String data[]=line.split(",");
				stmt=conn.prepareStatement("insert into genres values('0',?)");
				stmt.setString(1,data[1]);
				
				value=stmt.executeUpdate();
			}
			return value>0?true:false;
		}
		catch(Exception ex) {
			System.out.println("Error is "+ex);
		}
		
		return false;
	}

	
     // add new genres 
	public boolean isAddGenres(GenresModel gModel) {
		
		try {
			stmt = conn.prepareStatement("insert into genres values('0',?)");
			stmt.setString(1, gModel.getGentitle());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;

		}
		catch (Exception ex) {
			System.out.println("Error is" + ex);
			return false;
		}
	}

	
	// Display all genres.
	public List<GenresModel> getAllGenres() {
	
		 List<GenresModel> list=new ArrayList<GenresModel>();
		try {
			stmt = conn.prepareStatement("select *from genres order by gen_id asc");
				rs=stmt.executeQuery();
				while(rs.next())
				{
					GenresModel gmodel=new GenresModel();
					gmodel.setGenid(rs.getInt(1));
					gmodel.setGentitle(rs.getString(2));
					
					list.add(gmodel);
					
				}
				return list.size() > 0 ? list : null;
			} catch (Exception ex) {
				System.out.println("Error is " + ex);
			}
		return list;
		
		
	}
	
	public boolean isAddMovGenJoin(int tempmid, int tempid) {
		
		try {
			stmt = conn.prepareStatement("insert into movie_genres values('0',?,?)");
			stmt.setInt(1, tempmid);
			stmt.setInt(2, tempid);
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;

		}
		catch (Exception ex) {
			System.out.println("Error is" + ex);
			return false;
		}
	}
	
	

	// fatch all genres in link movie
	public List<GenresModel> getAllMovieGenres() {
	    List<GenresModel> list=new ArrayList<GenresModel>();
		List<GenresModel> movies=new ArrayList<>();
		try {
			stmt = conn.prepareStatement(" select m.mov_id,m.mov_title,m.mov_year,m.mov_time,m.mov_lang,m.mov_dt_rel,m.mov_rel_country,g.gen_id,g.gen_title \r\n"
					+ " from moviemaster m inner join movie_genres mg on m.mov_id=mg.mov_id inner join genres g on g.gen_id=mg.gen_id");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				GenresModel gmodel=new GenresModel();
				gmodel.setMid(rs.getInt(1));
				gmodel.setMovtitle(rs.getString(2));
				gmodel.setMovyear(rs.getInt(3));
				gmodel.setMovtime(rs.getInt(4));
				gmodel.setMovlang(rs.getString(5));
				gmodel.setMovdtrel(rs.getString(6));
				gmodel.setMovrelcountry(rs.getString(7));
				gmodel.setGenid(rs.getInt(8));
				gmodel.setGentitle(rs.getString(9));
				
				list.add(gmodel);
				
			}
			return list.size() > 0 ? list : null;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
		}
		return movies;


	}
		
	
	

	
}
