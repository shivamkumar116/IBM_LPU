package in.ibm.demo.dao;

import org.springframework.data.repository.CrudRepository;

import in.ibm.demo.entity.Customer;

public interface CustomerDAO extends CrudRepository<Customer, Integer> {

}
