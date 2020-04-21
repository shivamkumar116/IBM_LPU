package in.ibm.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	// @RequestMapping("/")
	// @GetMapping
	@RequestMapping(method = RequestMethod.GET)
	public String hello() {
		return "Hello world from spring boot";
	}
}
