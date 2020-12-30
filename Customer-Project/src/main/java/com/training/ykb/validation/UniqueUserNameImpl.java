package com.training.ykb.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.training.ykb.service.CustomerManager;

public class UniqueUserNameImpl implements ConstraintValidator<UniqueUserName, String> {
	
	
	private static final Logger log = LoggerFactory.getLogger(UniqueUserNameImpl.class);


	@Autowired
	CustomerManager cm;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		log.info("Validasyonun içine girdi");
		// TODO Auto-generated method stub
		return !cm.getAll().stream().anyMatch(p -> p.getUserName().equalsIgnoreCase(value));
	}

}
