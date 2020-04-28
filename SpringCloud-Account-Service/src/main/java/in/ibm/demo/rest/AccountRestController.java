package in.ibm.demo.rest;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import in.ibm.demo.entity.Account;
import in.ibm.demo.service.AccountService;

@RestController
public class AccountRestController {
	
	private AccountService accountService;
	
	private Logger logger;
	
	
	@Autowired
	public AccountRestController(AccountService accountService) {
		super();
		logger= Logger.getLogger("accountRestController");
		this.accountService = accountService;
	}
	
	@Value("${server.port}")
	String port;
	
	@GetMapping("/accounts")
	public List<Account> getAccounts(){
		logger.info("***port is :"+port);
		return accountService.getAccounts();
	}
	@GetMapping("/accounts/{customerID}")
	public Account findByCustomerId(@PathVariable String customerID){
		return accountService.findCustomerByID(customerID);
	}
	
	@GetMapping("/accounts/get/{id}")
	public Account findbyID(@PathVariable int id) {
		return accountService.findByID(id);
	}
	
	
	
	

}
