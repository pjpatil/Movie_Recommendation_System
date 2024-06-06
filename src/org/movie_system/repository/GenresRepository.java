package org.movie_system.repository;

import java.io.BufferedReader;
import java.io.FileReader;

import mrs.predict.config.DBHelper;
import mrs.predict.config.PathHelper;

public class GenresRepository extends DBHelper {

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
	
}
