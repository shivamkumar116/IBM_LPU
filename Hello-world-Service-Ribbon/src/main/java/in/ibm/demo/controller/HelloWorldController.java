package in.ibm.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ibm.demo.Service.HelloWorldService;

@RestController
public class HelloWorldController {
	
	@Autowired
	private HelloWorldService helloWorldService;
	
	
	@RequestMapping("/hi")
	public String hi() {
		return helloWorldService.sayHelloService();
	}

}
