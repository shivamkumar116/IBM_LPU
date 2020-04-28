package in.ibm.demo.dao;

import org.springframework.data.repository.CrudRepository;

import in.ibm.demo.entity.Image;

public interface ImageDAO extends CrudRepository<Image, Integer> {

}
