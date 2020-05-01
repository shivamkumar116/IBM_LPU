package in.ibm.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ibm.demo.client.EmployeeClient;

@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	private EmployeeClient employeeClient;
	
	@RequestMapping("/sayhello")
	public ResponseEntity<String> sayHello(@RequestParam String name){
		return  ResponseEntity.ok().body(employeeClient.callHi(name));
	}
	
}
