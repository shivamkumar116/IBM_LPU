package in.ibm.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Data;

@Entity
@Data
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@Version
	private int version;

	private double salary;

	public Employee() {
	}

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

}
