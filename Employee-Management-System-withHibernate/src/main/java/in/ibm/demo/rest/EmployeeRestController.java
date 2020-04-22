package in.ibm.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ibm.demo.entity.Employee;
import in.ibm.demo.exceptions.EmployeeNotFoundException;
import in.ibm.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@RequestMapping("/employees/{employeeID}")
	public Employee getEmployeeByID(@PathVariable int employeeID) {
		Employee employee = employeeService.getEmployeeByID(employeeID);
		if (employee == null)
			throw new EmployeeNotFoundException("No such employee with id -" + employeeID);
		return employee;

	};

	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		employee.setEmployeeID(0);
		return employeeService.createEmployee(employee);
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {

		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping("/employees/{employeeID}")
	public Employee deleteEmployeeByID(@PathVariable int employeeID) {
		Employee employee = employeeService.getEmployeeByID(employeeID);
		if (employee == null)
			throw new EmployeeNotFoundException("No such employee with id " + employeeID);

		return employeeService.deleteEmployee(employeeID);

	}
}
