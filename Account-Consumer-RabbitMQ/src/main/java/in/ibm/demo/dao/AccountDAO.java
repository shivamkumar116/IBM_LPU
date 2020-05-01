package in.ibm.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import in.ibm.demo.entity.Account;
@Repository
@EnableTransactionManagement
public interface AccountDAO  extends CrudRepository<Account, Integer>{

	@Query
	public Account findByNumber(int number);
}
