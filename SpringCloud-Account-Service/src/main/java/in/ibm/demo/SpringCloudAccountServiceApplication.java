package in.ibm.demo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import in.ibm.demo.dao.AccountDAO;
import in.ibm.demo.entity.Account;
import in.ibm.demo.service.AccountService;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudAccountServiceApplication implements CommandLineRunner {

	private AccountDAO accountDao;

	@Autowired
	public void setAccountDao(AccountDAO accountDao) {
		this.accountDao = accountDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudAccountServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		accountDao.save(new Account(UUID.randomUUID().toString(), 1));
		accountDao.save(new Account(UUID.randomUUID().toString(), 2));
		accountDao.save(new Account(UUID.randomUUID().toString(), 3));
	}

}
