package in.ibm.demo.model;

import lombok.Data;

@Data
public class MyUser {

	private String userName;
	private String password;
	private String roles;

	public MyUser() {

	}

	public MyUser(String userName, String password, String roles) {
		super();
		this.userName = userName;
		this.password = password;
		this.roles = roles;
	}

}
