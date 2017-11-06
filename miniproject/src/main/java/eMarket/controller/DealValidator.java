package eMarket.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import eMarket.EMarketApp;
import eMarket.domain.Deal;

public class DealValidator implements Validator {
		
	public boolean supports(Class<?> clazz) {
        return DealFormDto.class.equals(clazz);
    }

	@Override
	public void validate(Object target, Errors errors) {
		DealFormDto dto = (DealFormDto) target;

		// TODO: add validation code here
		
	}
	
	
}
