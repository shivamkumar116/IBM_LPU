package in.ibm.demo.repo;

import java.util.List;

import in.ibm.demo.bean.Account;

public interface AccountDAO {

	public Account createAccount(Account account);

	public Account updateAccount(Account account) throws NoAccountFoundException;

	public  void deleteAccount(String accountNumber) throws NoAccountFoundException;

	public void deleteAll();

	public List<Account> listAll();

	public Account findAccountByAccountNumber(String accountNumber);

	public List<Account> findByAccountBalance(double accountBalance);

}
