package in.ibm.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import in.ibm.demo.entity.Account;

public interface AccountDAO  extends CrudRepository<Account, Integer>{

	@Query
	public Account findByCustomerID(String id);
}
