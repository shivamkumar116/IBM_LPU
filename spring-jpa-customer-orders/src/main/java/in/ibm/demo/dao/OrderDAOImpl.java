package in.ibm.demo.dao;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.ibm.demo.Entity.Orders;

@Repository
public class OrderDAOImpl implements OrderDAO {
	private SessionFactory sessionfactory;

	private EntityManagerFactory factory;

	private EntityManager entityManager;

	@Autowired
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@PostConstruct
	public void init() {
		factory = sessionfactory.unwrap(SessionFactory.class);
		entityManager = sessionfactory.createEntityManager();

	}

	public Orders createOrder(Orders order) {
		entityManager.getTransaction().begin();
		entityManager.persist(order);
		entityManager.getTransaction().commit();
		return order;
	}

}
