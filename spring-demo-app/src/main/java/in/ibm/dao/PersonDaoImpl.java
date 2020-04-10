package in.ibm.dao;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ibm.bean.Person;

public class PersonDaoImpl implements PersonDao {

	@Override
	public Person getPersonInfo() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person P = context.getBean("person",Person.class);
		return P;
	}

}
