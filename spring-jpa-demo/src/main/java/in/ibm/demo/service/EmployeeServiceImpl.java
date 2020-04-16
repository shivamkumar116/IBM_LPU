package in.ibm.demo.service;

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
		return employeeDAO.createEmployee(employee) ;
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

}
