package in.ibm.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ConsulZuulProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulZuulProxyApplication.class, args);
	}

}
