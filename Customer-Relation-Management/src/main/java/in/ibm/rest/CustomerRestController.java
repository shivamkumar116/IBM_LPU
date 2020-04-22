package in.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public Customer getCustomerByID(@PathVariable int customerID) throws CustomerNotFoundException {
		Customer customer = customerService.getCustomerByID(customerID);
		if (customer == null)
			throw new CustomerNotFoundException("no such Customer with id : " + customerID);
		return customer;
	}

	@ExceptionHandler
	public ResponseEntity<CustomerResponseEntity> handleException(CustomerNotFoundException cnfe) {
		return new ResponseEntity<CustomerResponseEntity>(
				new CustomerResponseEntity(HttpStatus.NOT_FOUND.value(), cnfe.getMessage(), System.currentTimeMillis()),
				HttpStatus.NOT_FOUND);

	}

	// save a customer
	
	@PostMapping("/customers")
	public Customer create(@RequestBody Customer customer) {
		Customer savedCustomer = customerService.createCustomer(customer);
		return savedCustomer;
	}

}
