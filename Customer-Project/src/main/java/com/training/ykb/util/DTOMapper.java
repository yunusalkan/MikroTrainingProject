package com.training.ykb.util;

import com.training.ykb.DTO.CustomerDTO;
import com.training.ykb.model.Customer;

public class DTOMapper {

	public static Customer mapToCustomer(CustomerDTO custDTO) {
		if(custDTO != null) {
			Customer customer = new Customer();
			customer.setCustId(custDTO.getCustId());
			customer.setUserName(custDTO.getUserName());
			customer.setEmail(custDTO.getEmail());
			customer.setGender(custDTO.getGender());
			customer.setPassword(custDTO.getPassword());
			customer.setAge(custDTO.getAge());
			return customer;
		}
		return null;
	}
	
	public static CustomerDTO mapToCustomerDTO(Customer customer) {
		if(customer != null) {
			CustomerDTO custDTO = new CustomerDTO();
			custDTO.setCustId(customer.getCustId());
			custDTO.setUserName(customer.getUserName());
			custDTO.setEmail(customer.getEmail());
			custDTO.setGender(customer.getGender());
			custDTO.setPassword(customer.getPassword());
			custDTO.setAge(customer.getAge());
			return custDTO;
		}
		return null;
	}
}
