package in.ibm.demo.service;

import java.util.Collection;

import in.ibm.demo.entity.Employee;

public interface EmployeeService {

	public Employee createEmployee(Employee employee);


	public Employee findEmployee(int id);
	
	public void removeEmployee(int id);
	
	public Employee rasieSalary(int id,double Salary);
	
	public Collection<Employee> findAllEmployee();
}
