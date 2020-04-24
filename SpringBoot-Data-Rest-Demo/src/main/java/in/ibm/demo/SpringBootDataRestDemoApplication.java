package in.ibm.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.ibm.demo.dao.ImageDAO;

@SpringBootApplication
public class SpringBootDataRestDemoApplication {
	
	private ImageDAO imageDAO;
	
	@Autowired
	public SpringBootDataRestDemoApplication(ImageDAO imageDAO) {
		super();
		this.imageDAO = imageDAO;
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataRestDemoApplication.class, args);
	}

}
