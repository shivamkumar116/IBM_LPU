package in.ibm.demo.exception;

public class SchoolNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public SchoolNotFoundException(String message) {
		super();
		this.message = message;
	}

	public SchoolNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
