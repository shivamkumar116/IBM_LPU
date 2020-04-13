package in.ibm.demo.repo;

import java.util.List;

import in.ibm.demo.bean.Account;

public interface AccountDAO {

	public Account createAccount(Account account);
	
	public Account updateAccount(Account account);
	
	public void deleteAccount(String accountNumber);
	
	public void deleteAll();
	
	public List<Account> listAll();
	
	public Account findAccountByAccountNumber(String accountNumber);
	
}
