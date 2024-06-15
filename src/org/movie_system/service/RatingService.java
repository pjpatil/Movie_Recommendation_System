package org.movie_system.service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.movie_system.model.GenresModel;
import org.movie_system.model.RatingModel;
import org.movie_system.repository.RatingRepository;

public class RatingService {
	Scanner sc = new Scanner(System.in);
	RatingRepository rRepo=new RatingRepository();
	GenresService gs = new GenresService();
	
	public boolean isAddUserWatchHistory(int uid, RatingModel rModel) {
	
		return rRepo.isAddUserWatchHistory(uid,rModel);
	}


	public List<RatingModel> getUserWatchHistory(int uid) {
		
		return rRepo.getUserWatchHistory(uid);
	}


	
	public Map<String,Float> getCumPer(int gid){
		return rRepo.getCummPer(gid);
	}
	
	

	public void predict() {
		
		List<GenresModel> gl=gs.getAllGenres();
		System.out.println("+------------------------- Movie Generes -----------------------------+");
		for (GenresModel gM : gl) {
			System.out.println(gM.getGenid()+"\t"+gM.getGentitle());
		}
		System.out.println("+---------------------------------------------------------------------+");
		System.out.println("Choose Genres ID");
		int gid=sc.nextInt();          // Genres ID 
		int total=rRepo.getTotal()*5;		
//		System.out.println(total);		
		
		Map<String,Float> getC=rRepo.getCummPer(gid);
//		System.out.println(getC);		
		Set<Map.Entry<String,Float>> map=getC.entrySet();
		System.out.println("Recommended movies are:");
		System.out.println("+------------------------------------------------------------+");
		for (Map.Entry<String, Float> en : map) {
			if(en.getValue()>=30.0f)
			{
			System.out.println(en.getKey());
			}
		}
		System.out.println("+------------------------------------------------------------+");
		gl.clear();
		getC.clear();
	}
	
	
}
