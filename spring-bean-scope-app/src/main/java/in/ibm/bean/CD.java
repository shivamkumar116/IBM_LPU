package in.ibm.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CD {

	private String cdID;
	private String cdTitle;
	private int cdYear;

	public CD() {
		// TODO Auto-generated constructor stub
	}

	public CD(String cdTitle, int cdYear) {
		super();
		this.cdTitle = cdTitle;
		this.cdYear = cdYear;
	}

	public void getDetails() {
		System.out.printf("CD_ID: %s CD_NAME: %s CD YEAR %d\n", getCdID(), getCdTitle(), getCdYear());
	}

}
