package in.ibm.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ibm.demo.dao.AccountDAO;
import in.ibm.demo.entity.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO accountDao;

	@Override
	public List<Account> getAccounts() {
		
		return (List<Account>) accountDao.findAll();
	}

	@Override
	public Account saveOrUpdate(Account account) {

		return accountDao.save(account);
		
	}

	@Override
	public Account findById(int id) {
		
		return accountDao.findById(id).get();
	}

	@Override
	public Account findByNumber(int number) {
		
		return accountDao.findByNumber(number);
	}

	@Override
	public void removeAccount(int id) {
		accountDao.deleteById(id);

	}

	
}
