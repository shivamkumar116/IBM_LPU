package in.ibm.demo.dao;

import in.ibm.demo.entity.Employee;

public interface EmployeeDAO {

	public Employee createEmployee(Employee employee);

	public void updateEmployee(Employee employee);

}
