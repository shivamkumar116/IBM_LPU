package in.ibm.demo.service;

import java.util.List;

import in.ibm.demo.model.Customer;
import in.ibm.demo.repo.CustomerDAO;
import in.ibm.demo.repo.CustomerDAOImpl;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDAO dao;
	{
		
		dao= new CustomerDAOImpl();
	}

	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return dao.createCustomer(customer);
	}

	@Override
	public List<Customer> listAllCustomer() {
		// TODO Auto-generated method stub
		return dao.listAllCustomer();
	}

	@Override
	public Customer findCustomerByID(String id) {
		// TODO Auto-generated method stub
		return dao.findCustomerByID(id);
	}

}
