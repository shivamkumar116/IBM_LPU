package in.ibm.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ibm.demo.entity.Employee;
import in.ibm.demo.exceptions.EmployeeNotFoundException;
import in.ibm.demo.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api(value = "Employee management system",description = "Operations pertaining to employee in Employee Management System")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@ApiOperation(value = "View a list of available employees", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@ApiOperation(value = "Get an employee by Id")
	@GetMapping("/employees/{employeeID}")
	public Employee getEmployeeByID(@PathVariable int employeeID) {
		Employee employee = employeeService.getEmployeeByID(employeeID);
		if (employee == null)
			throw new EmployeeNotFoundException("No such employee with id -" + employeeID);
		return employee;

	};

	@ApiOperation(value = "create an employee")
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		employee.setEmployeeID(0);
		return employeeService.createEmployee(employee);
	}

	@ApiOperation(value = "update an employee")
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {

		return employeeService.updateEmployee(employee);
	}

	@ApiOperation(value = "Delete an employee")
	@DeleteMapping("/employees/{employeeID}")
	public Employee deleteEmployeeByID(@PathVariable int employeeID) {
		Employee employee = employeeService.getEmployeeByID(employeeID);
		if (employee == null)
			throw new EmployeeNotFoundException("No such employee with id " + employeeID);

		return employeeService.deleteEmployee(employeeID);

	}
}
