package in.ibm.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ibm.demo.entity.Account;
import in.ibm.demo.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountRestController {
	
	private AccountService accountService;
	
	@Autowired
	public AccountRestController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	
	@GetMapping("/accounts")
	public List<Account> getAccounts(){
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
