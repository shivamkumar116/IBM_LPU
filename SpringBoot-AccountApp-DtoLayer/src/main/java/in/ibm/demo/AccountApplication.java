package in.ibm.demo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.ibm.demo.dao.AccountDAO;
import in.ibm.demo.data.Account;
import in.ibm.demo.service.AccountService;

@SpringBootApplication
public class AccountApplication implements CommandLineRunner {

	private AccountService accountService;
	private AccountDAO accountDAO;

	@Autowired
	public AccountApplication(AccountService accountService, AccountDAO accountDAO) {
		super();
		this.accountService = accountService;
		this.accountDAO = accountDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		accountDAO.save(new Account(UUID.randomUUID().toString(), "Saving", 10000));
		accountDAO.save(new Account(UUID.randomUUID().toString(), "Current", 50000));
		System.out.println(accountService.getAccounts().toString());

	}

}
