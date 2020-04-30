package in.ibm.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="students")
@Data
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollnumber;
	private String name;
	private String classname;
	private String schoolname;
	
	public Student() {
		
	}

	public Student(String name, String classname, String schoolname) {
		super();
		this.name = name;
		this.classname = classname;
		this.schoolname = schoolname;
	}


	

}
