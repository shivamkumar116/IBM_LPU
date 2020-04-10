package in.ibm.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ibm.dao.PersonDao;
import in.ibm.dao.PersonDaoImpl;

/**
 * Hello world!
 *
 */
public class App {
	
	
	public static void main(String[] args) {
	
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonDao p1= context.getBean("personDao",PersonDaoImpl.class);
		System.out.println(p1.getPersonInfo());
	}

}
