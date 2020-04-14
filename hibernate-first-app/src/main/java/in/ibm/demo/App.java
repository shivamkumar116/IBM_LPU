package in.ibm.demo;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import in.ibm.demo.model.Customer;
import in.ibm.demo.service.CustomerService;
import in.ibm.demo.service.CustomerServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
	private static CustomerService customerService = null;
	private static Scanner sc = new Scanner(System.in);

	static 
	{
		customerService = new CustomerServiceImpl();
	}

	public static void main(String[] args) {
		
		int choice = -1;
		int isCustomerActive=0;
		String fname;
		String email;
		boolean isactive;
		
		do {
			System.out.println("*CMS*");
			System.out.println("1. Add Customer");
			System.out.println("2. List all customers");
			System.out.println("3. Find customer by id :");
			System.out.println("Enter your choice : ");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				Customer customer=new Customer();
				System.out.println("Enter customer name :");
				fname= sc.nextLine();
				System.out.println("Enter customer email :");
				email =sc.nextLine();
				System.out.println("is customer Active?\n1.Yes\n2.NO");
				isCustomerActive=sc.nextInt();
				sc.nextLine();
				if(isCustomerActive==1)
					isactive=true;
				else
					isactive=false;
				customer.setCustomerID(UUID.randomUUID().toString());
				customer.setCustomerName(fname);
				customer.setCustomerEmail(email);
				customer.setActive(isactive);
				customer= customerService.createCustomer(customer);
				System.out.println(customer);
				break;
				
			case 2:
				List<Customer> list=customerService.listAllCustomer();
				for(Customer cus:list)
					System.out.println(cus);
				break;
				
			case 3:
				System.out.println("Enter id :");
				customer = customerService.findCustomerByID(sc.next());
				if(customer==null)
					System.out.println("No record found!!");
				else
					System.out.println(customer);
				
				break;

			case 0:
				System.out.println("Bye!--");
				System.exit(0);
				break;
			default:
				break;
			}

		} while (choice != 0);

	}
}
