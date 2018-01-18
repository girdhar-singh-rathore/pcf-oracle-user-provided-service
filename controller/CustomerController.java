package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.domain.Customer;
import com.tech.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customers")
	public List<Customer> getAllCustomer() {
		return customerService.listAll();
	}

	@RequestMapping(value="/customer", method=RequestMethod.POST)
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.saveOrUpdate(customer);
	}

/*	@Value("${message.data}")
	private String message;*/
	
	//hystirix immplementation
	/*@RequestMapping("/customers")
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	public List<Customer> getAllCustomer() {
		System.out.println("inside api method");
		List<Customer> customers = new ArrayList<>();
		customers.addAll(Arrays.asList(new Customer("1001", "Wentworth Miller", "United Kingdom"),
				new Customer("1002", "Sarah Wayne Callies", "Illinois, United States")));
		if (customers.size()==2) 
			throw new RuntimeException();
		return customers;
	}

	public List<Customer> getDataFallBack() {
		System.out.println("inside fallback method");
		List<Customer> customers = new ArrayList<>();
		customers.addAll(Arrays.asList(new Customer("1001", "Wentworth Miller Fallback", "United Kingdom"),
				new Customer("1002", "Sarah Wayne Callies Fallback", "Illinois, United States")));
		return customers;
	}
	
	@RequestMapping("/message")
	public String getProp() {
		return message;
	}*/
	
	
	

}
