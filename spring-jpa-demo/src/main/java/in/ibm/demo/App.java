package in.ibm.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ibm.demo.entity.Employee;
import in.ibm.demo.service.EmployeeService;

public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeService empService = context.getBean("employeeServiceImpl", EmployeeService.class);
		Employee e = empService.createEmployee(new Employee("JOHN", 22000.00));
		System.out.println(e);
	}
}
