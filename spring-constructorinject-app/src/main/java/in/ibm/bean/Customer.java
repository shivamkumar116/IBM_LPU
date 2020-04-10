package in.ibm.bean;

import lombok.ToString;

@ToString
public class Customer {

	private String customerID;
	private String customerName;
	private Address address;

	public Customer() {
		super();
	}

	public Customer(String customerName, Address address) {
		super();
		this.customerName = customerName;
		this.address = address;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

}
