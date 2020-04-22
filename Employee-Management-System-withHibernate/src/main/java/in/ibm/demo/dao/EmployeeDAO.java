package in.ibm.demo.dao;

import java.util.List;

import in.ibm.demo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getEmployees();

	public Employee createEmployee(Employee employee);

	public Employee getEmployeeByID(int employeeId);
	
	public Employee updateEmployee(Employee employee);
	
	public Employee deleteEmployee(int id);

}
