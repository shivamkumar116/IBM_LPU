package in.ibm.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ibm.demo.entity.Account;
import in.ibm.demo.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Account management system", description = "Api for Account Producer")
public class AccountRestController {

	@Autowired
	private AccountService accountService;

	@ApiOperation("post a Account")
	@PostMapping("/postaccounts")
	public ResponseEntity<String> postAccount(@RequestBody Account account) {
		accountService.sendMessage(account);
		return new ResponseEntity<String>("Account pushed to RabbitMQ", HttpStatus.CREATED);
	}
	
	@GetMapping("/accountDemo")
	public String hello() {
		return "logged in";
	}
}

