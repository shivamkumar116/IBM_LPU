package in.ibm.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountProducerRabbitMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountProducerRabbitMqApplication.class, args);
	}

}
