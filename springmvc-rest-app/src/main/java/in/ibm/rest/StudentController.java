package in.ibm.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ibm.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentController {

	@GetMapping("/students")
	public List<Student> getStudent() {

		List<Student> students = new ArrayList<>();
		students.add(new Student("shivam", "kumar"));
		students.add(new Student("Renu", "Bala"));
		students.add(new Student("Manish", "kumar"));
		return students;

	}

}
