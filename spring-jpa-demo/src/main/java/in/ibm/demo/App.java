package in.ibm.demo;

import java.util.Collection;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;



import in.ibm.demo.entity.Employee;
import in.ibm.demo.service.EmployeeService;

public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeService empService = context.getBean("employeeServiceImpl", EmployeeService.class);
		/* Employee e =new Employee(); */
		Employee e =context.getBean("employee",Employee.class);
		int choice = -1;
		int id;
		String name;
		double salary;

		try (Scanner sc = new Scanner(System.in)) {

			do {
				System.out.println("*****Spring JPA*******");
				System.out.println("1. create Employee");
				System.out.println("2. Remove Employee");
				System.out.println("3. Raise Salary of an employe");
				System.out.println("4. find employee");
				System.out.println("5.  List all the employee");
				System.out.println("Enter your choice : ");
				choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:
					System.out.println("Enter the name : ");
					name = sc.nextLine();
					e.setName(name);
					System.out.println("Enter the salary : ");
					salary = sc.nextDouble();
					e.setSalary(salary);
					e = empService.createEmployee(new Employee(e.getName(), e.getSalary()));
					System.out.println("Done!!!!");
					System.out.println(e);
					break;

				case 2:
					System.out.println("please enter id :");
					id = sc.nextInt();
					sc.nextLine();
					e.setId(id);
					empService.removeEmployee(id);
					break;
				case 3:
					
					System.out.println("please enter the id : ");
					id = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter the raised salary : ");
					salary=  sc.nextDouble();
					e = empService.rasieSalary(id, salary);
					System.out.println(e);
					break;
				case 4:
					System.out.println("Enter the id : ");
					id= sc.nextInt();
					sc.nextLine();
					e =empService.findEmployee(id);
					System.out.println(e);
					break;
				case 5:
					Collection<Employee> emps = empService.findAllEmployee();
					for(Employee e1 :emps) {
						System.out.println(e1);
					}
					break;
				case 0:
					System.out.println("Exiting.....");
					System.exit(0);
					break;
				default:
					break;
				}

			} while (choice != 0);

		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
