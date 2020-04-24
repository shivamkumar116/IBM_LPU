package in.ibm.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import in.ibm.demo.data.Account;
import in.ibm.demo.dto.AccountDto;

public interface AccountService {

	public ResponseEntity<List<AccountDto>> getAccounts();

	public ResponseEntity<AccountDto> findAccountById(int id);

	public ResponseEntity<AccountDto> save(AccountDto accountDto);

	public ResponseEntity<AccountDto> deleteAccount(int id);

	public ResponseEntity<Account> updateAccont(Account account);

	public ResponseEntity<Iterable<Account>> findByAccountType(String accountType);
	
	public ResponseEntity<Iterable<Account>> findByAccountTypeAndBalance(String accountType,double balance);
	
	public void removeByAccountType(String accountType);

}
