package in.ibm.demo.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ibm.demo.dao.EmployeeDAO;
import in.ibm.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;

	@Autowired
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.createEmployee(employee);
	}

	@Override
	public Employee findEmployee(int id) {

		return employeeDAO.findEmployee(id);
	}

	@Override
	public void removeEmployee(int id) {
		employeeDAO.removeEmployee(id);

	}

	@Override
	public Employee rasieSalary(int id, double Salary) {

		return employeeDAO.rasieSalary(id, Salary);
	}

	@Override
	public Collection<Employee> findAllEmployee() {

		return employeeDAO.findAllEmployee();
	}

}
