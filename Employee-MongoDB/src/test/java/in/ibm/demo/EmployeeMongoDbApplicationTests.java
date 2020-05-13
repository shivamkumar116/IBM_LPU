package in.ibm.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import in.ibm.demo.dao.EmployeeDAO;
import in.ibm.demo.model.Employee;

@SpringBootTest
@RunWith(SpringRunner.class)
class EmployeeMongoDbApplicationTests {

	@MockBean
	private EmployeeDAO employeeDao;

	@Test
	public void getUsersTest() {
		when(employeeDao.findAll()).thenReturn(Stream.of(new Employee("shivam", "shivamkumar116@gmail.com"),
				new Employee("Manish", "shivamkumar116@gmail.com")).collect(Collectors.toList()));
		assertEquals(2, employeeDao.findAll().size());
	}

}
