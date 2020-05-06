package in.ibm.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import in.ibm.demo.entity.Product;

@CrossOrigin("http://localhost:4200")
@Repository
public interface ProductDAO  extends CrudRepository<Product, Integer>{

}
