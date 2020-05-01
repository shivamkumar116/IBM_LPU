package in.ibm.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ibm.demo.client.EmployeeClient;
import in.ibm.demo.model.Employee;

@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	private EmployeeClient employeeClient;

	@RequestMapping("/sayhello")
	public ResponseEntity<String> sayHello(@RequestParam String name) {
		return ResponseEntity.ok().body(employeeClient.callHi(name));
	}

	@GetMapping("/employees")
	public ResponseEntity<Iterable<Employee>> findEmployees(@RequestParam String departmentName) {
		return employeeClient.getEmployees(departmentName);
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> save(@RequestBody Employee employee){
		return employeeClient.save(employee);
	}
	
}
