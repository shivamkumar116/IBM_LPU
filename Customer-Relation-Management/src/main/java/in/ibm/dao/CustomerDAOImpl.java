package in.ibm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.ibm.entity.Customer;
import in.ibm.exception.CustomerNotFoundException;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.openSession();
		Query<Customer> theQuery = session.createQuery("FROM Customer", Customer.class);
		List<Customer> customers = theQuery.getResultList();

		return customers;

	}

	@Override
	public Customer getCustomerByID(int id) {
		Session session = sessionFactory.openSession();
		Customer objCustomer = session.get(Customer.class, id);
		return objCustomer;

	}

	@Override
	public Customer createCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(customer);
		return customer;
	}

}
