package in.ibm.demo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import in.ibm.demo.dao.AccountDAO;
import in.ibm.demo.data.Account;

@Service
@EnableTransactionManagement
public class AccountServiceImpl implements AccountService {

	private AccountDAO accountDAO;

	// Constructor Injection
	@Autowired
	public AccountServiceImpl(AccountDAO accountDAO) {
		super();
		this.accountDAO = accountDAO;
	}

	@Override
	@Transactional
	public ResponseEntity<Iterable<Account>> getAccounts() {
		Iterable<Account> accounts = accountDAO.findAll();
		return ResponseEntity.ok().body(accounts);
	}

	@Override
	public ResponseEntity<Optional<Account>> findAccountById(int id) {
		Optional<Account> account = accountDAO.findById(id);
		return ResponseEntity.ok().body(account);
	}

}
