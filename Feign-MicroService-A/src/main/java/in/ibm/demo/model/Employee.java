package in.ibm.demo.model;



import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee {



	private String name;
	private String email;
	private String departmentname;

	public Employee(String name, String email, String departmentname) {
		super();
		this.name = name;
		this.email = email;
		this.departmentname = departmentname;
	}

}
