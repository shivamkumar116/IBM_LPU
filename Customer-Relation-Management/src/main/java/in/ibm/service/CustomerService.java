package in.ibm.service;

import java.util.List;

import in.ibm.entity.Customer;
import in.ibm.exception.CustomerNotFoundException;

public interface CustomerService {

	public List<Customer> getCustomers();

	public Customer getCustomerByID(int id);

	public void createCustomer(Customer customer);

	public void deleteCustomer(int id);

}
