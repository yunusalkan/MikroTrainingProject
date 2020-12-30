package com.training.ykb.dao;

import org.springframework.data.repository.CrudRepository;

import com.training.ykb.model.Customer;

public interface ICustomerDao extends CrudRepository<Customer, Long> {
	
	Customer findByUserName(String userName);
	
	Customer findByEmail(String email);

}
