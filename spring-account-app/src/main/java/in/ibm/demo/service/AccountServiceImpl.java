package in.ibm.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ibm.demo.bean.Account;
import in.ibm.demo.repo.AccountDAO;

@Service
public class AccountServiceImpl implements AccountService {
	
	private AccountDAO accountDAO;
	
	@Autowired
	public AccountServiceImpl(AccountDAO accountDAO) {
		super();
		this.accountDAO = accountDAO;
	}


	@Override
	public Account createAccount(Account account) {
		return accountDAO.createAccount(account);
	}


	@Override
	public Account updateAccount(Account account) {
		
		return accountDAO.updateAccount(account);
	}


	@Override
	public void deleteAccount(String accountNumber) {
		accountDAO.deleteAccount(accountNumber);
		
	}


	@Override
	public void deleteAll() {
		accountDAO.deleteAll();
		
	}


	@Override
	public List<Account> listAll() {
		// TODO Auto-generated method stub
		return accountDAO.listAll();
	}


	@Override
	public Account findAccountByAccountNumber(String accountNumber) {
		// TODO Auto-generated method stub
		return accountDAO.findAccountByAccountNumber(accountNumber);
	}


	@Override
	public List<Account> findByAccountBalance(double accountBalance) {
		// TODO Auto-generated method stub
		
		return accountDAO.findByAccountBalance(accountBalance);
	}

}
