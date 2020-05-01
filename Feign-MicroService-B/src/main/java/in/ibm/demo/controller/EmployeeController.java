package in.ibm.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ibm.demo.dao.EmployeeDAO;
import in.ibm.demo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeDAO employeeDao;

	@GetMapping("/employee/hi")
	public String hi(@RequestParam String name) {
		return "Hello ! " + name;
	}

	@GetMapping("/employees/{departmentName}")
	public ResponseEntity<Iterable<Employee>> getEmployeesByDepartmentName(@RequestParam String departmentName) {
		return ResponseEntity.ok().body(employeeDao.findByDepartmentname(departmentName));
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> save(@RequestBody  Employee employee) {
		return ResponseEntity.ok().body(employeeDao.save(employee));
	}

}
