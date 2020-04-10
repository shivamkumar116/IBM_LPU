package in.ibm.demo;

import java.util.UUID;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ibm.bean.Customer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       Customer objCustomer = context.getBean("customer",Customer.class);
       objCustomer.setCustomerID(UUID.randomUUID().toString());
       System.out.println(objCustomer);
    }
}
