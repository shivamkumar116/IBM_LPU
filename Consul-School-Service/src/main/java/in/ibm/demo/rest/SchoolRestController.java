package in.ibm.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ibm.demo.exception.SchoolNotFoundException;
import in.ibm.demo.exception.SchoolResponseEntity;
import in.ibm.demo.service.SchoolService;

@RestController
public class SchoolRestController {

	@Autowired
	private SchoolService schoolService;

	@GetMapping("/getStudentBySchoolName/{schoolName}")
	public ResponseEntity<List<Object>> getStudentBySchoolName(@PathVariable String schoolName) {
		List<Object> s = schoolService.getStudents(schoolName);
		if (s.isEmpty() )
			throw new SchoolNotFoundException("not Such School - " + schoolName);
		else
			return ResponseEntity.ok().body(s);
	}

	@ExceptionHandler
	public ResponseEntity<SchoolResponseEntity> handlesExeption(SchoolNotFoundException snfe) {
		return new ResponseEntity<SchoolResponseEntity>(
				new SchoolResponseEntity(HttpStatus.NOT_FOUND.value(), snfe.getMessage(), System.currentTimeMillis()),
				HttpStatus.NOT_FOUND);

	}
}
