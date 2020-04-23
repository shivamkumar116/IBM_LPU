package in.ibm.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ibm.demo.dao.EmployeeDAO;
import in.ibm.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;

	@Override
	public List<Employee> getEmployees() {

		return employeeDao.getEmployees();
	}

	@Override
	public Employee createEmployee(Employee employee) {

		return employeeDao.createEmployee(employee);
	}

	@Override
	public Employee getEmployeeByID(int employeeId) {
		
		return employeeDao.getEmployeeByID(employeeId);
	}

	@Override
	
	public Employee updateEmployee(Employee employee) {
		
		return employeeDao.updateEmployee(employee);
	}

	@Override
	public Employee deleteEmployee(int id) {
		
		return employeeDao.deleteEmployee(id);
	}

}
