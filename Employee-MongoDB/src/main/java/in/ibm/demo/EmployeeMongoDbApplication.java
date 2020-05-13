package in.ibm.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableAutoConfiguration
public class EmployeeMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMongoDbApplication.class, args);
	}

}
