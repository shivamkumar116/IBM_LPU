package in.ibm.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import in.ibm.demo.dao.EmployeeDAO;
import in.ibm.demo.entity.Employee;

@Service
@EnableTransactionManagement
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;

	@Override
	@Transactional
	public List<Employee> getEmployees() {

		return employeeDao.getEmployees();
	}

	@Override
	@Transactional
	public Employee createEmployee(Employee employee) {

		return employeeDao.createEmployee(employee);
	}

	@Override
	@Transactional
	public Employee getEmployeeByID(int employeeId) {
		
		return employeeDao.getEmployeeByID(employeeId);
	}

	@Override
	@Transactional
	public Employee updateEmployee(Employee employee) {
		
		return employeeDao.updateEmployee(employee);
	}

	@Override
	@Transactional
	public Employee deleteEmployee(int id) {
		
		return employeeDao.deleteEmployee(id);
	}

}
