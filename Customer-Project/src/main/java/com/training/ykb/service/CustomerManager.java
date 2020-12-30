package com.training.ykb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.ykb.dao.ICustomerDao;
import com.training.ykb.model.Customer;

@Service
public class CustomerManager {

	@Autowired
	private ICustomerDao custDAO;

	public String addOrUpdate(final Customer customer) {
		this.custDAO.save(customer);
		return "OK";
	}

	public String remove(final Long customerId) {
		this.custDAO.deleteById(customerId);
		return "OK";
	}

	public Customer get(final Long customerIdParam) {
		return this.custDAO.findById(customerIdParam).orElse(null);
	}

	public List<Customer> getAll() {
		Iterable<Customer> findAllLoc = this.custDAO.findAll();
		List<Customer> customerList = new ArrayList<>();
		for (Customer customer : findAllLoc) {
			customerList.add(customer);
		}
		return customerList;
	}

	public Customer searchByUserName(final String userName) {
		return this.custDAO.findByUserName(userName);
	}

	public Customer searchByEmail(final String email) {
		return this.custDAO.findByEmail(email);
	}
}
