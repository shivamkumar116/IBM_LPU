package in.ibm.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ibm.demo.entity.Project;
import in.ibm.demo.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Project.class).buildSessionFactory();
		
		Session session= factory.openSession();
		
	try {
		Student student= new Student("Shivam", "Kumar", "shivamkumar116");
		Project project = new Project("Hibernate one to one", true);
		student.setProject(project);
		session.beginTransaction();
		System.out.println("Saving"+ student);
		session.save(student);
		session.getTransaction().commit();
		System.out.println("done!!");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
}
