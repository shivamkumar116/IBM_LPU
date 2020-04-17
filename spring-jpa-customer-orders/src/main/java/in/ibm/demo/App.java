package in.ibm.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import in.ibm.demo.Entity.Customer;
import in.ibm.demo.Entity.Orders;
import in.ibm.demo.dao.CustomerDAO;
import in.ibm.demo.dao.CustomerDAOImpl;
import in.ibm.demo.dao.OrderDAO;
import in.ibm.demo.dao.OrderDAOImpl;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDAO dao = context.getBean("customerDAOImpl", CustomerDAOImpl.class);
		OrderDAO dao1 = context.getBean("orderDAOImpl", OrderDAOImpl.class);
		Customer customer = new Customer();
		customer.setName("Shivam");
		customer.setAddress("Gopalpur");
		Orders order = new Orders();
		order.setPrice(1000.00);
		customer.getOrders().add(order);
		dao.createCustomer(customer);
	
	}
}
