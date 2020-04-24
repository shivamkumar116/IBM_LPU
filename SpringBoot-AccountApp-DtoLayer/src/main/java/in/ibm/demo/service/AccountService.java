package in.ibm.demo.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import in.ibm.demo.data.Account;

public interface AccountService {
	
	public ResponseEntity<Iterable<Account>> getAccounts();
	
	public ResponseEntity<Optional<Account>> findAccountById(int id);

}
