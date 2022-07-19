package io.datajek.springaop.movierecommenderaop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.datajek.springaop.movierecommenderaop.data.Movie;

@Service
public class FilteringTechnique1 {
	@Autowired
	private Movie movie;
	
	public String ContentBasedFiltering() {
		String movieDetails = movie.getMovieDetails();
		return movieDetails;
	}

}
