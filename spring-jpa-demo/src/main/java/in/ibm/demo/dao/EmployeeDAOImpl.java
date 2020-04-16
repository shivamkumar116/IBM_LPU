package in.ibm.demo.dao;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PostLoad;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.ibm.demo.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	private SessionFactory sessionFactory;
	private EntityManagerFactory factory;

	private EntityManager entityManager;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@PostConstruct
	public void init()
	{
		factory=sessionFactory.unwrap(SessionFactory.class);
		entityManager=factory.createEntityManager();
	}
	
	
	@Override
	public Employee createEmployee(Employee employee) {
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

}
