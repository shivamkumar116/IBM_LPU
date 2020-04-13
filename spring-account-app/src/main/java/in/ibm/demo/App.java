package in.ibm.demo;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ibm.demo.bean.Account;
import in.ibm.demo.service.AccountServiceImpl;
import in.ibm.demo.bean.AccountType;

public class App {
	public static void main(String[] args) {
		int choice = 0;
		String accountNumber =null;
		Scanner sc = new Scanner(System.in);

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountServiceImpl service = context.getBean("accountServiceImpl", AccountServiceImpl.class);
		Account account = context.getBean("account", Account.class);

		do {
			System.out.println("*****Account App**********");
			System.out.println("1. Create Account");
			System.out.println("2. delete by id");
			System.out.println("3. Delete All");
			System.out.println("4. Update by id");
			System.out.println("5. List All");
			System.out.println("6. find account by Number :");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {

			case 1:

				account.setAccountNumber(UUID.randomUUID().toString());
				account.setAccountType("Savings");
				account.setAccountBalance(2000.00);
				account.setAccountType("LOAN");
				account = service.createAccount(account);
				System.out.println(account);
				break;
			case 2:
				System.out.println("Enter the id : ");
				String id = sc.nextLine();
				service.deleteAccount(id);
				break;
			case 3:
				service.deleteAll();
				break;
			case 4:
				System.out.println("Enter account number ");
			 accountNumber = sc.nextLine();
				account.setAccountNumber(accountNumber);
				System.out.println("Enter account type ");
				String accountType = sc.nextLine();
				account.setAccountType(accountType);
				System.out.println("Enter account balance ");
				double accountBalance = sc.nextDouble();
				account.setAccountBalance(accountBalance);
				service.updateAccount(account);
				break;

			case 5:

				List<Account> accounts = service.listAll();
				Iterator<Account> iter = accounts.iterator();
				while (iter.hasNext()) {
					System.out.println(iter.next());
				}

				break;
			case 6:
				System.out.println("Enter account number : ");
				accountNumber = sc.nextLine();
				account =service.findAccountByAccountNumber(accountNumber);
				System.out.println(account);
			break;
			default:
				System.out.println("BYe!!!!!!");
				System.exit(0);

			}

		} while (choice != 0);

	}
}
