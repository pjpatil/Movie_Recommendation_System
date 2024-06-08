package org.movie_system.service;

import java.util.List;

import org.movie_system.model.GenresModel;
import org.movie_system.repository.GenresRepository;

public class GenresService {

	GenresRepository gRepo=new GenresRepository();
	
	
	public boolean isBulkAddGenres() {
		return gRepo.isBulkAddGenres();
	}
	
	
	public boolean isAddGenres(GenresModel gModel) {
		boolean b=gRepo.isAddGenres(gModel);
		return b;

	}
	
	
	
	public List<GenresModel> getAllMovieGenres() {
		
		return gRepo.getAllMovieGenres();
	}

}
