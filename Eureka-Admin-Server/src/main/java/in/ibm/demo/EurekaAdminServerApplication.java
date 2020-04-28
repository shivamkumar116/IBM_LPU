package in.ibm.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class EurekaAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaAdminServerApplication.class, args);
	}

}
