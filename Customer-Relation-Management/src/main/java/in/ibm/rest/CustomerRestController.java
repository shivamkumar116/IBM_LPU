package in.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ibm.entity.Customer;
import in.ibm.exception.CustomerNotFoundException;
import in.ibm.exception.CustomerResponseEntity;
import in.ibm.service.CustomerService;
import javassist.expr.NewArray;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/customers")
	public List<Customer> listAllCustomers() {
		return customerService.getCustomers();

	}

	@RequestMapping("/customers/{customerID}")
	public Customer getCustomerByID(@PathVariable int customerID) {
		Customer customer = customerService.getCustomerByID(customerID);
		if (customer == null)
			throw new CustomerNotFoundException("no such Customer with id : " + customerID);
		return customer;
	}

	// save a customer

	@PostMapping("/customers")
	public Customer create(@RequestBody Customer customer) {
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		customer.setId(0);
		customerService.createCustomer(customer);
		return customer;
	}

	// Update a customer
	@PutMapping("/customers")
	public Customer update(@RequestBody Customer customer) {
		customerService.createCustomer(customer);
		return customer;
	}

	@DeleteMapping("/customers/{customerID}")
	public Customer deleteCustomer(@PathVariable int customerID) {
		Customer customer = customerService.getCustomerByID(customerID);
		if (customer == null)
			throw new CustomerNotFoundException("No such customer");

		customerService.deleteCustomer(customerID);
		return customer;

	}

}
