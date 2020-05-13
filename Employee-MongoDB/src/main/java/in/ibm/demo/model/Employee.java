package in.ibm.demo.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;


@Document
@NoArgsConstructor
@Data
public class Employee {
	
	@Id
	private int id;
	private String name;
	private String email;
	public Employee(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	
}
