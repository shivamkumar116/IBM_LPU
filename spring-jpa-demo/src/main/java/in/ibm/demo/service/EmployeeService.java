package in.ibm.demo.service;

import in.ibm.demo.entity.Employee;

public interface EmployeeService {

	public Employee createEmployee(Employee employee);

	public void updateEmployee(Employee employee);
}
