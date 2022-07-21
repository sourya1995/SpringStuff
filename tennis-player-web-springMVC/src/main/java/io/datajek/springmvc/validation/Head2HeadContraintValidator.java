package io.datajek.springmvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Head2HeadContraintValidator implements ConstraintValidator <HeadToHead, String>{

	@Override
	public void initialize(HeadToHead headToHeadScore) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String headToHeadScore, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		boolean isValid = headToHeadScore.matches("[0-9]{1,2}-[0-9]{1,2}");
		return isValid;
	}

}
