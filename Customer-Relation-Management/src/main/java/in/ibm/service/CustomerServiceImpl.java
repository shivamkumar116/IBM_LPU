package in.ibm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ibm.dao.CustomerDAO;
import in.ibm.entity.Customer;
import in.ibm.exception.CustomerNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDao;

	@Override
	@Transactional
	public List<Customer> getCustomers() {

		return customerDao.getCustomers();
	}

	@Override
	public Customer getCustomerByID(int id) {

		return customerDao.getCustomerByID(id);
	}

	@Override
	public Customer createCustomer(Customer customer) {
		return customerDao.createCustomer(customer);
	}

}
