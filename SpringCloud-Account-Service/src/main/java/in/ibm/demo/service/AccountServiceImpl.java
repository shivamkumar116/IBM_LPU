package in.ibm.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ibm.demo.dao.AccountDAO;
import in.ibm.demo.entity.Account;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountDAO accountDao;

	@Autowired
	public AccountServiceImpl(AccountDAO accountDao) {
		super();
		this.accountDao = accountDao;
	}

	@Override
	public List<Account> getAccounts() {
		return (List<Account>) accountDao.findAll();
	}

	@Override
	public Account findCustomerByID(String id) {
		return accountDao.findByCustomerID(id);
	}

	@Override
	public Account findByID(int id) {
		return accountDao.findById(id).get();
	}

}
