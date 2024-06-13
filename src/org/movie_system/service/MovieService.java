package org.movie_system.service;

import java.util.List;

import org.movie_system.model.GenresModel;
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

	
	public List<MovieMasterModel> getMovie(String smovie) {
		
		return mRepo.getMovie(smovie);
	}

	

	public int getMovId()
    {
    	return mRepo.getMovId();
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

	public boolean checkMovId(int tempId) {
		
		return mRepo.checkMovId(tempId);
	}

	public boolean checkMovName(String smovie) {
		
		return mRepo.checkMovName(smovie);
	}
	
	
	
	public boolean updateTitle(int tempId, String newTitle) {
				return mRepo.updateTitle(tempId,newTitle);
	}

	public boolean deleteMovie(int newId) {
		
		return mRepo.deleteMovie(newId);
	}

	public GenresModel getConcat(String movtit) {
		
		return mRepo.getConcat(movtit);
	}

	
	
	

	
}
