package in.ibm.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import in.ibm.demo.exceptions.EmployeeNotFoundException;
import in.ibm.demo.exceptions.EmployeeResponseEntity;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

	
	//Employee not found exception handler
	@ExceptionHandler
	public ResponseEntity<EmployeeResponseEntity> handlesExeption(EmployeeNotFoundException enfe) {
		return new ResponseEntity<EmployeeResponseEntity>(new EmployeeResponseEntity(HttpStatus.NOT_FOUND.value(),
				enfe.getMessage(), System.currentTimeMillis()), HttpStatus.NOT_FOUND);

	}
	
	//Global Exception handler
	@ExceptionHandler
	public ResponseEntity<EmployeeResponseEntity> handlesExeption(Exception enfe) {
		return new ResponseEntity<EmployeeResponseEntity>(new EmployeeResponseEntity(HttpStatus.BAD_REQUEST.value(),
			"Something went wrong!", System.currentTimeMillis()), HttpStatus.BAD_REQUEST);

	}
}
