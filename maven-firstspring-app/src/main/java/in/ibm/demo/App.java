package in.ibm.demo;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ibm.beans.Coach;
import in.ibm.beans.CricketCoach;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			Coach coach = context.getBean("myCoach", CricketCoach.class);
			System.out.println(coach.getDailyWorkout());
			System.out.println(coach.getDailyFortune());
		} catch (BeansException e) {

			e.printStackTrace();
		}
	}
}
