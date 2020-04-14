package in.ibm.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Cleanup;
import lombok.Data;


@Entity
@Data
@Table(name = "customer")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = -7204640055651476395L;
	@Id
	@Column(name="id")
	private String customerID;
	@Column(name = "name")
	private String customerName;
	@Column(name = "email")
	private String customerEmail;
	@Column(name = "isActive")
	private boolean isActive;

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", isActive=" + isActive + "]";
	}

}
