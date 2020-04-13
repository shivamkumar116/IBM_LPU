package in.ibm.demo.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AccountMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = new Account();
		account.setAccountNumber(rs.getString(1));
		account.setAccountType(rs.getString(2));
		account.setAccountBalance(rs.getDouble(3));
		
		return account;
	}

}
