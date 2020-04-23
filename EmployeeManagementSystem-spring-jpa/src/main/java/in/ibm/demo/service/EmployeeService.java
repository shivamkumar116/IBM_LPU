package in.ibm.demo.service;

import java.util.List;

import in.ibm.demo.entity.Employee;

public interface EmployeeService {
	public List<Employee> getEmployees();

	public Employee createEmployee(Employee employee);

	public Employee getEmployeeByID(int employeeId);

	public Employee updateEmployee(Employee employee);

	public Employee deleteEmployee(int id);
}
