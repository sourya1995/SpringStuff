package io.datajek.spring.basics.movierecommendersystem.movierecommendersystem;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Qualifier("CF")
public class CollaborativeFilter implements Filter {

	@Override
	public String[] getRecommendations(String movie) {
		// TODO Auto-generated method stub
		return new String[] {"Finding Nemo", "Ice Age", "Toy Story"};
	}

}
