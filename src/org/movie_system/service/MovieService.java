package org.movie_system.service;

import java.util.List;

import org.movie_system.model.MovieMasterModel;
import org.movie_system.model.UserModel;
import org.movie_system.repository.MovieRepository;

public class MovieService {

	MovieRepository mRepo=new MovieRepository();
	
	public Boolean isAddMovie(MovieMasterModel mmodel) {
		
		boolean b=mRepo.isAddMovie(mmodel);
		return b;
	}

	public List<MovieMasterModel> getAllMovies()
	{
		return mRepo.getAllMovies();
	}

	
	
	
	public int getMovId(String name)
    {
    	return mRepo.getmovie(name);
    }
	
//    public int getUserIdAutomatic()
//    {
//    	return mRepo.getUserIdAutomatic();
//    }
//    public boolean isAddUser(UserModel umodel)
//    {
//        return mRepo.isAddUser(umodel);	
//    }

	public List<MovieMasterModel> getTopTreeMovies() {
		return mRepo.getTopTreeMovies();
	}
	
	
	
	
	
}
