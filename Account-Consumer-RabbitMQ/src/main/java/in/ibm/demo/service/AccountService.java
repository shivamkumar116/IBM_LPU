package in.ibm.demo.service;

import java.util.List;



import in.ibm.demo.entity.Account;


public interface AccountService {
	
	public List<Account> getAccounts();
	
	public Account saveOrUpdate(Account account);

	public Account findById(int id);
	
	public Account findByNumber(int number);
	
	public void removeAccount(int id);
}
