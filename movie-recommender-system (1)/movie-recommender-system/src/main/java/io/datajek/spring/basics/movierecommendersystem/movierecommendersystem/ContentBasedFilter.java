package io.datajek.spring.basics.movierecommendersystem.movierecommendersystem;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ContentBasedFilter implements Filter {

	@Override
	public String[] getRecommendations(String movie) {
		// TODO Auto-generated method stub
		return new String[] {"Happy Feet", "Ice Age", "Shark Tale"};
	}
	

}
