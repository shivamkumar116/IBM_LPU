package in.ibm.exception;

public class StudentNotFoundException extends Throwable {

	private static final long serialVersionUID = 1L;

	private String message;

	public StudentNotFoundException(String s) {
		super();
		this.message = s;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "StudentNotFoundException [message=" + message + "]";
	}

}
