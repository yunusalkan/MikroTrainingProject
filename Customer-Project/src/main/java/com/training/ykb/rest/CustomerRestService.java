package com.training.ykb.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;
import com.training.ykb.DTO.CustomerDTO;
import com.training.ykb.service.CustomerManager;
import com.training.ykb.util.DTOMapper;


@RestController
@RequestMapping("/api/v1/customer/provision")
public class CustomerRestService {

	@Autowired
	private CustomerManager custManager;

	@PostMapping("/add")
	public String addCustomer(@Validated @RequestBody final CustomerDTO customer) {
		return custManager.addOrUpdate(DTOMapper.mapToCustomer(customer));
	}

	@GetMapping("/delete")
	public String remove(@NotNull @RequestParam("pid") final Long custId) {
		return this.custManager.remove(custId);
	}

	@GetMapping("/get")
	public CustomerDTO get(@RequestParam("pid") final Long custId) {
		return DTOMapper.mapToCustomerDTO(this.custManager.get(custId));
	}

	@PostMapping("/update")
	public String update(@RequestBody final CustomerDTO customerParam) {
		return this.custManager.addOrUpdate(DTOMapper.mapToCustomer(customerParam));
	}

}
