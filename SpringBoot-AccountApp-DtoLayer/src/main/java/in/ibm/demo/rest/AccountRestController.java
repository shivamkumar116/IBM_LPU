package in.ibm.demo.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ibm.demo.data.Account;
import in.ibm.demo.service.AccountService;

@RestController
@RequestMapping("/api/v1")
public class AccountRestController {

	private AccountService accountService;

	@Autowired
	public AccountRestController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	@GetMapping("/accounts")
	public ResponseEntity<Iterable<Account>> getAccounts() {
		return accountService.getAccounts();
	}

	@GetMapping("/accounts/{accountID}")
	public ResponseEntity<Optional<Account>> findAccountById(@PathVariable int accountID) {
		return accountService.findAccountById(accountID);
	}

}
