package in.ibm.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import in.ibm.demo.entity.Todo;

@Repository
@CrossOrigin("*")
public interface TodoDAO extends JpaRepository<Todo, Integer> {

	@Query
	public List<Todo> findByNameContaining(@RequestParam("str") String str);
}