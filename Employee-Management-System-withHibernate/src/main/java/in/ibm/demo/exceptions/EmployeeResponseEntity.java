package in.ibm.demo.exceptions;

public class EmployeeResponseEntity {

	private int statusCode;
	private String message;
	private long time;

	public EmployeeResponseEntity(int statusCode, String message, long time) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.time = time;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

}
