package in.ibm.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ibm.demo.dao.EmployeeDAO;
import in.ibm.demo.model.Employee;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDAO employeeDao;

	@GetMapping("/employees")
	public Iterable<Employee> getEmployees() {

		return employeeDao.findAll();
	}

	@GetMapping("/employees/{empid}")
	public Employee getEmployee(@PathVariable int empid) {
		if (employeeDao.findById(empid).isPresent()) {
			return employeeDao.findById(empid).get();
		} else
			return null;
	}

	/*
	 * @PostMapping("/saveEmployee") public Employee saveOrUpdate(@RequestBody
	 * Employee employee) { return employeeDao.save(employee); }
	 */
}
