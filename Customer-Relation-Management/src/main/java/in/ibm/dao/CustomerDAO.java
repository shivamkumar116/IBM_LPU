package in.ibm.dao;

import java.util.List;

import in.ibm.entity.Customer;
import in.ibm.exception.CustomerNotFoundException;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	
	public Customer getCustomerByID(int id);
	
	public Customer createCustomer(Customer customer);
	
}
