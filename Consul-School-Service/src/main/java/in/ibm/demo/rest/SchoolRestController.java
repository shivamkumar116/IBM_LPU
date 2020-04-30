package in.ibm.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ibm.demo.service.SchoolService;

@RestController
public class SchoolRestController {
	
	
	@Autowired
	private SchoolService schoolService;
	
	@GetMapping("/getStudentBySchoolName/{schoolName}")
	public Iterable<Object> getStudentBySchoolName(@PathVariable String schoolName){
		return schoolService.getStudents(schoolName);
	}

}
