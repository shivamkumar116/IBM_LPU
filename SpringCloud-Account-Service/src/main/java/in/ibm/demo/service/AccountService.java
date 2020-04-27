package in.ibm.demo.service;

import java.util.List;

import in.ibm.demo.entity.Account;

public interface AccountService {
	
	public List<Account> getAccounts();
	
	public Account findCustomerByID(String id);
	
	public Account findByID(int id);
	

}
