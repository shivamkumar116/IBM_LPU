package in.ibm.demo.client;

import org.springframework.stereotype.Component;

@Component
public class EmployeeFallback implements EmployeeClient
{

	@Override
	public String callHi(String name) {
		
		return "<p>Service is not available. We are working to fix it soon!!</p>";
	}

}
