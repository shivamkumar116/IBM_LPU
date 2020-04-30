package in.ibm.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import in.ibm.demo.dao.StudentDAO;
import in.ibm.demo.model.Student;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulStudentServiceApplication implements CommandLineRunner{
@Autowired
private StudentDAO studentDao;
	
	public static void main(String[] args) {
		SpringApplication.run(ConsulStudentServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	studentDao.save(new Student("shivam", "mca", "LPU"));
	studentDao.save(new Student("Ayush", "mca", "LPU"));
	studentDao.save(new Student("Ankit", "mca", "DU"));
	
	}

}
