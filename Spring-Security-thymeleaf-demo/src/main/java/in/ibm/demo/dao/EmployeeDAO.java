package in.ibm.demo.dao;

import org.springframework.data.repository.CrudRepository;

import in.ibm.demo.model.Employee;

public interface EmployeeDAO extends CrudRepository<Employee ,Integer> {

}
