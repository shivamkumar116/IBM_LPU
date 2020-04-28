package in.ibm.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import in.ibm.demo.dao.ImageDAO;
import in.ibm.demo.entity.Image;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaImageServiceApplication implements CommandLineRunner {

	@Autowired
	private ImageDAO imageDao;
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaImageServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		imageDao.save(new Image("one.jpg","test image"));
		imageDao.save(new Image("two.jpg","test image"));
		imageDao.save(new Image("three.jpg","test image"));
		
	}

}
