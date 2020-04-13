package in.ibm.demo.service;

import java.util.List;

import in.ibm.demo.bean.Account;
import in.ibm.demo.repo.NoAccountFoundException;

public interface AccountService {
	public Account createAccount(Account account);

	public Account updateAccount(Account account) throws NoAccountFoundException;

	public void deleteAccount(String accountNumber) throws NoAccountFoundException;

	public void deleteAll();

	public List<Account> listAll();

	public Account findAccountByAccountNumber(String accountNumber);

	public List<Account> findByAccountBalance(double accountBalance);
}
