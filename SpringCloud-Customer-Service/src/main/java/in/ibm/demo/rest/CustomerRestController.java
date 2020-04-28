package in.ibm.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ibm.demo.entity.Customer;
import in.ibm.demo.service.CustomerService;

@RestController
public class CustomerRestController {
	
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerRestController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@RequestMapping("/customers")
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	

}
