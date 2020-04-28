package in.ibm.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ibm.demo.dao.CustomerDAO;
import in.ibm.demo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDao;

	@Autowired
	public CustomerServiceImpl(CustomerDAO customerDao) {
		super();
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> getCustomers() {

		return (List<Customer>) customerDao.findAll();
	}

}
