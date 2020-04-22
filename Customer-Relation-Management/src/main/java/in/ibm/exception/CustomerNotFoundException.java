package in.ibm.exception;

public class CustomerNotFoundException extends Throwable {


	private static final long serialVersionUID = 5656508580691739924L;
	
	private String message;
	
	public CustomerNotFoundException(String s) {
		super();
		this.message=s;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
