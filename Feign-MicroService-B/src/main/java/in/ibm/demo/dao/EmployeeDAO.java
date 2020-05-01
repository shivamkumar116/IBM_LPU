package in.ibm.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import in.ibm.demo.entity.Employee;

public interface EmployeeDAO  extends CrudRepository<Employee, Integer>{

	@Query
	public Iterable<Employee> findByDepartmentname(String departmentName);
}
