package in.ibm.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@GetMapping("/employee/hi")
	public String hi(@RequestParam String name) {
		return "Hello ! "+ name;
	}
}
