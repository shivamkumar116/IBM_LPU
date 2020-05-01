package in.ibm.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ibm.demo.model.Employee;

@FeignClient(value = "service-B", fallback = EmployeeFallback.class)
public interface EmployeeClient {

	@RequestMapping("/api/employee/hi")
	public String callHi(@RequestParam String name);

	@RequestMapping("/api/employees/{departmentName}")
	public ResponseEntity<Iterable<Employee>> getEmployees(@RequestParam String departmentName);

	@PostMapping("/api/employees")
	public ResponseEntity<Employee> save(@RequestBody  Employee employee);

}
