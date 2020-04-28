package in.ibm.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloWorldService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String sayHelloService() {
		return restTemplate.getForObject("http://HELLO-SERVICE/hi",String.class);
	}

}
