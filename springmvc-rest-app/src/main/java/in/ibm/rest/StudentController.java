package in.ibm.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ibm.entity.Student;
import in.ibm.exception.StudentNotFoundException;
import in.ibm.exception.StudentResponseEntity;

@RestController
@RequestMapping("/api")
public class StudentController {

	List<Student> students = null;

	@PostConstruct
	public void init() {
		students = new ArrayList<>();

		students.add(new Student(0, "shivam", "kumar"));
		students.add(new Student(1, "Renu", "Bala"));
		students.add(new Student(2, "Manish", "kumar"));
	}

	@GetMapping("/students")
	public List<Student> getStudent() {
		return students;

	}
	
	
	//create student
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student) {
		students.add(student);
		return student;
		
	}
	
	
	/*
	 * @GetMapping("/students/{studentID}") public Student
	 * getStudentByID(@PathVariable int studentID) {
	 * 
	 * return students.get(studentID);
	 * 
	 * }
	 */

	// With Reponse Entity
	@GetMapping("/students/{studentID}")
	public Student getStudentByID(@PathVariable int studentID) throws StudentNotFoundException {

		if (studentID >= students.size() || studentID < 0)
			throw new StudentNotFoundException("No such student - " + studentID);

		return students.get(studentID);

	}

	@ExceptionHandler
	public ResponseEntity<StudentResponseEntity> handleException(StudentNotFoundException snfe) {

		/*
		 * StringBuffer br=new StringBuffer(); br.append(HttpStatus.NOT_FOUND);
		 * br.append(snfe.getMessage()); br.append(System.currentTimeMillis()); return
		 * new ResponseEntity<Object>(br,HttpStatus.NOT_FOUND);
		 */
		return new ResponseEntity<StudentResponseEntity>(
				new StudentResponseEntity(HttpStatus.NOT_FOUND.value(), snfe.getMessage(), System.currentTimeMillis()),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<StudentResponseEntity> handleNumberFormatException(NumberFormatException ipme) {
		return new ResponseEntity<StudentResponseEntity>(new StudentResponseEntity(HttpStatus.BAD_REQUEST.value(),
				"must provide numeric value", System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<StudentResponseEntity> handleGlobalException(Exception e) {
		return new ResponseEntity<StudentResponseEntity>(new StudentResponseEntity(HttpStatus.BAD_REQUEST.value(),
				"Something went wrong! Try agin", System.currentTimeMillis()), HttpStatus.BAD_REQUEST);

	}

}
