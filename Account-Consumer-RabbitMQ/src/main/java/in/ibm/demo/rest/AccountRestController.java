package in.ibm.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ibm.demo.dao.AccountDAO;
import in.ibm.demo.entity.Account;

import in.ibm.demo.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Account management system", description = "Api for Account Consumer")
public class AccountRestController {

	@Autowired
	private AccountService accountService;

	private static final String QUEUE = "account-queue";

	@RabbitListener(queues = QUEUE)
	public void receiveMessage(Account account) {
		accountService.saveOrUpdate(account);

	}

	@ApiOperation("Get all the accounts")
	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> getAccounts() {
		return ResponseEntity.ok().body(accountService.getAccounts());
	}

	@ApiOperation("Get account by id")
	@GetMapping("/accounts/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable int id) {
		return ResponseEntity.ok().body(accountService.findById(id));
	}

	@ApiOperation("Get account by account number")
	@GetMapping("/accounts/get/{number}")
	public ResponseEntity<Account> getAccoutByNumber(@PathVariable int number) {
		return ResponseEntity.ok().body(accountService.findByNumber(number));
	}

	@PutMapping("/accounts")
	public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
		return ResponseEntity.ok().body(accountService.saveOrUpdate(account));
	}

	@DeleteMapping("/accounts/delete/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable int id) {
		accountService.removeAccount(id);
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

}
