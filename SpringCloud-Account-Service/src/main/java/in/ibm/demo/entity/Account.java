package in.ibm.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="accounts")
@Data
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String customerID;
	
	@Column(name = "account_number",unique = true)
	private int number;
	
	public Account() {
		
	}

	public Account(String customerID, int number) {
		super();
		this.customerID = customerID;
		
		this.number = number;
	}
	
	
	

}
