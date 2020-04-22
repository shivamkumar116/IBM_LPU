package in.ibm.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.ibm.demo.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> getEmployees() {
		Session session = entityManager.unwrap(Session.class);
		List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();
		return employees;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.save(employee);
		return employee;

	}

	@Override
	public Employee getEmployeeByID(int employeeId) {

		Session session = entityManager.unwrap(Session.class);
		return session.get(Employee.class, employeeId);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.getTransaction().begin();
		Employee emp = (Employee) session.merge(employee);
		session.getTransaction().commit();
		return emp;
	}

	@Override
	public Employee deleteEmployee(int id) {
		Session session = entityManager.unwrap(Session.class);
		Employee employee = getEmployeeByID(id);
		session.getTransaction().begin();
		session.remove(employee);
		session.getTransaction().commit();

		return employee;
	}

}
