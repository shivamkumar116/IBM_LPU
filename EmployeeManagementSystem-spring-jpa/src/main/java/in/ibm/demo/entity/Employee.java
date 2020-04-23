package in.ibm.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "employee")
@Data
@ApiModel(description = "All details about the Employee")
public class Employee {

	@ApiModelProperty(notes = "The database generated employeeID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int employeeID;

	@ApiModelProperty(notes = "Employee's first name")
	@Column(name = "firstname")
	private String firstname;

	@ApiModelProperty(notes = "Employee's last name")
	@Column(name = "lastname")
	private String lastname;

	@ApiModelProperty(notes = "Employee's email")
	@Column(name = "email")
	private String email;
	
	public Employee() {
		
	}

	public Employee(String firstname, String lastname, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + "]";
	}

}
