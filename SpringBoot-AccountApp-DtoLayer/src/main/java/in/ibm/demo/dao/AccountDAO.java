package in.ibm.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.ibm.demo.data.Account;

@Repository(value = "accountDAO")
//Interface for providing the crud operation using the crudRepository
public interface AccountDAO extends CrudRepository<Account, Integer> {

	@Query
	public Iterable<Account> findByAccountType(String accountType);

	public Iterable<Account> findByAccountTypeAndBalance(String accountType, double balance);

	public void deleteByAccountType(String accountType);
	
}
