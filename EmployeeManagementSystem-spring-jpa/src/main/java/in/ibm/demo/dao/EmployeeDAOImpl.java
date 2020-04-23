package in.ibm.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

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

		List<Employee> employees = entityManager.createQuery("from Employee", Employee.class).getResultList();
		return employees;
	}

	@Override
	@Transactional
	public Employee createEmployee(Employee employee) {
		
		entityManager.persist(employee);
		return employee;

	}

	@Override
	@Transactional
	public Employee getEmployeeByID(int employeeId) {

		return entityManager.find(Employee.class, employeeId);
	}

	@Override
	@Transactional
	public Employee updateEmployee(Employee employee) {

		Employee emp = (Employee) entityManager.merge(employee);

		return emp;
	}

	@Override
	@Transactional
	public Employee deleteEmployee(int id) {

		Employee employee = getEmployeeByID(id);

		entityManager.remove(employee);

		return employee;
	}

}
