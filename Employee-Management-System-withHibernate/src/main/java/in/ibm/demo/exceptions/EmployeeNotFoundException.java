package in.ibm.demo.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7297436619418295469L;

	private String message;
	
	public EmployeeNotFoundException(String s) {
		this.message=s;
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
