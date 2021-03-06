package in.ibm.demo.repo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.ibm.demo.bean.Account;
import in.ibm.demo.bean.AccountMapper;

@Repository
public class AccountDAOImpl implements AccountDAO {

	private JdbcTemplate jdbcTemplate;

	private Logger logger = Logger.getLogger("AccountDAOImpl");
	@PostConstruct
	public void init()
	{
		logger.log(Level.INFO, "initializing bean");
		//System.out.println("initializing bean");
	}
	// Setter injection
	@Autowired
	public AccountDAOImpl(JdbcTemplate jdbcTemplate) {
		super();
		logger.log(Level.INFO, "Connecting to database..........");
		this.jdbcTemplate = jdbcTemplate;
		logger.log(Level.INFO, "database connected..........");
	}



	@Override
	public Account createAccount(Account account) {
		logger.log(Level.INFO, "Executing statement..........");
		String query = "Insert into account values('" + account.getAccountNumber() + "','" + account.getAccountType()
				+ "','" + account.getAccountBalance() + "')";

		jdbcTemplate.execute(query);
		logger.log(Level.INFO, "account added..........");

		return account;
	}

	@Override
	public void deleteAccount(String accountNumber) {
		logger.log(Level.INFO, "Executing delete statement..........");
		String query = "DELETE FROM account where accountNumber = '" + accountNumber + "'";
		int i = jdbcTemplate.update(query);
		if (i == 0)
			System.out.println("No such account");
		else
			logger.log(Level.INFO, "Account successfully deleted..........");

	}

	@Override
	public void deleteAll() {
		logger.log(Level.INFO, "Executing deleteALL statement..........");
		String query = "truncate table account";
		jdbcTemplate.execute(query);
		logger.log(Level.INFO, "Account successfully deleted..........");

	}

	@Override
	public Account updateAccount(Account account) {
		logger.log(Level.INFO, "Executing update statement..........");
		String query = "UPDATE account set accountType = '" + account.getAccountType() + "',accountBalance='"
				+ account.getAccountBalance() + "'" + "where accountNumber='" + account.getAccountNumber() + "'";
		int i = jdbcTemplate.update(query);
		if (i == 0)
			System.out.println("No such Account");
		else
			logger.log(Level.INFO, "Account successfully updated..........");
		return account;
	}

	@Override
	public List<Account> listAll() {
		// List<Account> accounts = jdbcTemplate.query("SELECT * FROM account",new
		// AccountMapper());

		List<Account> accounts = jdbcTemplate.query("SELECT * FROm account", new BeanPropertyRowMapper(Account.class));
		return accounts;
	}

	@Override
	public Account findAccountByAccountNumber(String accountNumber) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("SELECT * from account where accountNumber =?",
				new Object[] { accountNumber }, new AccountMapper());
	}

	@Override
	public List<Account> findByAccountBalance(double accountBalance) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM account where accountBalance >?", new Object[] { accountBalance },
				new AccountMapper());
	}

	
	  @PreDestroy
	  public void destroy() { jdbcTemplate=null; logger.log(Level.INFO,
	  "bean destroyed."); }
	 
}
