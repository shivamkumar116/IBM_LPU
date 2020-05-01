package in.ibm.demo.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import feign.FeignException.NotFound;
import in.ibm.demo.model.Employee;

@Component
public class EmployeeFallback implements EmployeeClient {

	@Override
	public String callHi(String name) {

		return "<p>Service is not available. We are working to fix it soon!!</p>";
	}

	@Override
	@SuppressWarnings("unchecked")
	public ResponseEntity<Iterable<Employee>> getEmployees(String departmentName) {
		
		return new ResponseEntity("Service down",HttpStatus.SERVICE_UNAVAILABLE);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity<Employee> save(Employee employee) {
		// TODO Auto-generated method stub
		return new ResponseEntity("service down",HttpStatus.SERVICE_UNAVAILABLE);
	}

}
