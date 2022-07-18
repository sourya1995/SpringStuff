package io.datajek.spring.basics.movierecommendersystem.movierecommendersystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {
	
	
	private Filter filter;
	
	@Autowired
	public RecommenderImplementation(@Qualifier("collaborativeFilter")Filter filter) {
		
		this.filter = filter;
	}
	
	public String[] recommendMovies(String movie) {
		System.out.println("Name of the filter in use: " + filter + "\n");
		String results[] = filter.getRecommendations("Finding Dory");
		return results;
	}
	

}
