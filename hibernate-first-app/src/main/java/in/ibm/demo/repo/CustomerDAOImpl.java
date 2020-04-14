package in.ibm.demo.repo;

import java.nio.channels.SeekableByteChannel;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import in.ibm.demo.factory.MyHibernateFactory;
import in.ibm.demo.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	private SessionFactory sessionFactory = null;
	private MyHibernateFactory factory = null;
	private Session session = null;

	{
		factory = MyHibernateFactory.getMyHibernateFactory();
		sessionFactory = factory.getSessionFactory();
		session = sessionFactory.openSession();

	}

	@Override
	public Customer createCustomer(Customer customer) {
		session.getTransaction().begin();
		session.save(customer);
		session.getTransaction().commit();
		return customer;
	}

	@Override
	public List<Customer> listAllCustomer() {

		List<Customer> list = session.createQuery("from Customer", Customer.class).list();

		return list;
	}

	@Override
	public Customer findCustomerByID(String id) {
		return session.get(Customer.class, id);
	}

}
