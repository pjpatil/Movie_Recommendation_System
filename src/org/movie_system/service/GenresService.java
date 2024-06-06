package org.movie_system.service;

import org.movie_system.repository.GenresRepository;

public class GenresService {

	GenresRepository gRepo=new GenresRepository();
	public boolean isBulkAddGenres() {
		return gRepo.isBulkAddGenres();
	}

}
