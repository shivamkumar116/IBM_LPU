package in.ibm.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import in.ibm.exception.CustomerNotFoundException;
import in.ibm.exception.CustomerResponseEntity;

@ControllerAdvice
public class CustomerRestExeceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomerResponseEntity> handleException(CustomerNotFoundException cnfe) {
		return new ResponseEntity<CustomerResponseEntity>(
				new CustomerResponseEntity(HttpStatus.NOT_FOUND.value(), cnfe.getMessage(), System.currentTimeMillis()),
				HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler
	public ResponseEntity<CustomerResponseEntity> handleException(Exception cnfe) {
		return new ResponseEntity<CustomerResponseEntity>(
				new CustomerResponseEntity(HttpStatus.BAD_REQUEST.value(), cnfe.getMessage(), System.currentTimeMillis()),
				HttpStatus.BAD_REQUEST);

	}

}
