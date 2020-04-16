package in.ibm.demo.dao;

import java.util.Collection;

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
	public void init() {
		factory = sessionFactory.unwrap(SessionFactory.class);
		entityManager = factory.createEntityManager();
	}

	@Override
	public Employee createEmployee(Employee employee) {

		entityManager.getTransaction().begin();

		entityManager.persist(employee);
		entityManager.getTransaction().commit();

		return employee;
	}

	@Override
	public Employee findEmployee(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		if (employee == null) {
			System.out.println("no such employee with id :" + id);
			return null;
		}

		else
			return employee;

	}

	@Override
	
	public void removeEmployee(int id) {
		entityManager.clear();
		Employee employee = findEmployee(id);
		if (employee == null)
			System.out.println("operation aborted..");
		else {
			entityManager.getTransaction().begin();
			entityManager.remove(employee);
			entityManager.getTransaction().commit();
			System.out.println("Employee Successfully deleted " + employee);
		}

	}

	@Override
	public Employee rasieSalary(int id, double salary) {
		Employee employee = findEmployee(id);
		if (employee == null) {
			System.out.println("no such employee with id " + id);
			return null;
		} else {
			employee.setSalary(employee.getSalary() + salary);
			entityManager.getTransaction().begin();
			entityManager.merge(employee);
			entityManager.getTransaction().commit();
			return employee;

		}

	}

	@Override
	public Collection<Employee> findAllEmployee() {
		
		return entityManager.createQuery("SELECT e from Employee e", Employee.class).getResultList();
	}

}
