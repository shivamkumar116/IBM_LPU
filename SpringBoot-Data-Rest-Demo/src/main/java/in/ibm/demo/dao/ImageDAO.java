package in.ibm.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.ibm.demo.entity.Image;

@Repository
public interface ImageDAO extends CrudRepository<Image, String> {

}
