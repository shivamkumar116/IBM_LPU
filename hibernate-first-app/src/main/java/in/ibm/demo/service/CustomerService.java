package in.ibm.demo.service;

import java.util.List;

import in.ibm.demo.model.Customer;

public interface CustomerService {
	public Customer createCustomer(Customer customer);

	public List<Customer> listAllCustomer();
}
