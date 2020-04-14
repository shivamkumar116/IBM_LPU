package in.ibm.demo.repo;

import java.util.List;

import in.ibm.demo.model.Customer;

public interface CustomerDAO {

	public Customer createCustomer(Customer customer);

	public List<Customer> listAllCustomer();
	
	public Customer findCustomerByID(String id);

}
