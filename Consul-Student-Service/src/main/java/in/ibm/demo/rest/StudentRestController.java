package in.ibm.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ibm.demo.model.Student;
import in.ibm.demo.service.StudentService;

@RestController
public class StudentRestController {

	@Autowired
	private StudentService studentService;;

	@GetMapping("/students/{schoolName}")
	public Iterable<Student> findStudentBySchoolName(@PathVariable String schoolName) {
		Iterable<Student>students = studentService.findBySchoolName(schoolName);
		if(students==null)
			return null;
		else
			return students;
	}

}
