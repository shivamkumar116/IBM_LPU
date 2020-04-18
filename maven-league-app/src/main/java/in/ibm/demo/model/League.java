package in.ibm.demo.model;

public class League {

	private String title;
	private int year;
	private String session;
	
	
	public League(String title, int year, String session) {
		super();
		this.title = title;
		this.year = year;
		this.session = session;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}

}
