package in.ibm.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import in.ibm.demo.entity.ProductCategory;

@CrossOrigin("http://localhost:4200")
@Repository
//@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
public interface CategoryDAO extends CrudRepository<ProductCategory, Integer> {

}
