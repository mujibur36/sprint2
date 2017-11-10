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

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "discount", "", "Field discount cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "", "A start date must be provided.");
		
		
		if (dto.getDiscount() == 0 || dto.getDiscount() == 0.0) {
			errors.rejectValue("discount", "", "Discount must be different from 0.");
		}
		
		
		if(dto.getDiscount() < 0.0) {
			errors.rejectValue("discount", "", "Discount cannot be negative.");
		}
		
		
		if(dto.getEndDate() != null && dto.getEndDate().isBefore(dto.getStartDate()) ) {
			errors.rejectValue("endDate", "", "An end date cannot precede the start date.");
		}
		

	}
	
	
}
