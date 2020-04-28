package in.ibm.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import in.ibm.demo.dao.CustomerDAO;
import in.ibm.demo.entity.Customer;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudCustomerServiceApplication implements CommandLineRunner {

	private CustomerDAO customerDao;
	
	
	@Autowired
	public SpringCloudCustomerServiceApplication(CustomerDAO customerDao) {
		super();
		this.customerDao = customerDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudCustomerServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerDao.save(new Customer("Shivam"));
		customerDao.save(new Customer("Renu"));
		customerDao.save(new Customer("Manish"));
		
		
	}

}
